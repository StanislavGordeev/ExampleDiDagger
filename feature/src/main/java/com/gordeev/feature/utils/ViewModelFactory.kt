package com.gordeev.feature.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gordeev.core.App
import com.gordeev.core.tools.Toaster
import com.gordeev.feature.viewmodel.FeatureViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val app: App,
    private val toaster: Toaster):
    ViewModelProvider.NewInstanceFactory() {
        override fun<T: ViewModel?> create(modelClass: Class<T>): T {
            return when (modelClass) {
                FeatureViewModel::class.java -> FeatureViewModel(app) as T
                else -> throw Throwable("Can't find viewModel class $modelClass")
            }
        }
}