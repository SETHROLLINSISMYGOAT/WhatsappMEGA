package com.siddhant.whatsapp.presentation.TopBar

import android.R.attr.onClick
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddhant.whatsapp.R

@Composable
@Preview(showSystemUi = true)
fun TopAppBAR(){
    var isSearching by remember { mutableStateOf(false) }
    var search by remember { mutableStateOf("") }
    var showMenu by remember { mutableStateOf(true) }
    Box(modifier= Modifier.fillMaxWidth()){
        Column{
            Row(horizontalArrangement = Arrangement.SpaceBetween){
                if(isSearching){
                    TextField(
                        value=search,
                        onValueChange = {search=it}, placeholder = {Text("Search")}

                    )
                }else{
                    Text(

                        text="Updates",
                        fontSize=28.sp,
                        fontWeight = FontWeight.Bold,
                        color=Color.Black,
                        modifier=Modifier.padding(start=10.dp,top=10.dp)


                    )
                }
                Spacer(Modifier.weight(1f))
                if(isSearching){
                    IconButton(onClick = {isSearching=false
                    search=""}) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }
                else{
                    IconButton(onClick = {isSearching=true}){
                        Image(painter=painterResource(R.drawable.camera),
                            contentDescription = null,
                            Modifier.size(24.dp))
                    }
                    Spacer(Modifier.width(20.dp))
                    IconButton(onClick = {}){
                        Image(painter=painterResource(R.drawable.search),
                            contentDescription = null,
                            Modifier.size(54.dp))
                    }
                    Spacer(Modifier.width(24.dp))
                    IconButton(onClick = {showMenu=true}){
                        Image(painter=painterResource(R.drawable.dot),
                            contentDescription = null,
                            Modifier.size(54.dp))
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Text("Status Privacy")
                                },
                                onClick = {
                                    showMenu = false
                                }
                            )
                            DropdownMenuItem(
                                text = {
                                    Text("Create Channel")
                                },
                                onClick = {
                                    showMenu = false
                                }
                            )
                            DropdownMenuItem(
                                text = {
                                    Text("Settings")
                                },
                                onClick = {
                                    showMenu = false
                                }
                            )
                        }
                    }
                }

            }
            HorizontalDivider()

        }

    }
}