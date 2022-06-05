package com.gordeev.core

import android.content.Context
import com.gordeev.core.di.ApplicationProvider

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationProvider
}