package com.example.studyprojecttwo.data

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.room.withTransaction
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.studyprojecttwo.data.dataSource.WeatherForecastMapper
import com.example.studyprojecttwo.data.dataSource.WeatherForecastRemoteDataSource
import com.example.studyprojecttwo.data.dataSource.dataBase.WeatherForecastDataBase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
internal class WeatherForecastWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    val dataBase: WeatherForecastDataBase,
    val remoteDataSource: WeatherForecastRemoteDataSource,
    val mapper: WeatherForecastMapper,
) : CoroutineWorker(appContext, workerParams) {


    override suspend fun doWork(): Result {
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
        return Result.success()
    }
}
