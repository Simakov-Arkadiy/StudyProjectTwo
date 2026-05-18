package com.example.studyprojecttwo.data

import com.example.studyprojecttwo.data.dataSource.WeatherForecastRemoteDataSource
import com.example.studyprojecttwo.data.dataSource.WeatherForecastMapper
import com.example.studyprojecttwo.data.dataSource.WeatherLocalDataSource
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class WeatherForecastRepository @Inject constructor(
    val mapper: WeatherForecastMapper,
    val weatherForecastRemoteDataSource: WeatherForecastRemoteDataSource,
    var weatherForecastLocalDataSource: WeatherLocalDataSource,
) {
    suspend fun getDetailedWeatherForecast(date: String): Result<DetailedWeatherForecast> {

        val forecast =
            weatherForecastLocalDataSource.getDetailedWeatherForecastList()?.find { item ->

                item.date?.substringBefore("T") == date
            }
        return forecast?.let { Result.success(it) }
            ?: Result.failure(IllegalArgumentException("Прогноз для даты $date не найден"))
    }

    suspend fun getDailyWeatherForecastLis(): List<DailyWeatherForecast>? {
        val result = Result.runCatching { weatherForecastRemoteDataSource.fetchWeather() }
        result.onSuccess { response ->
            weatherForecastLocalDataSource.setDailyWeatherForecastList(
                mapper.mapToDailyWeatherForecast(
                    response = response
                )
            )
            weatherForecastLocalDataSource.setDetailedWeatherForecastList(
                mapper.mapToDetailedWeatherForecast(
                    response = response
                )
            )
        }
        return weatherForecastLocalDataSource.getDailyWeatherForecastList()
    }
}