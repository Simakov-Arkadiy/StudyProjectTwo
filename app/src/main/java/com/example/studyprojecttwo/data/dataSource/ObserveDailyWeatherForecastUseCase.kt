package com.example.studyprojecttwo.data.dataSource

import com.example.studyprojecttwo.data.dataSource.dataBase.WeatherForecastDataBase
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.WeatherInfoShort
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class ObserveDailyWeatherForecastUseCase @Inject constructor(
    val dataBase: WeatherForecastDataBase,
) {
    fun invoke(): Flow<List<DailyWeatherForecast>> {
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