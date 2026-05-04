package com.example.studyprojecttwo.data

import com.example.studyprojecttwo.domain.DailyWeatherForecast
import java.util.Date

data class DailyWeatherForecastList(

    val list: List<DailyWeatherForecast> = listOf(
        DailyWeatherForecast(Date(nowTime), -8, 0),
        DailyWeatherForecast(Date(nowTime + 24 * 60 * 60 * 1000L), -5, 1),
        DailyWeatherForecast(Date(nowTime + 2 * 24 * 60 * 60 * 1000L), -7, 2),
        DailyWeatherForecast(Date(nowTime + 3 * 24 * 60 * 60 * 1000L), -2, 3),
        DailyWeatherForecast(Date(nowTime + 4 * 24 * 60 * 60 * 1000L), 6, 4),
        DailyWeatherForecast(Date(nowTime + 5 * 24 * 60 * 60 * 1000L), 11, 5),
        DailyWeatherForecast(Date(nowTime + 6 * 24 * 60 * 60 * 1000L), 10, 6),
        DailyWeatherForecast(Date(nowTime + 7 * 24 * 60 * 60 * 1000L), -3, 7),
        DailyWeatherForecast(Date(nowTime + 8 * 24 * 60 * 60 * 1000L), -2, 8),
        DailyWeatherForecast(Date(nowTime + 9 * 24 * 60 * 60 * 1000L), -1, 9),
        DailyWeatherForecast(Date(nowTime + 10 * 24 * 60 * 60 * 1000L), 1, 10),
        DailyWeatherForecast(Date(nowTime + 11 * 24 * 60 * 60 * 1000L), 5, 11),
        DailyWeatherForecast(Date(nowTime + 12 * 24 * 60 * 60 * 1000L), 4, 12),
        DailyWeatherForecast(Date(nowTime + 13 * 24 * 60 * 60 * 1000L), 8, 13),
        DailyWeatherForecast(Date(nowTime + 14 * 24 * 60 * 60 * 1000L), -1, 14),
        DailyWeatherForecast(Date(nowTime + 15 * 24 * 60 * 60 * 1000L), -3, 15),
        DailyWeatherForecast(Date(nowTime + 16 * 24 * 60 * 60 * 1000L), -11, 16),
        DailyWeatherForecast(Date(nowTime + 17 * 24 * 60 * 60 * 1000L), -10, 17),
    )
)
val nowTime = System.currentTimeMillis()