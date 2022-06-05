package com.gordeev.feature.di.export

import com.gordeev.core.di.actions.ProvideFeatureFragmentAction
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureFragmentExportModule {

    @Binds
    abstract fun showFeatureFragment(showFeatureFragmentActionImpl: ProvideFeatureFragmentActionImpl): ProvideFeatureFragmentAction
}