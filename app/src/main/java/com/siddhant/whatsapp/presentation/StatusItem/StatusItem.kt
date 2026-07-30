package com.siddhant.whatsapp.presentation.StatusItem

import android.text.style.IconMarginSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddhant.whatsapp.R

@Composable
@Preview(showSystemUi = true)
fun StatusItem(){
    Row(modifier=Modifier.fillMaxWidth().padding(10.dp)){
        Box(
            modifier = Modifier.size(60.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.becky),
                contentDescription = null,

                )

            Icon(
                painter = painterResource(R.drawable.add),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(25.dp).padding(2.dp).background(color= colorResource( R.color.dark_green),shape=RoundedCornerShape(12.dp))
            )
        }
        Column(){
            Text(text="My Status", fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(text="Tap to add Status Update",fontSize = 15.sp)

        }

    }

}
