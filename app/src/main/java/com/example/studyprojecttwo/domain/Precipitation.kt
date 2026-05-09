package com.example.studyprojecttwo.domain

import com.example.studyprojecttwo.R

internal enum class Precipitation(val value:Int) {
    SUNNY(R.drawable.sunny), LIGHT_RAIN(R.drawable.lightrain), SNOW(R.drawable.snow), CLOUDY(R.drawable.cloudy);
}