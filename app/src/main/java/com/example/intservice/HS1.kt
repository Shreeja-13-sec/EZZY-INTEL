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
fun houseServicesReg(navController: NavHostController){

    val context = LocalContext.current
    var serviceType by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var serviceLocation by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var mailId by remember { mutableStateOf("") }

    Column(modifier = Modifier.background(Color(0xFFFFCCFF))) {
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

            val db = Firebase.firestore

            Text(
                text = "Housing Service Registration",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = serviceType, onValueChange = { serviceType = it },  label = { Text("Service Type") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Carpenter, Electrician, maid...",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = name, onValueChange = { name = it },  label = { Text("Name") },
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
            OutlinedTextField(value = age, onValueChange = { age = it },  label = { Text("Age") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Your age",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = gender, onValueChange = { gender = it },  label = { Text("Gender") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "M/F",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = serviceLocation, onValueChange = { serviceLocation = it },  label = { Text("Service Location") },
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
            OutlinedTextField(value = experience, onValueChange = { experience = it },  label = { Text("Experience") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "1 year,6 months...",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = description, onValueChange = { description = it },  label = { Text("Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                placeholder = {
                    Text(
                        text = "Describe yourself",
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
            OutlinedTextField(value = mailId, onValueChange = { mailId = it },  label = { Text("Mail ID") },
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
                    if (serviceType.isNotEmpty() && name.isNotEmpty() && serviceLocation.isNotEmpty() && age.isNotEmpty() && gender.isNotEmpty() && experience.isNotEmpty() && description.isNotEmpty() && phoneNumber.isNotEmpty() && mailId.isNotEmpty()) {
                        val house = hashMapOf(
                            "Service Type" to serviceType,
                            "Name" to name,
                            "Service Location" to serviceLocation,
                            "Experience" to experience,
                            "Age" to age,
                            "Gender" to gender,
                            "Description" to description,
                            "Phone Number" to phoneNumber,
                            "Mail Id" to mailId
                        )
                        db.collection("housingServices")
                            .add(house)
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
