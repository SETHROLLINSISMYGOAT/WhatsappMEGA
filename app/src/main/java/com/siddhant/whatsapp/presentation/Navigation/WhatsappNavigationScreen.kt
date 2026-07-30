package com.siddhant.whatsapp.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.siddhant.whatsapp.presentation.WelcomeScreen.WelcomeScreen
import com.siddhant.whatsapp.presentation.UserRegistrationScreen.UserRegistrationScreen
import com.siddhant.whatsapp.presentation.HomeScreen.HomeScreen
import com.siddhant.whatsapp.presentation.UpdateScreen.UpdateScreen
import com.siddhant.whatsapp.presentation.CallScreen.CallScreen

@Composable
fun WhatsappNavigationScreen() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen
    ) {

        composable<Routes.SplashScreen> {
            SplashScreen(navController)
        }

        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Routes.UserRegistrationScreen> {
            UserRegistrationScreen()
        }

        composable<Routes.HomeScreen> {
            HomeScreen()
        }

        composable<Routes.UpdateScreen> {
            UpdateScreen()
        }

        composable<Routes.CallScreen> {
            CallScreen()
        }

    }
}