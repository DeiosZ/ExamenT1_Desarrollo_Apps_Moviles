package com.example.t1grupo1.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.t1grupo1.R
import kotlinx.coroutines.delay
import com.example.t1grupo1.ui.theme.VerdeFood

@Composable
fun BarraDeCarga(
    onFinish: () -> Unit
) {

    var progreso by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        while (progreso < 1f) {
            delay(30)
            progreso += 0.02f
        }
        onFinish()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(280.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        LinearProgressIndicator(
        progress = { progreso },
        modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                        .height(10.dp),
        color = VerdeFood,
        trackColor = VerdeFood.copy(alpha = 0.2f),
        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
        )
    }
}