package com.example.studyprojecttwo.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.studyprojecttwo.domain.ObserveDailyWeatherForecastUseCase
import java.util.Date

class WeatherWidget: GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val observeDailyWeatherForecastUseCase: ObserveDailyWeatherForecastUseCase
        provideContent {
            WeatherWidgetContent(Date(),10F)
        }
    }
}