package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room.TypeConverter
import com.example.studyprojecttwo.domain.Precipitation
import java.util.Date

class Converters {
    @TypeConverter
    fun fromPrecipitation(precipitation: Precipitation): String {
        return precipitation.name
    }

    @TypeConverter
    fun toPrecipitation(precipitationString: String): Precipitation {
        return Precipitation.valueOf(precipitationString)
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}