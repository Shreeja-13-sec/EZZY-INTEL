package com.example.intservice

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun TRCentre(navController: NavHostController){

    val context = LocalContext.current
    var vehicleType by remember { mutableStateOf("") }
    var centreName by remember { mutableStateOf("") }
    var centreLocation by remember { mutableStateOf("") }
    var centreAddress by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var mailId by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    Column(modifier = Modifier.background(Color(0xFF99FF99)), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            val db = Firebase.firestore

            Text(
                text = "Transportation Centre Registration",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = vehicleType, onValueChange = { vehicleType = it }, label = { Text("Vehicle Type") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Car, Bike, Van, Bus...",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = centreName, onValueChange = { centreName = it }, label = { Text("Centre Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Name of Centre",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = price, onValueChange = { price = it }, label = { Text("Price") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Price per km, waiting charge details",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = centreLocation, onValueChange = { centreLocation = it }, label = { Text("Centre Location") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Location: Chennai, Trichy, Mumbai, Bangalore...",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = centreAddress, onValueChange = { centreAddress = it }, label = { Text("Centre Address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Address of Institute",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Provide details about your facilities",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = phoneNumber, onValueChange = { phoneNumber = it }, label = { Text("Phone Number") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "+91 xxxxxxxxxx",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = mailId, onValueChange = { mailId = it }, label = { Text("Mail ID") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "xyz@abc.com else NIL",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    if (vehicleType.isNotEmpty() && centreName.isNotEmpty() && centreLocation.isNotEmpty() && centreAddress.isNotEmpty() && description.isNotEmpty() && phoneNumber.isNotEmpty() && mailId.isNotEmpty() && price.isNotEmpty()) {
                        val centre = hashMapOf(
                            "Vehicle Type" to vehicleType,
                            "Centre Name" to centreName,
                            "Price" to price,
                            "Centre Location" to centreLocation,
                            "Centre Address" to centreAddress,
                            "Description" to description,
                            "Phone Number" to phoneNumber,
                            "Mail Id" to mailId
                        )
                        db.collection("transportationCentre")
                            .add(centre)
                            .addOnSuccessListener { documentReference ->
                                Toast.makeText(
                                    context,
                                    "Record Insert with ID: ${documentReference.id}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()

                            }
                    } else {
                        Toast.makeText(context, "Please insert record first", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray
                ),
                modifier = Modifier.width(130.dp).padding(16.dp)
            ) {
                Text(
                    text = "Submit"
                )
            }
        }
    }
}