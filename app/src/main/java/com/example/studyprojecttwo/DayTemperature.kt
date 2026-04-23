package com.example.studyprojecttwo

import java.util.Date

internal data class DayTemperature(
    var date: Date = Date(),
    var averageTemperature: Int = 0,
    var dayTemperatureDetails: DayTemperatureDetails = DayTemperatureDetails()
)