package com.mrz.saskonline.ui.messages.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mrz.saskonline.data.models.local.Message
import com.mrz.saskonline.databinding.ItemMessageBinding
import com.mrz.saskonline.ui.core.BaseAdapterDelegate

class MessagesDelegate : BaseAdapterDelegate() {
    override fun isForItem(item: Any, items: MutableList<Any>, position: Int): Boolean =
        item is Message

    override fun getViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder =
        HomeworkViewHolder(ItemMessageBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        val viewHolder = holder as HomeworkViewHolder
        viewHolder.bind(item as Message)
    }

    inner class HomeworkViewHolder(
        private val binding: ItemMessageBinding
    ) : ViewHolder(binding.root) {
        fun bind(item: Message) {
            with(binding) {
                tvTitle.text = item.title
                ivTeacherAvatar.setImageDrawable(item.logo)
                tvMessage.text = item.lastMessage
            }
        }
    }
}