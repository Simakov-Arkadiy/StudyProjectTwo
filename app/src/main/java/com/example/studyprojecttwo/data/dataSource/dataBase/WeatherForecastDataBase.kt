package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.DetailedWeatherForecast

@Database(entities = [DailyWeatherForecast::class, DetailedWeatherForecast::class], version = 1)
abstract class WeatherForecastDataBase : RoomDatabase() {
}