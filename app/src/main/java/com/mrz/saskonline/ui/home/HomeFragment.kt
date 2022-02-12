package com.mrz.saskonline.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentHomeBinding
import com.mrz.saskonline.ui.home.adapter.FragmentAdapter
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
            val adapter = FragmentAdapter(parentFragmentManager, lifecycle)
            pager.adapter = adapter

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