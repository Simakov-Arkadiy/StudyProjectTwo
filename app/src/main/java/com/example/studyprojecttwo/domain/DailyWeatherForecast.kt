package com.example.studyprojecttwo.domain

import java.util.Date


internal class DailyWeatherForecast(
    val date: Date,
    override val averageTemperature: Int,
    val id: Int,
) : WeatherForecast()




