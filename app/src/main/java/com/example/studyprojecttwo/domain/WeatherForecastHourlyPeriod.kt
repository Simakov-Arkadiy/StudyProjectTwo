package com.example.studyprojecttwo.domain

import java.util.Date

data class WeatherForecastHourlyPeriod(
    val date: Date,
    val averageTemperatureForMorning: Int,
    val averageTemperatureForDay: Int,
    val averageTemperatureForEvening: Int,
    val averageTemperatureForNight: Int,
    val averageWindSpeedForMorning: Int,
    val averageWindSpeedForDay: Int,
    val averageWindSpeedForEvening: Int,
    val averageWindSpeedForNight: Int,
) {
}