package com.example.t1grupo1

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
import com.example.t1grupo1.ui.theme.T1Grupo1Theme
import com.example.t1grupo1.views.BarraDeCarga
import com.example.t1grupo1.views.LoginScreen
import com.example.t1grupo1.views.PantallaListaDetalle
import com.example.t1grupo1.views.PantallaListaLugares

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            T1Grupo1Theme {
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