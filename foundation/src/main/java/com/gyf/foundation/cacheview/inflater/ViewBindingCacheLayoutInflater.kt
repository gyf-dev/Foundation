@file:Suppress("UNCHECKED_CAST")

package com.gyf.foundation.cacheview.inflater

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.gyf.foundation.cacheview.view.ViewCache
import com.gyf.foundation.ext.viewbinding.inflateBinding

class ViewBindingCacheLayoutInflater<R> : ICacheLayoutInflater<Class<ViewBinding>, R> {
    override fun inflate(
        target: Class<ViewBinding>,
        layoutParams: ViewGroup.LayoutParams?,
    ): ViewCache<R> {
        val binding = target.inflateBinding(layoutInflater)
        return ViewCache(binding.root, layoutParams, binding as R)
    }

}