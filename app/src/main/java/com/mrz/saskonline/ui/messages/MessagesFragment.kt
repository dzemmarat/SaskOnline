package com.mrz.saskonline.ui.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentMessagesBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.viewmodel.messages.MessagesViewModel

class MessagesFragment:
    BaseFragment<MessagesViewModel, FragmentMessagesBinding>() {

    override val viewModel: MessagesViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessagesBinding =
        FragmentMessagesBinding.inflate(inflater, container, false)

    override fun setupViews() {
        setTitle(getString(R.string.title_messages))
    }
}