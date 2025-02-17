package com.gyf.foundation.cacheview.inflater

import android.view.LayoutInflater
import com.gyf.foundation.cacheview.CacheView

internal object LayoutInflaterHelper {

    private var mLayoutInflater: LayoutInflater =
        LayoutInflater.from(CacheView.instance.getDefaultContext())

    fun getLayoutInflater(): LayoutInflater {
        return mLayoutInflater.cloneInContext(CacheView.instance.getDefaultContext())
    }
}