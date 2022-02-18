package com.mrz.saskonline.viewmodel.news

import android.graphics.drawable.Drawable
import com.mrz.saskonline.data.models.local.News
import com.mrz.saskonline.data.models.local.NewsHeader
import com.mrz.saskonline.viewmodel.core.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NewsViewModel: BaseViewModel() {

    private val _newsHeader = MutableStateFlow<MutableList<NewsHeader>>(mutableListOf())
    val newsHeader: StateFlow<List<NewsHeader>> = _newsHeader

    private val _news = MutableStateFlow<MutableList<News>>(mutableListOf())
    val news: StateFlow<List<News>> = _news

    fun setupNewsHeader(drawables: List<Drawable>) {
        _newsHeader.value = mutableListOf(
            NewsHeader(
                title = "World Skills",
                image = drawables[0]
            ),
            NewsHeader(
                title = "Федеральные мастерские",
                image = drawables[1]
            ),
        )
    }

    fun setupNews(drawables: List<Drawable>) {
        _news.value = mutableListOf(
            News(
                title = "Хрустальное сердце",
                description = "⚡Студенческий спасательный отряд ВСКС...",
                image = drawables[0]
            ),
            News(
                title = "Коллегия министерства",
                description = " 28 декабря, на базе ГАПОУ СО «Саратовски...",
                image = drawables[1]
            ),
        )
    }
}