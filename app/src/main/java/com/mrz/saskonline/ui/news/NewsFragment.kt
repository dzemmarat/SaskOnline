package com.mrz.saskonline.ui.news

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentNewsBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.ui.core.DelegationAdapter
import com.mrz.saskonline.ui.news.adapter.NewsHeaderDelegate
import com.mrz.saskonline.viewmodel.news.NewsViewModel
import kotlinx.coroutines.flow.collect

class NewsFragment:
    BaseFragment<NewsViewModel, FragmentNewsBinding>() {

    override val viewModel: NewsViewModel by viewModels()
    private val newsHeaderAdapter by lazy { DelegationAdapter() }
    private val newsAdapter by lazy { DelegationAdapter() }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsBinding =
        FragmentNewsBinding.inflate(inflater, container, false)

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun setupViews() {
        viewModel.setupNewsHeader(listOf(
            resources.getDrawable(R.drawable.ic_world_skills),
            resources.getDrawable(R.drawable.ic_masters)
        ))
        viewModel.s
        setTitle(getString(R.string.title_news))
        setupNewsHeaderAdapter()
        setupNewsAdapter()
    }

    private fun setupNewsHeaderAdapter() {
        newsHeaderAdapter.delegatesManager.apply {
            addDelegate(NewsHeaderDelegate())
        }
        binding.rvHeaderNews.apply {
            adapter = newsHeaderAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        lifecycleScope.launchWhenStarted {
            viewModel.newsHeader.collect {
                newsHeaderAdapter.items = it
            }
        }
    }

    private fun setupNewsAdapter() {
        newsAdapter.delegatesManager.apply {
            addDelegate(NewsHeaderDelegate())
        }
        binding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        lifecycleScope.launchWhenStarted {
            viewModel.news.collect {
                newsHeaderAdapter.items = it
            }
        }
    }
}