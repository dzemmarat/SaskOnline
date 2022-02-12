package com.mrz.saskonline.app.core

import java.text.SimpleDateFormat
import java.util.*

class Util {
    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.getDefault())
        val date = Date()
        return sdf.format(date)
    }

    fun getCurrentDay(): String =
        SimpleDateFormat("dd", Locale.getDefault()).format(Date())

    fun getCurrentYear(): String =
        SimpleDateFormat("yyyy", Locale.getDefault()).format(Date())

    fun getCurrentMonth(): String =
        SimpleDateFormat("MM", Locale.getDefault()).format(Date())

    fun getCurrentHourWithNull(): String =
        SimpleDateFormat("HH", Locale.getDefault()).format(Date()) + ":00"

    fun getCurrentHour(): String =
        SimpleDateFormat("HH", Locale.getDefault()).format(Date())

    fun getCurrentHourInInt(): Int =
        getCurrentHour().toInt()
}