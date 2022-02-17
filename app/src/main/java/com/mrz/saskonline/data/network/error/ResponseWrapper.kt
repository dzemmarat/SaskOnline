package com.mrz.saskonline.data.network.error

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseWrapper<T>(
    @SerializedName("cod")
    val cod: String? = null,
    @SerializedName("message")
    val message: Any? = "Ahahaha",
    @SerializedName("cnt")
    val cnt: Int? = null,
    @SerializedName("list")
    val list: T? = null
) : Serializable
