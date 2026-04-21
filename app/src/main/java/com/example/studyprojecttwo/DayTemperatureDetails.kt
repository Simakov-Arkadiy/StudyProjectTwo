package com.example.studyprojecttwo

import java.util.Date

internal data class DayTemperatureDetails(
    val date: Date,
    val averageTemperatureForMorning: Int,
    val averageTemperatureForDay: Int,
    val averageTemperatureForEvening: Int,
    val averageTemperatureForNight: Int
)