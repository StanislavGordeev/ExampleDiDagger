package com.gordeev.feature.di

import com.gordeev.core.di.ApplicationProvider
import com.gordeev.feature.FeatureFragment
import dagger.Component

@Component(
    dependencies = [ApplicationProvider::class],
    modules = [FeatureModule::class]
)
interface FeatureComponent {
    fun inject(fragment: FeatureFragment)

    class Initializer private constructor() {
        companion object {
            fun init(appComponent: ApplicationProvider): FeatureComponent =
                DaggerFeatureComponent.builder()
                    .applicationProvider(appComponent)
                    .build()
        }
    }
}