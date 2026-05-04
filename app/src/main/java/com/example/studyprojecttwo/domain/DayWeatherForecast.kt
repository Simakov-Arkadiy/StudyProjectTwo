package com.example.studyprojecttwo.domain

import android.media.Image

internal data class DayWeatherForecast(
    override val averageTemperature: Int,
    val averageWindSpeed: Int,
    val drawableResId: Int,
) : WeatherForecast()