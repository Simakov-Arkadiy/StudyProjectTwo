package com.example.studyprojecttwo.widget

import androidx.glance.appwidget.background
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.layout.Row
import com.example.studyprojecttwo.ui.theme.BackgroundColorForDayTemperatureItem
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun WeatherWidgetContent(date: Date, averageTemperature: Float) {
    val dayFormatter = remember() { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }
    val dayFormatterTwo = remember() { SimpleDateFormat("EEEE", Locale.getDefault()) }

    Row(
        modifier = GlanceModifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(54, 67, 112, 50), BackgroundColorForDayTemperatureItem)
            .padding(16.dp, 10.dp)
            .clickable(onClick = actionRunCallback<CurrentWeatherAction>())
    ) {
        Column {
            Text(text = dayFormatter.format(date))
            Text(
                text = dayFormatterTwo.format(date),
            )
        }
        Text(
            text = "${averageTemperature} *C",
        )
    }
}