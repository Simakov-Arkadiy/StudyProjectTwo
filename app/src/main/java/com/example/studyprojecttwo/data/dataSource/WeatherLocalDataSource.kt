package com.example.studyprojecttwo.data.dataSource

import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import jakarta.inject.Inject
import jakarta.inject.Singleton


@Singleton
internal class WeatherLocalDataSource @Inject constructor() {

    @Volatile
    private var dailyWeatherForecastList: List<DailyWeatherForecast>? = null

    @Volatile
    private var detailedWeatherForecastList: List<DetailedWeatherForecast>? = null

    suspend fun setDailyWeatherForecast(list: List<DailyWeatherForecast>) {
        dailyWeatherForecastList = list
    }

    suspend fun getDailyWeatherForecast(): List<DailyWeatherForecast>? {
        return dailyWeatherForecastList
    }

    suspend fun setDetailedWeatherForecast(list: List<DetailedWeatherForecast>?) {
        detailedWeatherForecastList = list
    }

    suspend fun getDetailedWeatherForecast(): List<DetailedWeatherForecast>? {
        return detailedWeatherForecastList
    }
}