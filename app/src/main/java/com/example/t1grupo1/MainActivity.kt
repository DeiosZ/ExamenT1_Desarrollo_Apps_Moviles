package com.example.t1grupo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.navigation.compose.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.t1grupo1.ui.theme.T1Grupo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            T1Grupo1Theme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login",
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.systemBars)
                ) {

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
                        PantallaListaDetalle(id)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier:Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    T1Grupo1Theme {
        Greeting("Android")
    }
}