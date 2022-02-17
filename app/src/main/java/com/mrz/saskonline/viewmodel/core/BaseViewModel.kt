package com.mrz.saskonline.viewmodel.core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrz.saskonline.data.network.NetworkService
import com.mrz.saskonline.data.network.api.WeatherApi
import com.mrz.saskonline.data.network.error.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {

    var api: WeatherApi = NetworkService.retrofitService()

    /**
     * Получаем результат запроса и сеттим его внутрь лайв даты
     */
    fun <T> requestWithMutableFlow(
        flow: MutableStateFlow<Event<T>>,
        request: suspend () -> ResponseWrapper<T>
    ) {

        // В начале запроса сразу отправляем ивент загрузки
        flow.value = Event.loading()

        // Привязываемся к жизненному циклу ViewModel, используя viewModelScope.
        // После ее уничтожения все выполняющиеся длинные запросы
        // будут остановлены за ненадобностью.
        // Переходим в IO поток и стартуем запрос
        this.viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = request.invoke()
                Log.e("Request", response.toString())
                if (response.cod == "200") {
                    flow.value = Event.success(response.list)
                } else if (response.cod != "200") {
                    flow.value = Event.error(response.message.toString())
                }
            } catch (e: Exception) {
                e.message?.let { Log.e("Trouble", it) }
                e.printStackTrace()
                flow.value = Event.error(null)
            }
        }
    }

}