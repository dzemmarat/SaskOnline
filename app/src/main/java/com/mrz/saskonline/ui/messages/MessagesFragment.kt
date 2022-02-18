package com.mrz.saskonline.ui.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentMessagesBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.ui.core.DelegationAdapter
import com.mrz.saskonline.ui.messages.adapter.ConversationsDelegate
import com.mrz.saskonline.ui.messages.adapter.MessagesDelegate
import com.mrz.saskonline.viewmodel.messages.MessagesViewModel
import kotlinx.coroutines.flow.collect

class MessagesFragment :
    BaseFragment<MessagesViewModel, FragmentMessagesBinding>() {

    override val viewModel: MessagesViewModel by viewModels()
    private val messagesPrivateAdapter by lazy { DelegationAdapter() }
    private val messagesTeachersAdapter by lazy { DelegationAdapter() }
    private val conversationsAdapter by lazy { DelegationAdapter() }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessagesBinding =
        FragmentMessagesBinding.inflate(inflater, container, false)

    override fun setupViews() {
        setTitle(getString(R.string.title_messages))

        setupPrivateRecyclerView()
        setupTeachersRecyclerView()
        setupConversationsRecyclerView()

        viewModel.setupConversations()
        viewModel.setupTeachersMessages(resources.getDrawable(R.drawable.ic_teacher_1), resources.getDrawable(R.drawable.ic_teacher_2))
        viewModel.setupPrivateMessages(resources.getDrawable(R.drawable.ic_message_1), resources.getDrawable(R.drawable.ic_message_2))
    }

    private fun setupPrivateRecyclerView() {
        messagesPrivateAdapter.delegatesManager.apply {
            addDelegate(MessagesDelegate())
        }
        binding.rvPrivate.apply {
            adapter = messagesPrivateAdapter
            layoutManager = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.privateMessages.collect {
                messagesPrivateAdapter.items = it
            }
        }
    }

    private fun setupTeachersRecyclerView() {
        messagesTeachersAdapter.delegatesManager.apply {
            addDelegate(MessagesDelegate())
        }
        binding.rvTeachers.apply {
            adapter = messagesTeachersAdapter
            layoutManager = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.teachersMessages.collect {
                messagesTeachersAdapter.items = it
            }
        }

    }

    private fun setupConversationsRecyclerView() {
        conversationsAdapter.delegatesManager.apply {
            addDelegate(ConversationsDelegate())
        }
        binding.rvConversations.apply {
            adapter = conversationsAdapter
            layoutManager = object : LinearLayoutManager(context, HORIZONTAL, false) {
                override fun canScrollVertically(): Boolean = false
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.conversationsMessages.collect {
                conversationsAdapter.items = it
            }
        }

    }
}