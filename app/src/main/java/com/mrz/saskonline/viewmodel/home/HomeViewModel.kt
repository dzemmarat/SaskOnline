package com.mrz.saskonline.viewmodel.home

import androidx.lifecycle.viewModelScope
import com.mrz.saskonline.R
import com.mrz.saskonline.data.models.Date
import com.mrz.saskonline.data.models.Lesson
import com.mrz.saskonline.viewmodel.core.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val _lessons = MutableStateFlow<List<Lesson>>(emptyList())
    val lessons: StateFlow<List<Lesson>> = _lessons

    private val _homework = MutableStateFlow<Map<String, List<Lesson>>>(emptyMap())
    val homework: StateFlow<Map<String, List<Lesson>>> = _homework

    private val _homeworkList = MutableStateFlow<MutableList<Any>>(mutableListOf())
    val homeworkList: StateFlow<List<Any>> = _homeworkList

    private var previousKey: String = ""

    fun createTestElements() {
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