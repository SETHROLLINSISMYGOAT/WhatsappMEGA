package com.siddhant.whatsapp.presentation.Navigation

import com.siddhant.whatsapp.presentation.viewModel.phoneAuthUser
import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object SplashScreen : Routes()
    @Serializable
    data object WelcomeScreen:Routes()
    @Serializable
    data object UserRegistrationScreen:Routes()
    @Serializable
    data object HomeScreen:Routes()
    @Serializable
    data object UpdateScreen:Routes()
    @Serializable
    data object CallScreen:Routes()
    @Serializable
    data class AuthScreen(val phoneNumber:String):Routes()


}