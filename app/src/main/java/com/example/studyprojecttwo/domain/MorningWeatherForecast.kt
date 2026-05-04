package com.example.studyprojecttwo.domain

import android.media.Image

internal class MorningWeatherForecast(
    override val averageTemperature: Int,
    val averageWindSpeed: Int,
    val drawableResId: Int,
) : WeatherForecast()