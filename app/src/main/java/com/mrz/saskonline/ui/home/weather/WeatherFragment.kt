package com.mrz.saskonline.ui.home.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.mrz.saskonline.R
import com.mrz.saskonline.app.core.Util
import com.mrz.saskonline.data.models.remote.responses.WeatherResponse
import com.mrz.saskonline.databinding.FragmentWeatherBinding
import com.mrz.saskonline.extensions.gone
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.ui.core.DelegationAdapter
import com.mrz.saskonline.ui.home.weather.adapter.WeatherDelegate
import com.mrz.saskonline.viewmodel.core.Status
import com.mrz.saskonline.viewmodel.home.HomeViewModel
import kotlinx.coroutines.flow.collect

class WeatherFragment : BaseFragment<HomeViewModel, FragmentWeatherBinding>() {

    override val viewModel: HomeViewModel by viewModels()
    private val weatherAdapter by lazy { DelegationAdapter() }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWeatherBinding =
        FragmentWeatherBinding.inflate(layoutInflater, container, false)

    override fun setupViews() {
        setupRecyclerView()
        setupTabLayout()
        viewModel.getWeatherList()

        binding.containerImportant.tvAnonsTitle.text =
            getString(R.string.weather_message)
        binding.containerImportant.tvAnonsDescription.gone()
    }

    private fun setupTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object: OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewModel.isTodayWeather = tab.position == 0
                }
                setupRecyclerViewItems()
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupRecyclerView() {
        weatherAdapter.delegatesManager.addDelegate(
            WeatherDelegate(requireActivity())
        )
        binding.rvHourlyWeather.apply {
            adapter = weatherAdapter
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        setupRecyclerViewItems()
    }

    private fun setupRecyclerViewItems() {
        lifecycleScope.launchWhenStarted {
            viewModel.weatherList.collect { weather ->
                when (weather.status) {
                    Status.SUCCESS -> {
                        weatherAdapter.items = if (viewModel.isTodayWeather) {
                            (weather.data as MutableList<WeatherResponse>).filter {
                                it.dt_txt.subSequence(0,10) == Util.getCurrentDate().subSequence(0,10)
                            }
                        } else {
                            (weather.data as MutableList<WeatherResponse>).filter {
                                it.dt_txt.subSequence(0,10) == Util.getTomorrowDate()
                            }
                        }
                    }
                    Status.LOADING -> {
                        Toast.makeText(requireContext(), "Loading weather", Toast.LENGTH_SHORT).show()
                    }
                    Status.ERROR -> {
                        Toast.makeText(requireContext(), "Error ${weather.error}", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }

}