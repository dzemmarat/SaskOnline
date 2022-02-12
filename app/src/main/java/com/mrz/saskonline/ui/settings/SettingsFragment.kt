package com.mrz.saskonline.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.FragmentSettingsBinding
import com.mrz.saskonline.ui.core.BaseFragment
import com.mrz.saskonline.viewmodel.messages.MessagesViewModel
import com.mrz.saskonline.viewmodel.settings.SettingsViewModel

class SettingsFragment:
    BaseFragment<SettingsViewModel, FragmentSettingsBinding>() {

    override val viewModel: SettingsViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingsBinding =
        FragmentSettingsBinding.inflate(inflater, container, false)

    override fun setupViews() {
        setTitle(getString(R.string.title_settings))
    }
}