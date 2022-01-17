package com.mrz.saskonline.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mrz.saskonline.databinding.FragmentHomeBinding
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

    }
}