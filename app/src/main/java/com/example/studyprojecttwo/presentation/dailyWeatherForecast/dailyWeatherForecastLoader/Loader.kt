package com.example.studyprojecttwo.presentation.dailyWeatherForecast.dailyWeatherForecastLoader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp

@Composable
internal fun Loader() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White, shape = RoundedCornerShape(25.dp))
            .padding(15.dp, 10.dp)
    ) {
        RainCloud()
        for (n in 1..5) {
            RainDrop()
        }
        Text(
            text = "Load",
            color = Color(82, 206, 255),
            fontSize = 35.sp,
            modifier = Modifier.offset(5.dp, 15.dp),
        )
    }
}