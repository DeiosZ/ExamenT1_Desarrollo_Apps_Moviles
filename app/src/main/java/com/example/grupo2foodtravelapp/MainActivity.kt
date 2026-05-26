package com.example.grupo2foodtravelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.navigation.compose.*
import androidx.compose.ui.Modifier
import com.example.grupo2foodtravelapp.ui.theme.Grupo2FoodTravelAppTheme
import com.example.grupo2foodtravelapp.views.BarraDeCarga
import com.example.grupo2foodtravelapp.views.LoginScreen
import com.example.grupo2foodtravelapp.views.PantallaListaDetalle
import com.example.grupo2foodtravelapp.views.PantallaListaLugares

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Grupo2FoodTravelAppTheme() {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "PantallaDeCarga",
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.systemBars)
                ) {
                    composable("PantallaDeCarga") {
                        BarraDeCarga(
                            onFinish = {
                                navController.navigate("login") {
                                    popUpTo("PantallaDeCarga") { inclusive = true }
                                }
                            }
                        )
                    }
                    composable("login") {
                        LoginScreen(
                            onIngresarClick = {
                                navController.navigate("lista") {
                                    popUpTo("login") { inclusive = true }
                                }
                            },
                            onRegistrarClick = {
                                println("Registrar presionado")
                            }
                        )
                    }

                    composable("lista") {
                        PantallaListaLugares(navController)
                    }

                    composable("detail/{lugarId}") { backStack ->
                        val id = backStack.arguments?.getString("lugarId")?.toInt() ?: 0
                        PantallaListaDetalle(id, navController = navController)
                    }
                }
            }
        }
    }
}