package com.example.grupo2foodtravelapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.grupo2foodtravelapp.R
import com.example.grupo2foodtravelapp.ui.theme.VerdeFood
import kotlinx.coroutines.delay

@Composable
fun BarraDeCarga(
    onFinish: () -> Unit
) {

    var progreso by remember {
        mutableFloatStateOf(0f)
    }

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

        Spacer(modifier = Modifier.height(28.dp))

        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(10.dp),
            color = VerdeFood,
            trackColor = VerdeFood.copy(alpha = 0.20f),
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap
        )
    }
}