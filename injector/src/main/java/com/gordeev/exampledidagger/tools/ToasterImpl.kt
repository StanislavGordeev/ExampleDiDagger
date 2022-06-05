package com.gordeev.exampledidagger.tools

import android.content.Context
import android.widget.Toast
import com.gordeev.core.tools.Toaster

class ToasterImpl(private val appContext: Context): Toaster {
    override fun show(message: String) {
        Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show()
    }
}