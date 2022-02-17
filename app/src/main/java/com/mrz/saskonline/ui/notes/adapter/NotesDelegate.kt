package com.mrz.saskonline.ui.notes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mrz.saskonline.data.models.local.Note
import com.mrz.saskonline.databinding.ItemNoteBinding
import com.mrz.saskonline.ui.core.BaseAdapterDelegate

class NotesDelegate : BaseAdapterDelegate() {
    override fun isForItem(item: Any, items: MutableList<Any>, position: Int): Boolean =
        item is Note

    override fun getViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder =
        HomeworkViewHolder(ItemNoteBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        val viewHolder = holder as HomeworkViewHolder
        viewHolder.bind(item as Note)
    }

    inner class HomeworkViewHolder(
        private val binding: ItemNoteBinding
    ) : ViewHolder(binding.root) {
        fun bind(item: Note) {
            with(binding) {
                tvStartTime.text = item.timeStart
                item.timeEnd.let { tvEndTime.text = it }
                tvTitle.text = item.title
                item.description.let { tvDescription.text = it }
            }
        }
    }
}