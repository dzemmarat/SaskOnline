package com.mrz.saskonline.data.models.local

data class Note(
    val timeStart: String,
    val timeEnd: String? = null,
    val title: String,
    val description: String? = null,
    val date: Date,
    val isChecked: Boolean = false
)
