package com.mrz.saskonline.ui.home.timetable.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.mrz.saskonline.data.models.local.Lesson
import com.mrz.saskonline.databinding.ItemLessonBinding
import com.mrz.saskonline.extensions.visible
import com.mrz.saskonline.ui.core.BaseAdapterDelegate

class TimetableDelegate : BaseAdapterDelegate() {
    override fun isForItem(item: Any, items: MutableList<Any>, position: Int): Boolean =
        item is Lesson

    override fun getViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder =
        TimetableViewHolder(ItemLessonBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        val viewHolder = holder as TimetableViewHolder
        viewHolder.bind(item as Lesson)
    }

    inner class TimetableViewHolder(
        private val binding: ItemLessonBinding
    ) : ViewHolder(binding.root) {

        fun bind(item: Lesson) {
            with(binding) {
                ivIcon.load(item.image)
                tvTitle.text = item.title
                tvLessonDescription.text = item.description
                tvLessonType.text = item.type
                tvLessonTime.text = item.time

                if (tvLessonDescription.lineCount > 2) {
                    ivDeploy.visible()
                    tvLessonDescription.maxLines = 2
                    ivDeploy.setOnClickListener {
                        tvLessonDescription.maxLines = 10000
                    }
                }
            }
        }

    }
}