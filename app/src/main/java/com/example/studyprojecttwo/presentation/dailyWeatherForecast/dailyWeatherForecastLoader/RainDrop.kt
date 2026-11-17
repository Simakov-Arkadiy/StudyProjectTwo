package com.example.studyprojecttwo.presentation.dailyWeatherForecast.dailyWeatherForecastLoader

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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
internal fun RainDrop() {
    val density = LocalDensity.current
    val randomOffset = remember(density) {
        Random.nextDouble(
            with(density) { 133.dp.toPx() }.toDouble(),
            with(density) { 200.dp.toPx() }.toDouble()
        ).toFloat()
    }
    val randomInitialDelay = remember { Random.nextInt(0, 1000) }
    val randomDuration = remember { Random.nextInt(1500, 2000) }

    val animatable = remember {
        Animatable(
            initialValue = Offset(randomOffset, with(density) { 275.dp.toPx() }),
            typeConverter = Offset.VectorConverter
        )
    }
    LaunchedEffect(Unit) {
        animatable.animateTo(
            targetValue = Offset(randomOffset, with(density) { 366.dp.toPx() }),
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = randomDuration, easing = LinearEasing),
                repeatMode = RepeatMode.Restart,
                initialStartOffset = StartOffset(randomInitialDelay)
            )
        )
    }
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(
            color = Color(82, 206, 255),
            size = Size(4.dp.toPx(), 6.dp.toPx()),
            topLeft = animatable.value
        )
    }
}