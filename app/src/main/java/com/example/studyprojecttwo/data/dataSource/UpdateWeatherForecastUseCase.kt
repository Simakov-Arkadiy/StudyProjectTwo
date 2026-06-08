package com.example.studyprojecttwo.data.dataSource

import androidx.room.withTransaction
import com.example.studyprojecttwo.data.dataSource.dataBase.WeatherForecastDataBase
import jakarta.inject.Inject

internal class UpdateWeatherForecastUseCase @Inject constructor(
    val remoteDataSource: WeatherForecastRemoteDataSource,
    val dataBase: WeatherForecastDataBase,
    val mapper: WeatherForecastMapper,
) {
    suspend fun invoke() {
        dataBase.withTransaction {
            dataBase.dailyWeatherForecastDao().deleteAll()
            dataBase.detailedWeatherForecastDao().deleteAll()
        }
        val response = remoteDataSource.getWeatherForecast()
        dataBase.dailyWeatherForecastDao().setEntities(
            mapper.mapToEntityDailyWeatherForecast(
                response = response
            )
        )
        dataBase.detailedWeatherForecastDao().setEntities(
            mapper.mapToEntityDetailedWeatherForecast(
                response = response
            )
        )
    }
}