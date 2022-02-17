package com.mrz.saskonline.data.models.local

data class Lesson(
    val image: Int,
    val title: String,
    val type: String,
    val description: String,
    val time: String,
    val date: String = ""
)