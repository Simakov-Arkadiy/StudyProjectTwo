package com.example.studyprojecttwo.data

import android.app.Application
import android.content.Context
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.studyprojecttwo.data.dataSource.dataBase.WeatherForecastDataBase
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
internal class WeatherForecastRepository @Inject constructor(
    val dataBase: WeatherForecastDataBase,
) {
    suspend fun getDetailedWeatherForecast(date: String): Result<DetailedWeatherForecast> {
        val forecast = dataBase.detailedWeatherForecastDao().getByDate(date)
        if (forecast != null) {
            return forecast.let { Result.success(it) }
        } else {
            return Result.failure(IllegalArgumentException("Прогноз для даты $date не найден"))
        }
    }

    suspend fun getDailyWeatherForecast(application: Application): Result<List<DailyWeatherForecast>> {
        val workRequest: WorkRequest =
            PeriodicWorkRequestBuilder<WeatherForecastWorker>(16, TimeUnit.MINUTES)
                .build()
        WorkManager.getInstance(application).enqueue(workRequest)
        val result = Result.runCatching { dataBase.dailyWeatherForecastDao().getAll() }
        return result
    }
}