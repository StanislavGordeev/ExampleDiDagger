package com.gordeev.work.di

import com.gordeev.core.di.ApplicationProvider
import com.gordeev.work.MainActivity
import dagger.Component
@Component(
    dependencies = [ApplicationProvider::class]
)
interface MainComponent {
    fun inject(activity: MainActivity)

    class Initializer private constructor() {
        companion object {
            fun init(appComponent: ApplicationProvider): MainComponent =
                DaggerMainComponent.builder()
                    .applicationProvider(appComponent)
                    .build()
        }
    }
}