package com.gordeev.work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gordeev.core.di.ApplicationProvider
import com.gordeev.core.di.actions.ProvideFeatureFragmentAction
import com.gordeev.injector.R
import com.gordeev.work.di.MainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var provideFeatureFragmentAction: ProvideFeatureFragmentAction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, provideFeatureFragmentAction.get())
            .commit()
    }

    private fun inject(appComponent: ApplicationProvider){
        MainComponent
            .Initializer
            .init(appComponent)
            .inject(this@MainActivity)
    }
}