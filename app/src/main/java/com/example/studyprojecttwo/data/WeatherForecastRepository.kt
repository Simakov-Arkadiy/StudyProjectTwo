package com.example.studyprojecttwo.data

import com.example.studyprojecttwo.data.dataSource.WeatherForecastRemoteDataSource
import com.example.studyprojecttwo.data.dataSource.WeatherForecastMapper
import com.example.studyprojecttwo.data.dataSource.WeatherLocalDataSource
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class WeatherForecastRepository @Inject constructor(

    val mapper: WeatherForecastMapper,
    val weatherForecastRemoteDataSource: WeatherForecastRemoteDataSource,
    var weatherLocalDataSource: WeatherLocalDataSource,
) {

    fun getDetailedWeatherForecast(date: Long): DetailedWeatherForecast {

        val formatter = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val searchDateStr = formatter.format(Date(date))

        return weatherLocalDataSource.detailedWeatherForecastList?.find { formatter.format(it.date) == searchDateStr }
            ?: throw IllegalArgumentException("Прогноз для даты $date не найден")
    }

    suspend fun fillCache() {

        weatherLocalDataSource.dailyWeatherForecastList =
            mapper.responseMappingDailyWeatherForecast(weatherForecastRemoteDataSource.fetchWeather())
        weatherLocalDataSource.detailedWeatherForecastList =
            mapper.responseMappingDetailedWeatherForecast(weatherForecastRemoteDataSource.fetchWeather())

    }

    suspend fun getDailyWeatherForecastLis(): List<DailyWeatherForecast>? {
        val cached = weatherLocalDataSource.dailyWeatherForecastList
        if (cached == null) {
            fillCache()
            return weatherLocalDataSource.dailyWeatherForecastList
        } else {
            return weatherLocalDataSource.dailyWeatherForecastList
        }
    }
}