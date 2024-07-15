package com.example.intservice

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun financeFind(navController: NavHostController) {
    val db = Firebase.firestore
    val context = LocalContext.current
    var res1 by remember { mutableStateOf("") }
    var res2 by remember { mutableStateOf("") }

    var location by remember { mutableStateOf("") }
    Column(modifier = Modifier.background(Color(0xFFFF9999))) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(value = location,
                onValueChange = { location = it },
                label = { Text("Location") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Enter Location",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    db.collection("finance")
                        .get()
                        .addOnSuccessListener { result ->
                            val data1 = StringBuffer()
                            val data2 = StringBuffer()
                            for (document in result) {
                                if (document.get("Bank Location") == location) {
                                    data1.append("Bank Name - " + document.get("Bank Name") + "\n")
                                    data1.append("Bank Address - " + document.get("Bank Address") + "\n")
                                    data1.append("Bank Location - " + document.get("Bank Location") + "\n")
                                    data1.append("Interest Rate - " + document.get("Interest Rate") + "\n")
                                    data1.append("Contact Number - " + document.get("Phone Number") + "\n")
                                    data1.append("Mail Id - " + document.get("Mail Id") + "\n\n")
                                } else {
                                    data2.append("Bank Name - " + document.get("Bank Name") + "\n")
                                    data2.append("Bank Address - " + document.get("Bank Address") + "\n")
                                    data2.append("Bank Location - " + document.get("Bank Location") + "\n")
                                    data2.append("Interest Rate - " + document.get("Interest Rate") + "\n")
                                    data2.append("Contact Number - " + document.get("Phone Number") + "\n")
                                    data2.append("Mail Id - " + document.get("Mail Id") + "\n\n")
                                }
                            }
                            res1 = data1.toString()
                            res2 = data2.toString()
                        }
                        .addOnFailureListener { exception ->
                            Toast.makeText(context, exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray
                ),
                modifier = Modifier.width(230.dp).padding(16.dp)
            ) {
                Text(
                    text = "FIND"
                )
            }
            Text(
                text = "SERVICES NEAR YOU",
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Column(horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center) {
                Text(
                    text = res1, fontSize = 14.sp, color = Color.Black
                )
            }
            Text(
                text = "SERVICES IN OTHER AREAS",
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Column(horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center) {
                Text(
                    text = res2, fontSize = 14.sp, color = Color.Black
                )
            }
        }
    }
}