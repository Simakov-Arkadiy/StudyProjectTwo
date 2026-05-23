package com.example.studyprojecttwo.presentation.dailyWeatherForecast.DailyWeatherForecastLoader

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
internal fun RainDrop() {
    val randomOffset = remember { Random.nextDouble(400.0, 600.0).toFloat() }
    val randomInitialDelay = remember { Random.nextInt(0, 1000) }
    val randomDuration = remember { Random.nextInt(1500, 2000) }
    val animatable = remember {
        Animatable(
            initialValue = Offset(randomOffset, 825f),
            typeConverter = Offset.VectorConverter
        )
    }
    LaunchedEffect(Unit) {
        animatable.animateTo(
            targetValue = Offset(randomOffset, 1100f),
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = randomDuration, easing = LinearEasing),
                repeatMode = RepeatMode.Restart,
                initialStartOffset = StartOffset(randomInitialDelay)
            )
        )
    }
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color = Color(82, 206, 255), size = Size(13f, 18f), topLeft = animatable.value)
    }
}