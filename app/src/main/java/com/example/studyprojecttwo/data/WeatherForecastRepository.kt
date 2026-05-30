package com.example.studyprojecttwo.data

import com.example.studyprojecttwo.data.dataSource.WeatherForecastRemoteDataSource
import com.example.studyprojecttwo.data.dataSource.WeatherForecastMapper
import com.example.studyprojecttwo.data.dataSource.dataBase.WeatherForecastDataBase
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class WeatherForecastRepository @Inject constructor(
    val dataBase: WeatherForecastDataBase,
    val mapper: WeatherForecastMapper,
    val remoteDataSource: WeatherForecastRemoteDataSource,
) {
    suspend fun getDetailedWeatherForecast(date: String): Result<DetailedWeatherForecast> {
        val forecast = dataBase.detailedWeatherForecastDao().getByDate(date.substringBefore("T"))
        if (forecast != null) {
            return forecast.let { Result.success(it) }
        } else {
            return Result.failure(IllegalArgumentException("Прогноз для даты $date не найден"))
        }
    }

    suspend fun getDailyWeatherForecast(): Result<List<DailyWeatherForecast>?> {

        val result = Result.runCatching { remoteDataSource.getWeatherForecast() }
        result.onSuccess { response ->
            dataBase.dailyWeatherForecastDao().setEntities(
                mapper.mapToDailyWeatherForecast(
                    response = response
                )
            )
            dataBase.detailedWeatherForecastDao().setEntities(
                mapper.mapToDetailedWeatherForecast(
                    response = response
                )
            )
        }
        return Result.success(dataBase.dailyWeatherForecastDao().getAll())
    }
}