package com.gyf.foundation.cacheview.view

import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import com.gyf.foundation.cacheview.ext.isNightActive

@Keep
data class ViewCache<R>(
    val view: View,
    val layoutParams: ViewGroup.LayoutParams?,
    val result: R,
) {
    val isNightActive: Boolean = view.isNightActive
}