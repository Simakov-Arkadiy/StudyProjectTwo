package com.example.studyprojecttwo.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.studyprojecttwo.data.dataSource.WeatherForecastMapper
import com.example.studyprojecttwo.data.dataSource.WeatherForecastRemoteDataSource
import com.example.studyprojecttwo.data.dataSource.dataBase.WeatherForecastDataBase
import jakarta.inject.Inject

internal class WeatherForecastWorker @Inject constructor(
    appContext: Context,
    workerParams: WorkerParameters,
    val remoteDataSource: WeatherForecastRemoteDataSource,
    val dataBase: WeatherForecastDataBase,
    val mapper: WeatherForecastMapper,
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        dataBase.dailyWeatherForecastDao().deleteAll()
        dataBase.detailedWeatherForecastDao().deleteAll()
        val response = remoteDataSource.getWeatherForecast()
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
        return Result.success()
    }
}
