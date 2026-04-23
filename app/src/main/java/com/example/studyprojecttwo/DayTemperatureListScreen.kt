package com.example.studyprojecttwo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
internal fun DayTemperatureListScreen(controller: NavHostController, weatherList: ArrayList<DayTemperature>, model: DayTemperatureDetailsModel) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(31,44,96))
            ,
        contentPadding = PaddingValues(20.dp)
    ) {
        items(weatherList) { weather-> DayTemperatureItem(weather, controller, model) }
    }
}