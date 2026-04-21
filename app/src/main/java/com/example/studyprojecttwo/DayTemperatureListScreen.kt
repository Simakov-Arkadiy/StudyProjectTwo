package com.example.studyprojecttwo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.studyprojecttwo.ui.theme.DarkBlue

@Composable
internal fun DayTemperatureListScreen(
    controller: NavHostController,
    items: List<DayTemperature>,
    // TODO: пока чтоб не заебываться прокинуть details сюда в параметрах
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkBlue),
        contentPadding = PaddingValues(20.dp),
    ) {
        items(items) { item ->
            DayTemperatureItem(
                item = item,
                onClick = {
                    // TODO: разобраться с этим калом (возможно передать через extras)
                    controller.navigate(
                        "HourlyWeatherForecastScreen/${details.averageTemperatureForMorning}/" +
                                "${details.averageTemperatureForDay}/" +
                                "${details.averageTemperatureForEvening}/" +
                                "${details.averageTemperatureForNight}"
                    )
                },
            )
        }
    }
}