package com.mrz.saskonline.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentHomeBinding
import com.mrz.saskonline.ui.home.adapter.FragmentAdapter
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.ui.home.homework.HomeworkFragment
import com.mrz.saskonline.ui.home.timetable.TimetableFragment
import com.mrz.saskonline.ui.home.weather.WeatherFragment
import com.mrz.saskonline.viewmodel.home.HomeViewModel

class HomeFragment :
    BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun setupViews() {
        setTitle(getString(R.string.title_home))
        with(binding) {
            tvHeader.text = getString(R.string.hello_user, "Марат Джеманкулов")
        }
    }

    override fun onStart() {
        super.onStart()
        setupTabLayoutAndPager()
    }

    private fun setupTabLayoutAndPager() {
        with(binding) {
            val adapter = FragmentAdapter(childFragmentManager, lifecycle)

            adapter.addFragment(TimetableFragment(), getString(R.string.tab_timetable))
            adapter.addFragment(HomeworkFragment(), getString(R.string.tab_homework))
            adapter.addFragment(WeatherFragment(), getString(R.string.tab_weather))

            pager.adapter = adapter
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                tab.text = adapter.getPageTitle(position)
            }.attach()

        }
    }
}