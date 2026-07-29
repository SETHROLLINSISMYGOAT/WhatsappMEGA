package com.siddhant.whatsapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddhant.whatsapp.R

@Composable
@Preview(showSystemUi = true)
fun BottomNavigationBar() {

    BottomAppBar {


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,

        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.chat),
                    contentDescription = "Chats",
                    modifier = Modifier.size(24.dp) // Controls image size
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Chats",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }

            // Column 2: Updates
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.update),
                    contentDescription = "Updates",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Updates",
                    fontSize = 12.sp
                )
            }

            // Column 3: Communities
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.community),
                    contentDescription = "Communities",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Communities",
                    fontSize = 12.sp
                )
            }

            // Column 4: Calls
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.call),
                    contentDescription = "Calls",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Calls",
                    fontSize = 12.sp
                )
            }
        }
    }
}


