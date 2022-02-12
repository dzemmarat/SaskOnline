package com.mrz.saskonline.extensions

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.getDefault())
    val date = Date()
    return sdf.format(date)
}

@JvmName("getCurrentDayExtension")
fun getCurrentDay(): String =
    SimpleDateFormat("dd", Locale.getDefault()).format(Date())

@JvmName("getCurrentYearExtension")
fun getCurrentYear(): String =
    SimpleDateFormat("yyyy", Locale.getDefault()).format(Date())

@JvmName("getCurrentMonthExtension")
fun getCurrentMonth(): String =
    SimpleDateFormat("MM", Locale.getDefault()).format(Date())

fun getCurrentHourWithNull(): String =
    SimpleDateFormat("HH", Locale.getDefault()).format(Date()) + ":00"

fun getCurrentHour(): String =
    SimpleDateFormat("HH", Locale.getDefault()).format(Date())

fun getCurrentHourInInt(): Int =
    getCurrentHour().toInt()