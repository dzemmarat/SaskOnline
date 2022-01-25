package com.mrz.saskonline.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mrz.saskonline.ui.home.timetable.TimetableFragment
import com.mrz.saskonline.ui.home.homework.HomeworkFragment
import com.mrz.saskonline.ui.home.weather.WeatherFragment

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> HomeworkFragment()
            2 -> WeatherFragment()
            else -> TimetableFragment()
        }
    }
}