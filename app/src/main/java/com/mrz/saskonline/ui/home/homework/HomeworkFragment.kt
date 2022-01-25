package com.mrz.saskonline.ui.home.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrz.saskonline.databinding.FragmentTimetableBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.ui.core.DelegationAdapter
import com.mrz.saskonline.ui.home.homework.adapter.DateDelegate
import com.mrz.saskonline.ui.home.homework.adapter.HomeworkDelegate
import com.mrz.saskonline.viewmodel.core.EmptyViewModel
import com.mrz.saskonline.viewmodel.home.HomeViewModel
import kotlinx.coroutines.flow.collect

class HomeworkFragment : BaseFragment<HomeViewModel, FragmentTimetableBinding>() {

    override val viewModel: HomeViewModel by viewModels()
    private val homeworkAdapter by lazy { DelegationAdapter() }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTimetableBinding =
        FragmentTimetableBinding.inflate(layoutInflater, container, false)

    override fun setupViews() {
        viewModel.createTestElements()
        viewModel.createListForHomework()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        homeworkAdapter.delegatesManager.apply {
            addDelegate(HomeworkDelegate())
            addDelegate(DateDelegate())
        }
        binding.rvHomework.apply {
            adapter = homeworkAdapter
            layoutManager = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.homeworkList.collect {
                homeworkAdapter.items = it
            }
        }
    }
}