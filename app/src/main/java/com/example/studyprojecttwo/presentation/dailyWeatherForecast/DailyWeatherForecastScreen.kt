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
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
internal fun DailyWeatherForecastScreen(
    controller: NavHostController,
    viewModel: DailyWeatherForecastViewModel = hiltViewModel()
) {
    val items by viewModel.items.collectAsState()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(31, 44, 96)),
        contentPadding = PaddingValues(20.dp)
    ) {
        items(items) { weather ->
            DailyWeatherForecastItem(weather, controller)
        }
    }
}