package com.example.intservice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.intservice.ui.theme.IntServiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntServiceTheme {
                Surface(
                    modifier=Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    NavHost(
                        navController= navController,
                        startDestination = "Home"
                    ) {
                        composable("Home"){
                            HomeScreen(navController = navController)
                        }
                        composable("FindService"){
                            FindService(navController = navController)
                        }
                        composable("RegisterService"){
                            RegisterService(navController = navController)
                        }
                        composable("healthReg"){
                            healthReg(navController = navController)
                        }
                        composable("HRIndividual"){
                            HRIndividual(navController = navController)
                        }
                        composable("HRInstitutional"){
                            HRInstitutional(navController = navController)
                        }
                        composable("healthFind"){
                           HealthFind(navController = navController)
                        }
                        composable("educationReg"){
                            educationReg(navController = navController)
                        }
                        composable("ERIndividual"){
                            ERIndividual(navController = navController)
                        }
                        composable("ERInstitutional"){
                            ERInstitutional(navController = navController)
                        }
                        composable("educationFind") {
                            educationFind(navController = navController)
                        }
                        composable("ERSecondHand") {
                            ERSecondHand(navController = navController)
                        }
                        composable("transportationReg") {
                            transportationReg(navController = navController)
                        }
                        composable("TRSecondHand") {
                            TRSecondHand(navController = navController)
                        }
                        composable("TRCentre") {
                            TRCentre(navController = navController)
                        }
                        composable("transportationFind") {
                            transportationFind(navController = navController)
                        }
                        composable("financeReg") {
                            financeReg(navController = navController)
                        }
                        composable("financeFind") {
                            financeFind(navController = navController)
                        }
                        composable("govServicesReg") {
                            govServicesReg(navController = navController)
                        }
                        composable("govServicesFind") {
                            govServicesFind(navController = navController)
                        }
                        composable("houseServicesReg") {
                            houseServicesReg(navController = navController)
                        }
                        composable("houseServicesFind") {
                            houseServicesFind(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
