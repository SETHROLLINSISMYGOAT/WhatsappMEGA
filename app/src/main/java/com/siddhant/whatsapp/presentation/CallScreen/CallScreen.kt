package com.siddhant.whatsapp.presentation.CallScreen

import android.os.Message
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddhant.whatsapp.presentation.TopBar.TopAppBAR
import com.siddhant.whatsapp.R
import com.siddhant.whatsapp.presentation.BottomNavigationBar
import kotlin.contracts.contract

@Composable
@Preview(showSystemUi = true)
fun CallScreen() {
    val sample=listOf(FavouriteContact(image=R.drawable.ms,"MSD"), FavouriteContact(image=R.drawable.vk,name="Virat Kohli"),
        FavouriteContact(R.drawable.becky,name="Becky"), FavouriteContact(R.drawable.seth,name="Seth Rollins"))
    val sampleCall = listOf(Call(
        name = "Becky",
        image = R.drawable.becky,
        time = "Yesterday, 8:30 PM",
        isMissed = true
    ),Call(
        name = "Virat Kohli",
        image = R.drawable.vk,
        time = "Today, 10:15 AM",
        isMissed = false
    ))
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = colorResource(R.color.dark_green),
                contentColor = Color.White,
                modifier = Modifier.size(65.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.call),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }
        }

    ){innerPadding->
        Column(modifier=Modifier.fillMaxSize().padding(10.dp).padding(innerPadding)){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                ) {
                Text(
                    text = "Calls",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top=10.dp)

                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(44.dp)
                )

                Image(
                    painter = painterResource(R.drawable.dot),
                    contentDescription = null,
                    modifier = Modifier.size(44.dp)
                )

            }

            HorizontalDivider()
            Spacer(modifier= Modifier.height(10.dp))

            Text("Favorites", modifier = Modifier.padding(10.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier= Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                sample.forEach { contact ->

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(contact.image),
                            contentDescription = contact.name,
                            modifier = Modifier.size(60.dp).clip(CircleShape)

                        )

                        Text(contact.name)

                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(16.dp), colors= ButtonDefaults.buttonColors(containerColor = colorResource( R.color.dark_green))) {
                Text(text="Start a new call", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Recent calls", modifier = Modifier.padding(start=10.dp), fontWeight = FontWeight.Bold, fontSize = 20.sp)
            LazyColumn {
                items(sampleCall){
                        contract -> CallItemDesign(contract)

                }
            }
        }
    }







}

data class FavouriteContact(var image:Int,var name: String)