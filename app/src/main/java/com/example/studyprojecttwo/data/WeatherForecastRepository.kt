package com.example.studyprojecttwo.data

import android.app.Application
import androidx.room.withTransaction
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.studyprojecttwo.data.dataSource.WeatherForecastMapper
import com.example.studyprojecttwo.data.dataSource.WeatherForecastRemoteDataSource
import com.example.studyprojecttwo.data.dataSource.dataBase.WeatherForecastDataBase
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast
import com.example.studyprojecttwo.domain.Precipitation
import com.example.studyprojecttwo.domain.WeatherInfoAdvanced
import com.example.studyprojecttwo.domain.WeatherInfoShort
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
internal class WeatherForecastRepository @Inject constructor(
    val remoteDataSource: WeatherForecastRemoteDataSource,
    val dataBase: WeatherForecastDataBase,
    val mapper: WeatherForecastMapper,
) {
    suspend fun getDetailedWeatherForecast(date: Date): Result<DetailedWeatherForecast> {
        val forecast = dataBase.detailedWeatherForecastDao().getByDate(date)
        if (forecast != null) {
            return forecast.let {
                Result.success(
                    DetailedWeatherForecast(
                        it.date,
                        WeatherInfoAdvanced(
                            it.morningForecast.averageTemperature,
                            it.morningForecast.averageWindSpeed,
                            Precipitation.valueOf(it.morningForecast.precipitation.name)
                        ),
                        WeatherInfoAdvanced(
                            it.dayForecast.averageTemperature,
                            it.dayForecast.averageWindSpeed,
                            Precipitation.valueOf(it.dayForecast.precipitation.name)
                        ),
                        WeatherInfoAdvanced(
                            it.eveningForecast.averageTemperature,
                            it.eveningForecast.averageWindSpeed,
                            Precipitation.valueOf(it.eveningForecast.precipitation.name)
                        ),
                        WeatherInfoAdvanced(
                            it.nightForecast.averageTemperature,
                            it.nightForecast.averageWindSpeed,
                            Precipitation.valueOf(it.nightForecast.precipitation.name)
                        )
                    )
                )
            }
        } else {
            return Result.failure(IllegalArgumentException("Прогноз для даты $date не найден"))
        }
    }

    suspend fun updateWeatherForecast() {
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

    suspend fun startPeriodicUpdateWeatherForecast(application: Application) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<WeatherForecastWorker>()
            .build()
        val periodicWorkRequest =
            PeriodicWorkRequestBuilder<WeatherForecastWorker>(20, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()
        WorkManager.getInstance(application).enqueue(oneTimeWorkRequest)
        WorkManager.getInstance(application).enqueue(
            periodicWorkRequest
        )
    }

    suspend fun observerDailyWeatherForecast(): Flow<List<DailyWeatherForecast>> {
        return dataBase.dailyWeatherForecastDao().getAll().map {
            it.map {
                DailyWeatherForecast(
                    it.date,
                    WeatherInfoShort(it.weatherInfo.averageTemperature)
                )
            }
        }

    }
}