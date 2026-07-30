package com.siddhant.whatsapp.presentation.viewModel

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val auth1: FirebaseAuth,
    private val database: FirebaseDatabase
) : ViewModel() {

    private val _auth = MutableStateFlow<AuthState>(AuthState.Idle)
    val auth = _auth.asStateFlow()

    private val userRef = database.reference.child("users")

    // ---------------------------------------------------------
    // SEND OTP
    // ---------------------------------------------------------

    fun sendVerificationCode(
        activity: Activity,
        phoneNumber: String
    ) {

        _auth.value = AuthState.Loading

        val callbacks =
            object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onVerificationCompleted(
                    credential: PhoneAuthCredential
                ) {

                    // Automatic verification
                    signInWithPhoneAuthCredential(
                        credential = credential,
                        context = activity
                    )
                }

                override fun onVerificationFailed(
                    e: FirebaseException
                ) {

                    _auth.value = AuthState.Error(
                        e.message ?: "Verification failed"
                    )
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {

                    _auth.value = AuthState.CodeSent(
                        verificationId = verificationId,
                        token = token
                    )
                }
            }

        val options = PhoneAuthOptions
            .newBuilder(auth1)
            .setPhoneNumber(phoneNumber)
            .setTimeout(
                60L,
                TimeUnit.SECONDS
            )
            .setActivity(activity)
            .setCallbacks(callbacks)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }


    // ---------------------------------------------------------
    // VERIFY OTP
    // ---------------------------------------------------------

    fun verifyOTP(
        verificationId: String,
        otp: String,
        context: Context
    ) {

        _auth.value = AuthState.Loading

        val credential = PhoneAuthProvider.getCredential(
            verificationId,
            otp
        )

        signInWithPhoneAuthCredential(
            credential = credential,
            context = context
        )
    }


    // ---------------------------------------------------------
    // SIGN IN WITH PHONE CREDENTIAL
    // ---------------------------------------------------------

    private fun signInWithPhoneAuthCredential(
        credential: PhoneAuthCredential,
        context: Context
    ) {

        _auth.value = AuthState.Loading

        auth1.signInWithCredential(credential)
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    val user = auth1.currentUser

                    if (user != null) {

                        // Save login state
                        markUserSignedIn(context)

                        // Now fetch profile from Realtime Database
                        fetchUserProfile(user.uid)

                    } else {

                        _auth.value = AuthState.Error(
                            "User not found"
                        )
                    }

                } else {

                    if (
                        task.exception
                                is FirebaseAuthInvalidCredentialsException
                    ) {

                        _auth.value = AuthState.Error(
                            "Invalid verification code"
                        )

                    } else {

                        _auth.value = AuthState.Error(
                            task.exception?.message
                                ?: "Sign in failed"
                        )
                    }
                }
            }
    }


    // ---------------------------------------------------------
    // FETCH USER PROFILE
    // ---------------------------------------------------------

    private fun fetchUserProfile(
        userId: String
    ) {

        userRef
            .child(userId)
            .get()
            .addOnSuccessListener { snapshot ->

                if (snapshot.exists()) {

                    val userProfile =
                        snapshot.getValue(phoneAuthUser::class.java)

                    if (userProfile != null) {

                        _auth.value =
                            AuthState.Success(userProfile)
                    } else {

                        _auth.value = AuthState.Error(
                            "Failed to read user profile"
                        )
                    }

                } else {

                    // User authenticated but profile
                    // does not exist yet.
                    val firebaseUser = auth1.currentUser

                    val newUser = phoneAuthUser(
                        userId = userId,
                        phoneNumber =
                            firebaseUser?.phoneNumber ?: ""
                    )

                    _auth.value =
                        AuthState.NewUser(newUser)
                }
            }
            .addOnFailureListener { exception ->

                _auth.value = AuthState.Error(
                    exception.message
                        ?: "Failed to fetch user profile"
                )
            }
    }


    // ---------------------------------------------------------
    // SAVE USER PROFILE
    // ---------------------------------------------------------

    fun saveUserProfile(
        userId: String,
        name: String,
        status: String,
        profileImage: String? = null
    ) {

        val firebaseUser = auth1.currentUser

        val userProfile = phoneAuthUser(
            userId = userId,
            phoneNumber = firebaseUser?.phoneNumber ?: "",
            name = name,
            status = status,
            profileImage = profileImage
        )

        userRef
            .child(userId)
            .setValue(userProfile)
            .addOnSuccessListener {

                _auth.value =
                    AuthState.Success(userProfile)
            }
            .addOnFailureListener { exception ->

                _auth.value = AuthState.Error(
                    exception.message
                        ?: "Failed to save user profile"
                )
            }
    }


    // ---------------------------------------------------------
    // MARK USER AS SIGNED IN
    // ---------------------------------------------------------

    private fun markUserSignedIn(
        context: Context
    ) {

        val sharedPreferences =
            context.getSharedPreferences(
                "app_prefs",
                Context.MODE_PRIVATE
            )

        sharedPreferences
            .edit()
            .putBoolean("isSignedIn", true)
            .apply()
    }


    // ---------------------------------------------------------
    // SIGN OUT
    // ---------------------------------------------------------

    fun signOut(
        context: Context
    ) {

        auth1.signOut()

        val sharedPreferences =
            context.getSharedPreferences(
                "app_prefs",
                Context.MODE_PRIVATE
            )

        sharedPreferences
            .edit()
            .putBoolean("isSignedIn", false)
            .apply()

        _auth.value = AuthState.Idle
    }


    // ---------------------------------------------------------
    // RESET STATE
    // ---------------------------------------------------------

    fun resetAuthState() {

        _auth.value = AuthState.Idle
    }
}


// =============================================================
// AUTH STATE
// =============================================================

sealed class AuthState {

    data object Idle : AuthState()

    data object Loading : AuthState()

    data class CodeSent(
        val verificationId: String,
        val token: PhoneAuthProvider.ForceResendingToken
    ) : AuthState()

    // Existing user with profile
    data class Success(
        val user: phoneAuthUser
    ) : AuthState()

    // Authentication successful but
    // profile doesn't exist in database
    data class NewUser(
        val user: phoneAuthUser
    ) : AuthState()

    data class Error(
        val message: String
    ) : AuthState()
}


// =============================================================
// USER MODEL
// =============================================================

data class phoneAuthUser(

    val userId: String = "",

    val phoneNumber: String = "",

    val name: String = "",

    val status: String = "",

    val profileImage: String? = null
)