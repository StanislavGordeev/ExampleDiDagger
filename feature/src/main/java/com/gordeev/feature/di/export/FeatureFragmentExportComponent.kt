package com.gordeev.feature.di.export

import com.gordeev.core.di.FeatureFragmentProvider
import com.gordeev.core.di.MainToolsProvider
import dagger.Component

@Component(
    dependencies = [MainToolsProvider::class],
    modules = [FeatureFragmentExportModule::class])

interface FeatureFragmentExportComponent : FeatureFragmentProvider {
    class Initializer private constructor() {
        companion object {
            fun init(mainToolsProvider: MainToolsProvider): FeatureFragmentProvider =
                DaggerFeatureFragmentExportComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .build()
        }
    }
}