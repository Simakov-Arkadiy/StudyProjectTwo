package com.example.studyprojecttwo.data

import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal class Repository {
    companion object {
        var heshDataSource: WeatherLocalDataSource = WeatherLocalDataSource()
    }

    fun getDetailedWeatherForecast(date: Long): DetailedWeatherForecast {

        val formatter = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val searchDateStr = formatter.format(Date(date))

        return heshDataSource.detailedWeatherForecastList.find { formatter.format(it.date) == searchDateStr }!!
    }
}