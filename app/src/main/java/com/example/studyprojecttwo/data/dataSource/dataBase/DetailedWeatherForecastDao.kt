package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.Date

@Dao
interface DetailedWeatherForecastDao {
    @Query("SELECT DISTINCT * FROM entityDetailedWeatherForecast WHERE date = :date")
    suspend fun getByDate(date: Date): EntityDetailedWeatherForecast?

    @Insert
    suspend fun setEntities(detailedWeatherForecast: List<EntityDetailedWeatherForecast>)

    @Query("DELETE FROM entityDetailedWeatherForecast")
    suspend fun deleteAll()
}