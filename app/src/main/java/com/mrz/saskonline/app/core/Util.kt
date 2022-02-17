package com.mrz.saskonline.app.core

import java.text.SimpleDateFormat
import java.util.*

class Util {
    companion object {
        fun getCurrentDate(): String {
            //"2022-02-12 21:43:05"
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val date = Date()
            return sdf.format(date)
        }

        fun getCurrentDateWithNull(): String {
            //"2022-02-12 21:00:00"
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:00:00", Locale.getDefault())
            val date = Date()
            return sdf.format(date)
        }

        fun getTomorrowDate(): String {
            //"2022-02-12"
            val sdf =
                getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDay().toInt().inc()
                    .toString()
            return sdf
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
}