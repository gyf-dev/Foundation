package com.gyf.foundation.cacheview.inflater

import android.view.ViewGroup
import com.gyf.foundation.cacheview.view.ViewCache
import java.security.InvalidParameterException

class LayoutCacheLayoutInflater<R> : ICacheLayoutInflater<Int, R> {
    @Suppress("UNCHECKED_CAST")
    override fun inflate(target: Int, layoutParams: ViewGroup.LayoutParams?): ViewCache<R> {

        if (target <= 0) {
            throw InvalidParameterException("LayoutId must be greater than 0")
        }
        val view = layoutInflater.inflate(target, null)
        return ViewCache(view, layoutParams, view as R)
    }
}