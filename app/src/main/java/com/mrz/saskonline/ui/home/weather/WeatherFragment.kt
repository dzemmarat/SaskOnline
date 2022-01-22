package com.mrz.saskonline.ui.home.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mrz.saskonline.databinding.FragmentWeatherBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.viewmodel.core.EmptyViewModel

class WeatherFragment: BaseFragment<EmptyViewModel, FragmentWeatherBinding>() {
    override val viewModel: EmptyViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWeatherBinding =
        FragmentWeatherBinding.inflate(layoutInflater, container, false)

    override fun setupViews() {

    }
}