package com.mrz.saskonline.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentNotesBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.ui.core.DelegationAdapter
import com.mrz.saskonline.ui.notes.adapter.DateDelegate
import com.mrz.saskonline.ui.notes.adapter.NotesDelegate
import com.mrz.saskonline.viewmodel.notes.NotesViewModel
import kotlinx.coroutines.flow.collect
import java.util.*

class NotesFragment :
    BaseFragment<NotesViewModel, FragmentNotesBinding>() {

    override val viewModel: NotesViewModel by viewModels()
    private val notesAdapter by lazy { DelegationAdapter() }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotesBinding =
        FragmentNotesBinding.inflate(inflater, container, false)

    override fun setupViews() {
        viewModel.createNotes()
        setTitle(getString(R.string.title_notes))
        setupCalendar()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        notesAdapter.delegatesManager.apply {
            addDelegate(NotesDelegate())
            addDelegate(DateDelegate())
        }
        binding.rvNotes.apply {
            adapter = notesAdapter
            layoutManager = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.notes.collect {
                notesAdapter.items = it
            }
        }

    }

    private fun setupCalendar() {
        with(binding) {
            eventsCalendar.setSelectionMode(eventsCalendar.MULTIPLE_SELECTION)
                .build()
        }
    }
}