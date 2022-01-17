package com.mrz.saskonline.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mrz.saskonline.databinding.FragmentNewsBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.viewmodel.news.NewsViewModel

class NewsFragment:
    BaseFragment<NewsViewModel, FragmentNewsBinding>() {

    override val viewModel: NewsViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsBinding =
        FragmentNewsBinding.inflate(inflater, container, false)

    override fun setupViews() {

    }
}