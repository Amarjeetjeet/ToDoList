package com.lunartechnolabs.todolist

import androidx.room.TypeConverter
import java.util.*

class Converter {
    @TypeConverter
    fun fromDateToString(value : Date) :Long{
        return value.time
    }

    @TypeConverter
    fun fromStringToDate(value : Long) :Date{
        return Date(value)
    }
}