package com.example.intservice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
   Column (modifier = Modifier.fillMaxSize().background(Color.LightGray), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement= Arrangement.Center ) {
       Button(
           onClick = {navController.navigate("FindService")},
           colors = ButtonDefaults.buttonColors(
               containerColor = Color.DarkGray
           ),
           modifier = Modifier.width(230.dp)
       ) {
           Text("Find a Service", color = Color.White)
       }
       Button(
           onClick = { navController.navigate("RegisterService")},
           colors = ButtonDefaults.buttonColors(
               containerColor = Color.DarkGray
           ),
           modifier = Modifier.width(230.dp)
       ) {
           Text("Register a Service", color = Color.White)
       }
   }
}











