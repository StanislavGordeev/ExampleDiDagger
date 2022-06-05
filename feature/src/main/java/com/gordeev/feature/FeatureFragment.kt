package com.gordeev.feature

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.gordeev.core.App
import com.gordeev.core.di.ApplicationProvider
import com.gordeev.core.tools.Toaster
import com.gordeev.feature.di.FeatureComponent
import com.gordeev.feature.utils.ViewModelFactory
import com.gordeev.feature.viewmodel.FeatureViewModel
import kotlinx.android.synthetic.main.fragment_feature.*
import javax.inject.Inject

class FeatureFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: FeatureViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(FeatureViewModel::class.java)
    }

    @Inject
    lateinit var toaster: Toaster

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToaster.setOnClickListener {
            toaster.show("ТОСТЕР")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject((context.applicationContext as App).getAppComponent())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature, container, false)
    }

    private fun inject(appComponent: ApplicationProvider){
        FeatureComponent
            .Initializer
            .init(appComponent)
            .inject(this@FeatureFragment)
    }
}