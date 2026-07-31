package com.siddhant.whatsapp.presentation.viewModel

import androidx.hilt.navigation.compose.hiltViewModel



import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.siddhant.whatsapp.presentation.viewModel.AuthState
import com.siddhant.whatsapp.presentation.viewModel.AuthViewModel

@Composable
fun AuthScreen(
    phoneNumber: String,
    onLoginSuccess: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val activity = context as Activity

    val verificationId by remember { mutableStateOf<String?>(null) }

    var otp by remember {
        mutableStateOf("")
    }

    val authState by viewModel.auth.collectAsStateWithLifecycle()


    LaunchedEffect(authState) {

        when (val state = authState) {

            is AuthState.Success -> {
                onLoginSuccess()
            }

            is AuthState.Error -> {
                Toast.makeText(
                    context,
                    state.message,
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> {

            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Enter OTP",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF128C7E)
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "We have sent a verification code to",
            fontSize = 14.sp
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text = phoneNumber,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        TextField(
            value = otp,
            onValueChange = {

                if (it.length <= 6 && it.all { char -> char.isDigit() }) {
                    otp = it
                }

            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Enter 6 digit OTP")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {

                if (otp.length == 6) {



                } else {

                    Toast.makeText(
                        context,
                        "Enter 6 digit OTP",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF128C7E)
            )
        ) {

            if (authState is AuthState.Loading) {

                CircularProgressIndicator(
                    color = Color.White
                )

            } else {

                Text(
                    text = "Verify OTP",
                    fontSize = 16.sp
                )
            }
        }
    }
}
