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
fun TRSecondHand(navController: NavHostController){
    val context = LocalContext.current
    var vehicleType by remember { mutableStateOf("") }
    var sellerName by remember { mutableStateOf("") }
    var vehiclePrice by remember { mutableStateOf("") }
    var vehicleCondition by remember { mutableStateOf("") }
    var vehicleModel by remember { mutableStateOf("") }
    var availabilityLocation by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var mailId by remember { mutableStateOf("") }

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
                text = "Second Hand Vehicles to Sell",
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
                        text = "Car, Bike, Scooty, Van...",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = sellerName, onValueChange = { sellerName = it }, label = { Text("Seller Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "First_name Last_name/Initial",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = vehiclePrice, onValueChange = { vehiclePrice = it }, label = { Text("Vehicle Price") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "9 Lakh, 1 Lakh, 70 Thousand, 40 Thousand...",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = vehicleCondition, onValueChange = { vehicleCondition = it }, label = { Text("Vehicle Condition") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Used for 8 months, good condition",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = vehicleModel, onValueChange = { vehicleModel = it }, label = { Text("Vehicle Model") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "2011 Model Honda, SRX Series...",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = availabilityLocation, onValueChange = { availabilityLocation = it }, label = { Text("Availability Location") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Location: Chennai, Mumbai, Bangalore...",
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
                    if (vehicleType.isNotEmpty() && vehicleModel.isNotEmpty() && vehiclePrice.isNotEmpty() && vehicleCondition.isNotEmpty() && sellerName.isNotEmpty() && availabilityLocation.isNotEmpty() && phoneNumber.isNotEmpty() && mailId.isNotEmpty()) {
                        val trans = hashMapOf(
                            "Vehicle Type" to vehicleType,
                            "Seller Name" to sellerName,
                            "Vehicle Price" to vehiclePrice,
                            "Vehicle Model" to vehicleModel,
                            "Vehicle Condition" to vehicleCondition,
                            "Location" to availabilityLocation,
                            "Phone Number" to phoneNumber,
                            "Mail Id" to mailId
                        )
                        db.collection("transportationSecondHand")
                            .add(trans)
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