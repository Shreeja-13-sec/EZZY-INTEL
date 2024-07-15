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
fun FindService(navController: NavHostController){
    Column (modifier = Modifier.fillMaxSize().background(Color.LightGray), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement= Arrangement.Center ) {
        Button(
            onClick = { navController.navigate("healthFind") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Health Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("transportationFind") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Transportation Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("educationFind") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Education Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("financeFind") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Finance Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("govServicesFind") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Government Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("houseServicesFind") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Housing Services", color = Color.White)
        }
    }
}