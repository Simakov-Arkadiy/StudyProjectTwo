package com.example.studyprojecttwo.data

import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.WeatherInfoShort
import java.util.Date

internal data class DailyWeatherForecastList(

    val list: List<DailyWeatherForecast> = listOf(
        DailyWeatherForecast(Date(nowTime), WeatherInfoShort(-8)),
        DailyWeatherForecast(Date(nowTime + 24 * 60 * 60 * 1000L), WeatherInfoShort( -5)),
        DailyWeatherForecast(Date(nowTime + 2 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-7)),
        DailyWeatherForecast(Date(nowTime + 3 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-2)),
        DailyWeatherForecast(Date(nowTime + 4 * 24 * 60 * 60 * 1000L), WeatherInfoShort(6)),
        DailyWeatherForecast(Date(nowTime + 5 * 24 * 60 * 60 * 1000L), WeatherInfoShort(11)),
        DailyWeatherForecast(Date(nowTime + 6 * 24 * 60 * 60 * 1000L), WeatherInfoShort(10)),
        DailyWeatherForecast(Date(nowTime + 7 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-3)),
        DailyWeatherForecast(Date(nowTime + 8 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-2)),
        DailyWeatherForecast(Date(nowTime + 9 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-1)),
        DailyWeatherForecast(Date(nowTime + 10 * 24 * 60 * 60 * 1000L), WeatherInfoShort(1)),
        DailyWeatherForecast(Date(nowTime + 11 * 24 * 60 * 60 * 1000L), WeatherInfoShort(5)),
        DailyWeatherForecast(Date(nowTime + 12 * 24 * 60 * 60 * 1000L), WeatherInfoShort(4)),
        DailyWeatherForecast(Date(nowTime + 13 * 24 * 60 * 60 * 1000L), WeatherInfoShort(8)),
        DailyWeatherForecast(Date(nowTime + 14 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-1)),
        DailyWeatherForecast(Date(nowTime + 15 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-3)),
        DailyWeatherForecast(Date(nowTime + 16 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-11)),
        DailyWeatherForecast(Date(nowTime + 17 * 24 * 60 * 60 * 1000L), WeatherInfoShort(-10)),
    )
)
val nowTime = System.currentTimeMillis()