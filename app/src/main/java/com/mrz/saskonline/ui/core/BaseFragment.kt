package com.mrz.saskonline.ui.core

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mrz.saskonline.ui.MainActivity
import com.mrz.saskonline.viewmodel.core.BaseViewModel
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel, VB : ViewBinding>(
    @LayoutRes
    layout: Int
) : Fragment(layout), HasDefaultViewModelProviderFactory {

    @Inject
    lateinit var defaultViewModelFactory: dagger.Lazy<SavedStateViewModelFactory>

    constructor() : this(0)

    protected abstract val viewModel: T

    private var _binding: VB? = null

    val binding get() = _binding!!

    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    val mainActivity: MainActivity get() = requireActivity() as MainActivity

    var isNavigationEnabled: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    abstract fun setupViews()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigationBar()
        setupViews()
    }

    private fun setupNavigationBar() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}