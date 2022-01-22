package com.mrz.saskonline.ui.home

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentHomeBinding
import com.mrz.saskonline.ui.adapter.FragmentAdapter
import com.mrz.saskonline.ui.core.BaseFragment
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
        with(binding) {
            tvHeader.text = getString(R.string.hello_user, "Марат Джеманкулов")

            Handler(Looper.getMainLooper()).postDelayed({
                setupTabLayout()
            }, 500)
        }
    }

    private fun setupTabLayout() {
        with(binding) {
            val adapter = FragmentAdapter(parentFragmentManager, lifecycle)
            pager.adapter = adapter

            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_homework)))
            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_schedule)))
            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_weather)))

            tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab != null) {
                        pager.currentItem = tab.position
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })

            pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    tabLayout.selectTab(tabLayout.getTabAt(position))
                }
            })
        }
    }
}