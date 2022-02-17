package com.mrz.saskonline.viewmodel.notes

import com.mrz.saskonline.data.models.local.Date
import com.mrz.saskonline.data.models.local.Note
import com.mrz.saskonline.viewmodel.core.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NotesViewModel: BaseViewModel() {

    private val _notes = MutableStateFlow<MutableList<Any>>(mutableListOf())
    val notes : StateFlow<List<Any>> = _notes

    fun createNotes() {
        _notes.value = mutableListOf(
            Date("18 февраля"),
            Note(
                timeStart = "20:40",
                timeEnd = "22:10",
                title = "Выполни дз",
                description = "Физика, математика",
                isChecked = false,
                date = Date("18 февраля")
            ),
            Note(
                timeStart = "23:00",
                title = "Турик",
                date = Date("18 февраля")
            ),

            Date("25 февраля"),
            Note(
                timeStart = "11:00",
                title = "Военкомат",
                description = "Паспорт, справка",
                date = Date("25 февраля")
            ),
        )
    }
}