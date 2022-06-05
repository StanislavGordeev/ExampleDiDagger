package com.gordeev.exampledidagger.di

import com.gordeev.core.di.ApplicationProvider
import com.gordeev.core.di.FeatureFragmentProvider
import com.gordeev.core.di.MainToolsProvider
import com.gordeev.exampledidagger.AppImpl
import com.gordeev.feature.di.export.FeatureFragmentExportComponent
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [MainToolsProvider::class,
        FeatureFragmentProvider::class
    ]
)
@Singleton
interface AppComponent: ApplicationProvider {
    fun inject(app: AppImpl)
    class Initializer private constructor() {
        companion object {
            fun init(app: AppImpl): AppComponent {
                val mainToolsProvider = MainToolsComponent.Initializer.init(app)
                val featureFragmentProvider = FeatureFragmentExportComponent.Initializer.init(mainToolsProvider)
                return DaggerAppComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .featureFragmentProvider(featureFragmentProvider)
                    .build()
            }
        }
    }
}