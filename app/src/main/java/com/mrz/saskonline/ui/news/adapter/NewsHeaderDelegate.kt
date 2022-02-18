package com.mrz.saskonline.ui.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mrz.saskonline.data.models.local.NewsHeader
import com.mrz.saskonline.databinding.ItemHeaderNewsBinding
import com.mrz.saskonline.ui.core.BaseAdapterDelegate

class NewsHeaderDelegate  : BaseAdapterDelegate() {
    override fun isForItem(item: Any, items: MutableList<Any>, position: Int): Boolean =
        item is NewsHeader

    override fun getViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder =
        HomeworkViewHolder(ItemHeaderNewsBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        val viewHolder = holder as HomeworkViewHolder
        viewHolder.bind(item as NewsHeader)
    }

    inner class HomeworkViewHolder(
        private val binding: ItemHeaderNewsBinding
    ) : ViewHolder(binding.root) {
        fun bind(item: NewsHeader) {
            with(binding) {
                tvTitle.text = item.title
                ivLogo.setImageDrawable(item.image)
            }
        }
    }
}