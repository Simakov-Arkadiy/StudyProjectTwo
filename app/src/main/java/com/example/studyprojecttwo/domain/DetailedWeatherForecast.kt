package com.example.studyprojecttwo.domain

internal data class DetailedWeatherForecast(
    val morningWeatherForecast: MorningWeatherForecast,
    val dayWeatherForecast: DayWeatherForecast,
    val eveningWeatherForecast: EveningWeatherForecast,
    val nightWeatherForecast: NightWeatherForecast,
    val id: Int,
)