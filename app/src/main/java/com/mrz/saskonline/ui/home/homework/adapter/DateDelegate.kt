package com.mrz.saskonline.ui.home.homework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mrz.saskonline.data.models.Date
import com.mrz.saskonline.databinding.ItemDateBinding
import com.mrz.saskonline.ui.core.BaseAdapterDelegate

class DateDelegate : BaseAdapterDelegate() {
    override fun isForItem(item: Any, items: MutableList<Any>, position: Int): Boolean =
        item is Date

    override fun getViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder =
        HomeworkViewHolder(ItemDateBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        val viewHolder = holder as HomeworkViewHolder
        viewHolder.bind(item as Date)
    }

    inner class HomeworkViewHolder(
        private val binding: ItemDateBinding
    ) : ViewHolder(binding.root) {
        fun bind(item: Date) {
            with(binding) {
                tvDate.text = item.date
            }
        }
    }
}