package com.gordeev.exampledidagger

import android.app.Application
import com.gordeev.core.App
import com.gordeev.core.di.ApplicationProvider
import com.gordeev.exampledidagger.di.AppComponent

class AppImpl: Application(), App {

    private val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this@AppImpl) }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun getAppComponent(): ApplicationProvider = appComponent
}