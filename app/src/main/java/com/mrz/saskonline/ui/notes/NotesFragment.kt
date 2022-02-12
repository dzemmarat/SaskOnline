package com.mrz.saskonline.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentNotesBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.viewmodel.notes.NotesViewModel

class NotesFragment:
    BaseFragment<NotesViewModel, FragmentNotesBinding>() {

    override val viewModel: NotesViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotesBinding =
        FragmentNotesBinding.inflate(inflater, container, false)

    override fun setupViews() {
        setTitle(getString(R.string.title_notes))
    }
}