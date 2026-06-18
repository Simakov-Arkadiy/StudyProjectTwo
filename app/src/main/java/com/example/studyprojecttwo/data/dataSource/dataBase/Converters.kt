package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun fromEntityPrecipitation(precipitation: EntityPrecipitation): String {
        return precipitation.name
    }

    @TypeConverter
    fun toEntityPrecipitation(precipitationString: String): EntityPrecipitation {
        return EntityPrecipitation.valueOf(precipitationString)
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