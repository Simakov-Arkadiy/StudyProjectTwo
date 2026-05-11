package com.example.studyprojecttwo.presentation.dailyWeatherForecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
internal fun DailyWeatherForecastScreen(
    controller: NavHostController,
    viewModel: DailyWeatherForecastViewModel = viewModel()
) {
    val items by viewModel.items.collectAsState()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(31, 44, 96)),
        contentPadding = PaddingValues(20.dp)
    ) {
        items(viewModel.items.value) { weather -> DailyWeatherForecastItem(weather, controller) }
        items(items) { weather ->
            DailyWeatherForecastItem(weather, controller)
        }
    }
}