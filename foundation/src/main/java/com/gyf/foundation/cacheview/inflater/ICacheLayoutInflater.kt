package com.gyf.foundation.cacheview.inflater

import android.view.ViewGroup
import com.gyf.foundation.cacheview.view.ViewCache

interface ICacheLayoutInflater<T, R> {
    val layoutInflater get() = LayoutInflaterHelper.getLayoutInflater()
    fun inflate(target: T, layoutParams: ViewGroup.LayoutParams?): ViewCache<R>
}