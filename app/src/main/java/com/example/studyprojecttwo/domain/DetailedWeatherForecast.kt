package com.example.studyprojecttwo.domain

import java.util.Date

data class DetailedWeatherForecast(
    val date: Date,
    val morningForecast: WeatherInfoAdvanced,
    val dayForecast: WeatherInfoAdvanced,
    val eveningForecast: WeatherInfoAdvanced,
    val nightForecast: WeatherInfoAdvanced,
)