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
fun RegisterService(navController: NavHostController){
    Column (modifier = Modifier.fillMaxSize().background(Color.LightGray), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement= Arrangement.Center ) {
        Button(
            onClick = { navController.navigate("healthReg") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Health Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("transportationReg") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Transportation Services", color = Color.White)
        }
        Button(
            onClick = {navController.navigate("educationReg")  },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Education Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("financeReg") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Finance Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("govServicesReg") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Government Services", color = Color.White)
        }
        Button(
            onClick = { navController.navigate("houseServicesReg") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            ),
            modifier = Modifier.width(230.dp)
        ) {
            Text("Housing Services", color = Color.White)
        }
    }
}