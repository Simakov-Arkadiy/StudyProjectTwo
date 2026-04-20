package com.example.studyprojecttwo

data class WeatherForecastForDay(
    val data: String,
    val dayOfTheWeek: Int,
    val temperature: Int,
    val hourlyWeather: HourlyWeatherForecast
)