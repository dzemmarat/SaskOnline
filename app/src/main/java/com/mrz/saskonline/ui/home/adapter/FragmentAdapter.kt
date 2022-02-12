package com.mrz.saskonline.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mrz.saskonline.ui.home.timetable.TimetableFragment
import com.mrz.saskonline.ui.home.homework.HomeworkFragment
import com.mrz.saskonline.ui.home.weather.WeatherFragment

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragmentList : MutableList<Fragment> =ArrayList()
    private val titleList : MutableList<String> =ArrayList()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return  fragmentList[position]
    }


    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

    fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}