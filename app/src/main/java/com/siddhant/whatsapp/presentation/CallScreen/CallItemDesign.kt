package com.siddhant.whatsapp.presentation.CallScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddhant.whatsapp.R

@Composable
fun CallItemDesign(call: Call) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(call.image),
            contentDescription = call.name,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = call.name,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(

                            R.drawable.missed

                    ),
                    contentDescription = null,
                    tint = if (call.isMissed) Color.Red else Color(0xFF25D366),
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = call.time,
                    fontSize = 13.sp,
                    color = Color.Gray
                )

            }
        }
        IconButton(onClick = {}){
            Image(painter = painterResource(R.drawable.call), contentDescription = null,modifier=Modifier.size(25.dp))
        }


    }
}

data class Call(
    val name: String,
    val image: Int,
    val time: String,
    val isMissed: Boolean
)
@Preview(showSystemUi = true)
@Composable
fun CallItemDesignPreview() {

    val sampleCall = Call(
        name = "Becky",
        image = R.drawable.becky,
        time = "Yesterday, 8:30 PM",
        isMissed = true
    )

    CallItemDesign(call = sampleCall)
}