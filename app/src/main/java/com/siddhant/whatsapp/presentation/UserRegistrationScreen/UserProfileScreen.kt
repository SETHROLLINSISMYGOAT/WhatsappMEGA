package com.siddhant.whatsapp.presentation.UserRegistrationScreen

import com.siddhant.whatsapp.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showSystemUi = true)
fun UserProfileScreen() {
    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("India") }
    var countryCode by remember { mutableStateOf("+91") }
    var phoneNumber by remember { mutableStateOf("") }


    val countryMap = mapOf(
        "India" to "+91",
        "Japan" to "+81",
        "USA" to "+1",
        "Canada" to "+1",
        "Russia" to "+7"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter your Phone Number",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier=Modifier.padding(top=30.dp),
            color = Color(0xFF128C7E)
        )

        Spacer(Modifier.height(24.dp))

        Row {
            Text(text = "WhatsApp will need to verify your number ")
            Text(text = "what's", color = Color(0xFF128C7E))
        }
        Text(text = "my number?", color = Color(0xFF128C7E))

        Spacer(modifier = Modifier.height(16.dp))


        Box(contentAlignment = Alignment.Center) {
            TextButton(
                onClick = { expanded = true },
                modifier = Modifier.width(230.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = selectedCountry,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(8.dp),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Select Country",
                        modifier = Modifier.align(Alignment.CenterEnd),
                        tint = colorResource(R.color.dark_green)
                    )
                }
            }


            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                countryMap.keys.forEach { country ->
                    DropdownMenuItem(
                        text = { Text(text = country) },
                        onClick = {
                            selectedCountry = country
                            countryCode = countryMap[country] ?: ""
                            expanded = false
                        }
                    )
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 66.dp),
            thickness = 2.dp,
            color = colorResource(R.color.dark_green)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = countryCode,
                onValueChange = { countryCode = it },
                modifier = Modifier.weight(0.3f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                modifier = Modifier.weight(0.7f),
                placeholder = { Text("Phone Number") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Carrier charges may apply",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Button(
            onClick = { /* TODO: Handle Next */ },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF128C7E))
        ) {
            Text("Next", fontSize = 16.sp)
        }
    }
}