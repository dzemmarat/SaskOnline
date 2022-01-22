package com.mrz.saskonline.ui.home.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mrz.saskonline.databinding.FragmentHomeworkBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.viewmodel.core.EmptyViewModel

class HomeworkFragment: BaseFragment<EmptyViewModel, FragmentHomeworkBinding>() {
    override val viewModel: EmptyViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeworkBinding =
        FragmentHomeworkBinding.inflate(layoutInflater, container, false)

    override fun setupViews() {

    }
}