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
fun transportationReg(navController: NavHostController){
    Column (modifier = Modifier.fillMaxSize().background(Color(0xFF99FF99)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement= Arrangement.Center ) {
        Button(
            onClick = {navController.navigate("TRSecondHand")},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Second Hand Transportation", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("TRCentre")},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Centre Registration", color = Color.White)
        }
    }
}