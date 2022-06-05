package com.gordeev.core.di

import com.gordeev.core.App
import com.gordeev.core.di.actions.ProvideFeatureFragmentAction
import com.gordeev.core.tools.Toaster

interface ApplicationProvider :
    MainToolsProvider,
    FeatureFragmentProvider

interface MainToolsProvider {
    fun provideContext(): App
    fun provideToast(): Toaster
}

interface FeatureFragmentProvider {
    fun provideFeatureFragment(): ProvideFeatureFragmentAction
}