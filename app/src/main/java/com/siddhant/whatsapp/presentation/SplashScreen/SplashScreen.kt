package com.siddhant.whatsapp.presentation.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.siddhant.whatsapp.R
import com.siddhant.whatsapp.presentation.Navigation.Routes
import kotlinx.coroutines.delay

@Composable

fun splashScreen(navHostController: NavHostController){
    LaunchedEffect(Unit) {
        delay(1000)
        navHostController.navigate(Routes.WelcomeScreen){
            popUpTo<Routes.SplashScreen>{inclusive=true}
        }

    }
    Box(modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Image(painter=painterResource(R.drawable.wh), contentDescription = null, Modifier.size(100.dp))
        Column(modifier = Modifier.align(Alignment.BottomCenter).padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text="From", fontWeight = FontWeight.Bold, fontSize = 28.sp)

            Icon(painterResource(R.drawable.meta)
                , contentDescription = null,
                modifier=Modifier.size(80.dp),tint= colorResource(R.color.blue)
            )



        }

    }


}