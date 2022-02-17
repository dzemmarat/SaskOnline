package com.mrz.saskonline.data.models.remote.requests

data class WeatherRequest(
    // Город
    val q: String,
    // Уникальный токен
    val appid: String,
    // Градусы цельсия
    val units: String = "metric",
    // Язык
    val lang: String = "ru",
    // Количество элементов
    val cnt: Short
)