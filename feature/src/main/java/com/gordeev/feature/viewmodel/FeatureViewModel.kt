package com.gordeev.feature.viewmodel

import androidx.lifecycle.ViewModel
import com.gordeev.core.App

class FeatureViewModel(private val app: App): ViewModel() {

    init {
         app.getApplicationContext()
    }
}