package com.example.studyprojecttwo.domain

internal data class WeatherInfoAdvanced(
    val averageTemperature: Int,
    val averageWindSpeed: Int,
    val precipitation: Precipitation,
)