package com.example.studyprojecttwo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

internal class DayTemperatureDetailsModel : ViewModel() {
    private var model = mutableStateOf(DayTemperatureDetails())

    internal fun SetDayTemperatureDetails(
        averageTemperatureForMorning: Int,
        averageTemperatureForDay: Int,
        averageTemperatureForEvening: Int,
        averageTemperatureForNight: Int
    ) {
        model.value.averageTemperatureForDay = averageTemperatureForDay
        model.value.averageTemperatureForNight = averageTemperatureForNight
        model.value.averageTemperatureForEvening = averageTemperatureForEvening
        model.value.averageTemperatureForMoning = averageTemperatureForMorning
    }
    internal fun GetAverageTemperatureForDay(): Int{
        return model.value.averageTemperatureForDay
    }
    internal fun GetaverageTemperatureForNight(): Int{
        return model.value.averageTemperatureForNight
    }
    internal fun GetaverageTemperatureForEvening(): Int{
        return model.value.averageTemperatureForEvening
    }
    internal fun GetaverageTemperatureForMorning(): Int{
        return model.value.averageTemperatureForMoning
    }
}
