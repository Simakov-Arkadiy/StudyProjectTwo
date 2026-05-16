package com.example.studyprojecttwo.data.dataSource

import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import jakarta.inject.Inject
import jakarta.inject.Singleton


@Singleton
internal class WeatherLocalDataSource @Inject constructor(){
    var dailyWeatherForecastList: List<DailyWeatherForecast>? = null
    var detailedWeatherForecastList: List<DetailedWeatherForecast>? = null
}