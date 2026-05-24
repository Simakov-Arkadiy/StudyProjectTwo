package com.example.studyprojecttwo.presentation.dailyWeatherForecast.DailyWeatherForecastLoader

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color

@Composable
internal fun RainCloud(){
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawOval(
            color = Color(82, 206, 255),
            size = Size(176f, 116f),
            topLeft = Offset(425f, 750f)
        )
        drawOval(
            color = Color(82, 206, 255),
            size = Size(133f, 67f),
            topLeft = Offset(375f, 790f)
        )
        drawOval(
            color = Color(82, 206, 255),
            size = Size(83f, 67f),
            topLeft = Offset(545f, 790f)
        )
        drawOval(
            color = Color(82, 206, 255),
            size = Size(50f, 20f),
            topLeft = Offset(325f, 830f)
        )
        drawOval(
            color = Color(82, 206, 255),
            size = Size(16f, 10f),
            topLeft = Offset(645f, 830f)
        )
    }
}