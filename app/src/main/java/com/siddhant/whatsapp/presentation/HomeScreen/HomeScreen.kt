package com.siddhant.whatsapp.presentation.HomeScreen
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddhant.whatsapp.R
import com.siddhant.whatsapp.presentation.BottomNavigationBar

@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    val chatData=listOf(ChatDesignModel(R.drawable.seth,name="Seth Rollins", time = "10:00AM",message="Hi")
    , ChatDesignModel(R.drawable.becky,name="Becky",time="9:00PM",message="Hi"),
        ChatDesignModel(R.drawable.ms,name="Dhoni",time="9:00PM",message="Hi"),
        ChatDesignModel(R.drawable.vk,name="Virat Kohli",time="9:00PM", message = "Hi"))
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = colorResource(R.color.dark_green),
                contentColor = Color.White,
                modifier = Modifier.size(65.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.chat),
                    contentDescription = "Chat",
                    modifier = Modifier.size(28.dp)
                )
            }
        },
        bottomBar={
            BottomNavigationBar()

        }

    )
    { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text="WhatsApp",
                    modifier = Modifier.align(Alignment.CenterStart).padding(start=8.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color=colorResource(R.color.dark_green)

                )
                Row(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.camera),
                            contentDescription = "Camera"
                        )
                    }

                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.search),
                            contentDescription = "Search",

                        )
                    }

                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.dot),
                            contentDescription = "More options"
                        )
                    }
                }
                // Your UI here
            }
            HorizontalDivider()
            LazyColumn {
                items(chatData) { chat ->
                    ChatDesign(chatDesignModel = chat)
                }
            }
        }

    }
}