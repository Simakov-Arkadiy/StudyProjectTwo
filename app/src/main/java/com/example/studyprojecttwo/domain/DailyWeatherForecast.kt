package com.example.studyprojecttwo.domain

import java.util.Date

data class DailyWeatherForecast(
    val date: Date,
    val weatherInfo: WeatherInfoShort,
)