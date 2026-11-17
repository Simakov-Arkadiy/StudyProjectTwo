package com.example.studyprojecttwo.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.studyprojecttwo.data.WeatherForecastWorker

class CurrentWeatherWidget: GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<WeatherForecastWorker>()
            .build()
        WorkManager.getInstance(context).enqueue(oneTimeWorkRequest)
        val weatherForecastList = WeatherPreferences.loadForecast(context)
        provideContent {
            WeatherWidgetContent(weatherForecastList[0].date, weatherForecastList[0].weatherInfo.averageTemperature)
        }
    }
}