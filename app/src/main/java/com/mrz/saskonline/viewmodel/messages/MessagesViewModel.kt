package com.mrz.saskonline.viewmodel.messages

import android.graphics.drawable.Drawable
import androidx.lifecycle.viewModelScope
import com.mrz.saskonline.data.models.local.Message
import com.mrz.saskonline.viewmodel.core.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessagesViewModel: BaseViewModel() {

    private val _conversationsMessages = MutableStateFlow<MutableList<Message>>(mutableListOf())
    val conversationsMessages: StateFlow<List<Message>> = _conversationsMessages

    private val _teachersMessages = MutableStateFlow<MutableList<Message>>(mutableListOf())
    val teachersMessages: StateFlow<List<Message>> = _teachersMessages

    private val _privateMessages = MutableStateFlow<MutableList<Message>>(mutableListOf())
    val privateMessages: StateFlow<List<Message>> = _privateMessages

    fun setupConversations() {
        _conversationsMessages.value = mutableListOf(
            Message(
                title = "141 группа",
                description = "Общее описание",
                lastMessage = "Ребят, что задали по алгему?"
            ),
            Message(
                title = "1 курс",
                description = "Все первокурсники",
                lastMessage = "Все первокурсники обязаны явиться..."
            ),
        )
    }

    fun setupTeachersMessages(drawable1: Drawable, drawable2: Drawable) {
        viewModelScope.launch {
            delay(1000)
        }
        _teachersMessages.value = mutableListOf(
            Message(
                title = "Иван Игоревич",
                lastMessage = "Вы: Иван Игоревич, здравствуйте! Я по поводу дз...",
                logo = drawable1
            ),
            Message(
                title = "Василиса Горная",
                lastMessage = "Вы: Присылаю вам копию реферата",
                logo = drawable2
            ),
        )
    }

    fun setupPrivateMessages(drawable1: Drawable, drawable2: Drawable) {
        _privateMessages.value = mutableListOf(
            Message(
                title = "Коля Михайлов",
                lastMessage = "Я дз сделаю и го\nВы: Чо как по дз?) Го в кафе) ",
                logo = drawable1
            ),
            Message(
                title = "Валя Иванова",
                lastMessage = "Вы: Ну дай списать, я потом отдам, пжжж",
                logo = drawable2
            ),
        )
    }
}