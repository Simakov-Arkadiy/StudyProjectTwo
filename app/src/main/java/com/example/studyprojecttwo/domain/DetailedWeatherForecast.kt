package com.example.studyprojecttwo.domain

import java.util.Date

internal data class DetailedWeatherForecast(
    val date: String?,
    val morningForecast: WeatherInfoAdvanced,
    val dayForecast: WeatherInfoAdvanced,
    val eveningForecast: WeatherInfoAdvanced,
    val nightForecast: WeatherInfoAdvanced,
)