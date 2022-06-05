package com.gordeev.core.di.actions

import androidx.fragment.app.Fragment

interface ProvideFeatureFragmentAction {

    fun get(): Fragment
}