package com.example.studyprojecttwo.data.dataSource

import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


@Singleton
internal class WeatherLocalDataSource @Inject constructor() {
    val mutex = Mutex()
    private var dailyWeatherForecastList: List<DailyWeatherForecast>? = null
    private var detailedWeatherForecastList: List<DetailedWeatherForecast>? = null
    suspend fun setDailyWeatherForecast(list: List<DailyWeatherForecast>) {
        mutex.withLock {
            dailyWeatherForecastList = list
        }
    }

    suspend fun getDailyWeatherForecast(): List<DailyWeatherForecast>? {
        return mutex.withLock {
            dailyWeatherForecastList
        }
    }

    suspend fun setDetailedWeatherForecast(list: List<DetailedWeatherForecast>?) {
        mutex.withLock {
            detailedWeatherForecastList = list
        }
    }

    suspend fun getDetailedWeatherForecast(): List<DetailedWeatherForecast>? {
        return mutex.withLock {
            detailedWeatherForecastList
        }
    }
}