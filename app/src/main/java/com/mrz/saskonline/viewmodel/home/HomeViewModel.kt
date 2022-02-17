package com.mrz.saskonline.viewmodel.home

import androidx.lifecycle.viewModelScope
import com.mrz.saskonline.R
import com.mrz.saskonline.app.core.Util
import com.mrz.saskonline.data.models.local.Date
import com.mrz.saskonline.data.models.local.Lesson
import com.mrz.saskonline.data.models.remote.requests.WeatherRequest
import com.mrz.saskonline.data.models.remote.responses.WeatherResponse
import com.mrz.saskonline.viewmodel.core.BaseViewModel
import com.mrz.saskonline.viewmodel.core.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.random.Random

class HomeViewModel : BaseViewModel() {

    private val _lessons = MutableStateFlow<List<Lesson>>(emptyList())
    val lessons: StateFlow<List<Lesson>> = _lessons

    private val _homework = MutableStateFlow<Map<String, List<Lesson>>>(emptyMap())

    private val _homeworkList = MutableStateFlow<MutableList<Any>>(mutableListOf())
    val homeworkList: StateFlow<List<Any>> = _homeworkList

    private val _weatherList = MutableStateFlow<Event<MutableList<WeatherResponse>>>(Event.loading())
    val weatherList: StateFlow<Event<MutableList<WeatherResponse>>> = _weatherList

    var isTodayWeather: Boolean = true

    private var previousKey: String = ""

    fun createLessonsTestElements() {
        _lessons.value = listOf(
            Lesson(
                image = R.drawable.ic_history,
                title = "История живописи",
                time = "10:00 - 11:35",
                type = "Практика",
                description = "Написать конспект по направлениям в искусстве 19 века",
                date = "Завтра"
            ),
            Lesson(
                image = R.drawable.ic_physical_culture,
                title = "Физическая культура",
                time = "12:00 - 13:35",
                type = "Практика",
                description = "50 отжиманий\n60 пресс\n80 подтягиваний",
                date = "11 января"
            ),
            Lesson(
                image = R.drawable.ic_history,
                title = "История живописи",
                time = "14:00 - 15:35",
                type = "Практика",
                description = "Написать конспект по направлениям в искусстве 19 века",
                date = "11 января"
            ),
            Lesson(
                image = R.drawable.ic_physical_culture,
                title = "Физическая культура",
                time = "16:00 - 17:35",
                type = "Практика",
                description = "50 отжиманий\n60 пресс\n80 подтягиваний",
                date = "12 января"
            ),
        )
    }

    fun createListForHomework() {
        viewModelScope.launch {
            lessons.collect { lessonsCollected ->
                _homework.value = lessonsCollected.groupBy { it.date }
                sortForRecycler(_homework.value)
            }
        }
    }

    fun getWeatherList() {
        requestWithMutableFlow(_weatherList) {
            api.getUsers(
                query = "Saratov",
                appId = "a6b257b5e002cfceccff62f830c0a3b8",
                cnt = 36
            )
        }
    }

    private fun sortForRecycler(map: Map<String, List<Lesson>>) {
        for ((key, value) in map) {
            if (previousKey != key) {
                _homeworkList.value.add(
                    Date(
                        date = key
                    )
                )
                previousKey = key
                value.forEach {
                    _homeworkList.value.add(it)
                }
            }
        }
    }
}