package com.mrz.saskonline.ui.home.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mrz.saskonline.databinding.FragmentScheduleBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.viewmodel.core.EmptyViewModel

class ScheduleFragment: BaseFragment<EmptyViewModel, FragmentScheduleBinding>() {
    override val viewModel: EmptyViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentScheduleBinding =
        FragmentScheduleBinding.inflate(layoutInflater, container, false)

    override fun setupViews() {

    }
}