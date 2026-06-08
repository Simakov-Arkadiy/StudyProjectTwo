package com.example.studyprojecttwo.data.dataSource.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Database(
    entities = [EntityDailyWeatherForecast::class, EntityDetailedWeatherForecast::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WeatherForecastDataBase : RoomDatabase() {
    abstract fun dailyWeatherForecastDao(): DailyWeatherForecastDao
    abstract fun detailedWeatherForecastDao(): DetailedWeatherForecastDao
}

@Module
@InstallIn(SingletonComponent::class)
object WeatherForecastDataBaseModule {

    @Provides
    @Singleton
    fun weatherForecastDataBase(
        @ApplicationContext context: Context
    ): WeatherForecastDataBase {
        return Room.databaseBuilder(
            context,
            WeatherForecastDataBase::class.java,
            "weatherForecastDataBase.db"
        ).build()
    }
}