package com.example.studyprojecttwo.domain

import android.media.Image

internal class NightWeatherForecast(
    override val averageTemperature: Int,
    val averageWindSpeed: Int,
    val drawableResId: Int
) : WeatherForecast()