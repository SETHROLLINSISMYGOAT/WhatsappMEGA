package com.siddhant.whatsapp.presentation.UpdateScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddhant.whatsapp.R
import com.siddhant.whatsapp.presentation.BottomNavigationBar
import com.siddhant.whatsapp.presentation.StatusItem.StatusItem
import com.siddhant.whatsapp.presentation.TopBar.TopAppBAR

@Composable
@Preview(showSystemUi = true)
fun UpdateScreen(){
    Scaffold(
        floatingActionButton={
            FloatingActionButton(
                onClick = {},
                containerColor = colorResource(R.color.dark_green),
                modifier = Modifier.size(65.dp),
                contentColor = Color.White

            ) {
                Icon(painter= painterResource(R.drawable.camera), contentDescription = null)
            }
        },
        bottomBar={
            BottomNavigationBar()
        },
        topBar={
            TopAppBAR()
        }


    ){innerPadding->
        Column(modifier=Modifier.padding(innerPadding).verticalScroll(rememberScrollState())){
            Text(text="Status", fontSize = 20.sp, fontWeight = FontWeight.Bold,color=Color.Black,modifier=Modifier.padding(horizontal = 12.dp, vertical = 8.dp))
            StatusItem()

        }
    }
}