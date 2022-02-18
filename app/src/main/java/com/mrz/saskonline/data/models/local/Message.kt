package com.mrz.saskonline.data.models.local

import android.graphics.drawable.Drawable

data class Message(
    val title: String,
    val description: String? = null,
    val lastMessage: String,
    val logo: Drawable? = null
)
