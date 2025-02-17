@file:Suppress("UNCHECKED_CAST")

package com.gyf.foundation.cacheview.async

import android.content.Context
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.gyf.foundation.cacheview.async.ICacheViewManager.Companion.cacheRunnableMap
import com.gyf.foundation.cacheview.async.ICacheViewManager.Companion.viewMapLayout
import com.gyf.foundation.cacheview.callback.OnViewCacheFinishListener
import com.gyf.foundation.cacheview.ext.isClassOf
import com.gyf.foundation.cacheview.inflater.LayoutCacheLayoutInflater
import com.gyf.foundation.cacheview.inflater.ViewBindingCacheLayoutInflater
import com.gyf.foundation.cacheview.thread.AbstractViewRunnable
import com.gyf.foundation.cacheview.view.ContextViewWrapper
import com.gyf.foundation.cacheview.view.ViewCache
import java.security.InvalidParameterException

/**
 * @author geyifeng
 * @date 2020/4/15 2:06 PM
 */
class CacheViewManager<T, R> : ICacheViewManager<T, R> {

    override fun preViewCache(
        target: T,
        layoutParams: ViewGroup.LayoutParams?,
        onViewCacheFinishListener: OnViewCacheFinishListener<R>?,
    ) {
        if (CacheViewSetting.asyncViewEnabled) {
            var runnable = cacheRunnableMap[target as Any]
            if (runnable == null) {
                runnable = newRunnable(target, layoutParams, onViewCacheFinishListener)
                cacheRunnableMap[target] = runnable
            }
            CacheViewSetting.executor.execute(runnable)
        }
    }

    override fun getViewCache(realContext: Context, target: T): ViewCache<R>? {
        if (target == null) {
            return null
        }
        var viewCache1: ViewCache<R>? = null
        if (CacheViewSetting.asyncViewEnabled) {
            viewMapLayout.get(target)?.also { v ->
                if (v.size > 0) {
                    val viewCache = v.firstOrNull()
                    viewCache1 = viewCache as ViewCache<R>
                    viewCache1?.also {
                        if (it.view.context is ContextViewWrapper) {
                            (it.view.context as ContextViewWrapper).setCurrentContext(realContext)
                        }
                    }
                    v.remove(viewCache)
                    preViewCache(target, viewCache1?.layoutParams, null)
                }
            }
        }
        return viewCache1
    }

    @Suppress("UNCHECKED_CAST")
    private fun newRunnable(
        target: T,
        layoutParams: ViewGroup.LayoutParams?,
        onViewCacheFinishListener: OnViewCacheFinishListener<R>?,
    ): AbstractViewRunnable<T, R> {
        return object :
            AbstractViewRunnable<T, R>(
                target,
                layoutParams,
                onViewCacheFinishListener,
                this@CacheViewManager
            ) {

            override fun generateViewCache(
                target: T,
                layoutParams: ViewGroup.LayoutParams?,
            ): ViewCache<R> {
                return when (target) {
                    is Int -> LayoutCacheLayoutInflater<R>().inflate(target, layoutParams)

                    is Class<*> -> {
                        val clazz = target as Class<*>
                        when {

                            clazz.isClassOf(ViewBinding::class.java) -> {
                                ViewBindingCacheLayoutInflater<R>().inflate(
                                    clazz as Class<ViewBinding>,
                                    layoutParams
                                )
                            }

                            else ->
                                throw InvalidParameterException("$target is unsupported type")
                        }

                    }

                    else ->
                        throw InvalidParameterException("$target is unsupported type")
                }

            }

        }
    }
}