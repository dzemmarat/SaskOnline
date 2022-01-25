package com.mrz.saskonline.ui.home.timetable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrz.saskonline.databinding.FragmentHomeworkBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.ui.core.DelegationAdapter
import com.mrz.saskonline.ui.home.timetable.adapter.TimetableDelegate
import com.mrz.saskonline.viewmodel.home.HomeViewModel
import kotlinx.coroutines.flow.collect

class TimetableFragment : BaseFragment<HomeViewModel, FragmentHomeworkBinding>() {

    override val viewModel: HomeViewModel by viewModels()
    private val homeworkAdapter by lazy { DelegationAdapter() }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeworkBinding =
        FragmentHomeworkBinding.inflate(layoutInflater, container, false)

    override fun setupViews() {
        viewModel.createTestElements()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        homeworkAdapter.apply {
            delegatesManager.addDelegate(
                TimetableDelegate()
            )
            lifecycleScope.launchWhenStarted {
                viewModel.lessons.collect {
                    items = it
                }
            }
        }
        binding.rvSchedule.apply {
            adapter = homeworkAdapter
            layoutManager = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
        }
    }
}