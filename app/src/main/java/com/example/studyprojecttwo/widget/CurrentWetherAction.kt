package com.example.studyprojecttwo.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.studyprojecttwo.data.WeatherForecastWorker

class CurrentWeatherAction: ActionCallback {

    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        val workRequestOne = OneTimeWorkRequestBuilder<WeatherForecastWorker>()
            .build()
        WorkManager.getInstance(context).enqueue(workRequestOne)
        CurrentWeatherWidget().update(context, glanceId)
    }
}