package com.example.studyprojecttwo.data.dataSource

import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import jakarta.inject.Inject
import jakarta.inject.Singleton


@Singleton
internal class WeatherLocalDataSource @Inject constructor() {

    @Volatile
    private var dailyWeatherForecastList: List<DailyWeatherForecast>? = null

    suspend fun setDailyWeatherForecastList(list: List<DailyWeatherForecast>) {
        dailyWeatherForecastList = list
    }

    suspend fun getDailyWeatherForecastList(): List<DailyWeatherForecast>? {
        return dailyWeatherForecastList
    }

    @Volatile
    private var detailedWeatherForecastList: List<DetailedWeatherForecast>? = null

    suspend fun setDetailedWeatherForecastList(list: List<DetailedWeatherForecast>?) {
        detailedWeatherForecastList = list
    }

    suspend fun getDetailedWeatherForecastList(): List<DetailedWeatherForecast>? {
        return detailedWeatherForecastList
    }
}