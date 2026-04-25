package com.example.studyprojecttwo.domain.repository

import com.example.studyprojecttwo.domain.WeatherForecastDailyPeriod
import java.util.Date

data class WeatherForecastDailyPeriodList(
    val list: List<WeatherForecastDailyPeriod> = listOf(
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time), -8),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 24 * 60 * 60 * 1000L), -5),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 2 * 24 * 60 * 60 * 1000L), -7),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 3 * 24 * 60 * 60 * 1000L), -2),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 4 * 24 * 60 * 60 * 1000L), 6),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 5 * 24 * 60 * 60 * 1000L), 11),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 6 * 24 * 60 * 60 * 1000L), 10),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 7 * 24 * 60 * 60 * 1000L), -3),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 8 * 24 * 60 * 60 * 1000L), -2),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 9 * 24 * 60 * 60 * 1000L), -1),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 10 * 24 * 60 * 60 * 1000L), 1),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 11 * 24 * 60 * 60 * 1000L), 5),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 12 * 24 * 60 * 60 * 1000L), 4),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 13 * 24 * 60 * 60 * 1000L), 8),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 14 * 24 * 60 * 60 * 1000L), -1),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 15 * 24 * 60 * 60 * 1000L), -3),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 16 * 24 * 60 * 60 * 1000L), -11),
        WeatherForecastDailyPeriod(Date(MyTime().nowTime.time + 17 * 24 * 60 * 60 * 1000L), -10),
    )
) {
}