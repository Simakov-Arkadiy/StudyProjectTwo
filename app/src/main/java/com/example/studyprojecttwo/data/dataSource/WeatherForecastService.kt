package com.example.studyprojecttwo.data.dataSource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastService {
    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
        @Query("hourly") hourly: String,
        @Query("current") current: String,
        @Query("timezone") timezone: String,
        @Query("forecast_days") forecatDay: Int,
        @Query("wind_speed_unit") windspeedunit: String,
        @Query("temporal_resolution") temporalresolution: String
    ): WeatherForecastResponse
}

@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {

    @Provides
    fun getJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
            encodeDefaults = true
        }
    }

    @Provides
    fun getRetrofit(json: Json): Retrofit {

        val BASE_URL = "https://api.open-meteo.com/v1/"
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    fun getWeatherForecastService(retrofit: Retrofit): WeatherForecastService {
        return retrofit.create(WeatherForecastService::class.java)
    }
}