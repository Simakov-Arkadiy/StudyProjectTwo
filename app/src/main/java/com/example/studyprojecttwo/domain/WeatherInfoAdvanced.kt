package com.example.studyprojecttwo.domain

import androidx.room.Embedded

data class WeatherInfoAdvanced(
    val averageTemperature: Float,
    val averageWindSpeed: Float,
    val precipitation: Precipitation,
)