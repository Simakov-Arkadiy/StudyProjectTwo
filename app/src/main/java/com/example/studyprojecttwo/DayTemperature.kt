package com.example.studyprojecttwo

import java.util.Date

internal data class DayTemperature(
    val date: Date,
    val averageTemperature: Int,
    val dayTemperatureDetails: DayTemperatureDetails
)