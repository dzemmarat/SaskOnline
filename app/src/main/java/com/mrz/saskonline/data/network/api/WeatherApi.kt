package com.mrz.saskonline.data.network.api

import com.mrz.saskonline.data.models.remote.requests.WeatherRequest
import com.mrz.saskonline.data.models.remote.responses.WeatherResponse
import com.mrz.saskonline.data.network.error.ResponseWrapper
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    /**
     * Адресс ссылки по которой будет отправлен запрос без BASE_URL в начале
     * Query - параметры запроса
     */
    @GET("forecast")
    suspend fun getUsers(
        @Query("q") query: String,
        @Query("appid") appId: String,
        @Query("units") units: String = "metric",
        @Query("cnt") cnt: Int,
        @Query("lang") language: String = "ru"
    ): ResponseWrapper<MutableList<WeatherResponse>>


}