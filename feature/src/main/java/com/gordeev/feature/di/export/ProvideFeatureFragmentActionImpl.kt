package com.gordeev.feature.di.export

import androidx.fragment.app.Fragment
import com.gordeev.core.di.actions.ProvideFeatureFragmentAction
import com.gordeev.feature.FeatureFragment
import javax.inject.Inject

class ProvideFeatureFragmentActionImpl @Inject constructor(): ProvideFeatureFragmentAction {

    override fun get(): Fragment = FeatureFragment()
}