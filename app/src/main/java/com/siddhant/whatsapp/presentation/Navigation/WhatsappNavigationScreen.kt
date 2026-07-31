package com.siddhant.whatsapp.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

import com.siddhant.whatsapp.presentation.WelcomeScreen.WelcomeScreen
import com.siddhant.whatsapp.presentation.UserRegistrationScreen.UserRegistrationScreen
import com.siddhant.whatsapp.presentation.HomeScreen.HomeScreen
import com.siddhant.whatsapp.presentation.UpdateScreen.UpdateScreen
import com.siddhant.whatsapp.presentation.CallScreen.CallScreen
import com.siddhant.whatsapp.presentation.SplashScreen.SplashScreen
import com.siddhant.whatsapp.presentation.viewModel.AuthScreen


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
        composable<Routes.AuthScreen> {
            val route = it.toRoute<Routes.AuthScreen>()

            AuthScreen(
                phoneNumber = route.phoneNumber,
                onLoginSuccess = {
                    navController.navigate(Routes.HomeScreen)
                }
            )
        }

        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Routes.UserRegistrationScreen> {
            UserRegistrationScreen(navController)
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