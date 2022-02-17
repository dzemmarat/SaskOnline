package com.mrz.saskonline.ui.home.homework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mrz.saskonline.data.models.local.Lesson
import com.mrz.saskonline.databinding.ItemHomeworkBinding
import com.mrz.saskonline.ui.core.BaseAdapterDelegate

class HomeworkDelegate : BaseAdapterDelegate() {
    override fun isForItem(item: Any, items: MutableList<Any>, position: Int): Boolean =
        item is Lesson

    override fun getViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder =
        HomeworkViewHolder(ItemHomeworkBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        val viewHolder = holder as HomeworkViewHolder
        viewHolder.bind(item as Lesson)
    }

    inner class HomeworkViewHolder(
        private val binding: ItemHomeworkBinding
    ) : ViewHolder(binding.root) {
        fun bind(item: Lesson) {
            with(binding) {
                tvLessonTitle.text = item.title
                tvLessonDescription.text = item.description
            }
        }
    }
}