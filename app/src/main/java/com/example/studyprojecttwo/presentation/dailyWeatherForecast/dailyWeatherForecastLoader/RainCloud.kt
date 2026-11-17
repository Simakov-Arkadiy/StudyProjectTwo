package com.example.studyprojecttwo.presentation.dailyWeatherForecast.dailyWeatherForecastLoader

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun RainCloud(){
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawOval(
            color = Color(82, 206, 255),
            size = Size(58.dp.toPx(), 38.dp.toPx()),
            topLeft = Offset(141.dp.toPx(), 250.dp.toPx())
        )
        drawOval(
            color = Color(82, 206, 255),
            size = Size(44.dp.toPx(), 22.dp.toPx()),
            topLeft = Offset(125.dp.toPx(), 263.dp.toPx())
        )
        drawOval(
            color = Color(82, 206, 255),
            size = Size(27.dp.toPx(), 22.dp.toPx()),
            topLeft = Offset(181.dp.toPx(), 263.dp.toPx())
        )
        drawOval(
            color = Color(82, 206, 255),
            size = Size(16.dp.toPx(), 6.dp.toPx()),
            topLeft = Offset(108.dp.toPx(), 276.dp.toPx())
        )
        drawOval(
            color = Color(82, 206, 255),
            size = Size(5.dp.toPx(), 3.dp.toPx()),
            topLeft = Offset(215.dp.toPx(), 276.dp.toPx())
        )
    }
}