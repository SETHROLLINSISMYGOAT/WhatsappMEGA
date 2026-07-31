package com.siddhant.whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.siddhant.whatsapp.presentation.Navigation.WhatsappNavigationScreen
import com.siddhant.whatsapp.presentation.SplashScreen.SplashScreen


import com.siddhant.whatsapp.ui.theme.WhatsappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsappTheme {
                WhatsappNavigationScreen()

            }
        }
    }
}

