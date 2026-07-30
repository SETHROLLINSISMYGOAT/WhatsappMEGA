package com.siddhant.whatsapp.presentation.WelcomeScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.siddhant.whatsapp.R
import com.siddhant.whatsapp.presentation.Navigation.Routes

@Composable

fun WelcomeScreen(navHostController: NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(R.drawable.welcomescreen),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(300.dp)
        )


        Button(
            onClick = {navHostController.navigate(Routes.UserRegistrationScreen)},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF128C7E)
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
                .width(280.dp)
                .height(43.dp),
            shape = RoundedCornerShape(8.dp)

        ) {
            Text("Agree and Continue")
        }

    }

}