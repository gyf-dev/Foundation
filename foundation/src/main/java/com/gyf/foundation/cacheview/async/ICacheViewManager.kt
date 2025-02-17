package com.gyf.foundation.cacheview.async

import android.content.Context
import android.util.LruCache
import android.view.ViewGroup
import com.gyf.foundation.cacheview.callback.OnViewCacheFinishListener
import com.gyf.foundation.cacheview.view.ViewCache

/**
 * @author geyifeng
 * @date 2020/4/15 2:04 PM
 */
interface ICacheViewManager<T, R> {

    companion object {

        val viewMapLayout: LruCache<Any, MutableList<ViewCache<Any>>> =
            object : LruCache<Any, MutableList<ViewCache<Any>>>(CacheViewSetting.asyncViewMaxAll) {
                override fun sizeOf(key: Any, value: MutableList<ViewCache<Any>>): Int {
                    return value.size
                }
            }

        val cacheRunnableMap: MutableMap<Any, Runnable> = mutableMapOf()
    }

    fun preViewCache(
        target: T,
        layoutParams: ViewGroup.LayoutParams?,
        onViewCacheFinishListener: OnViewCacheFinishListener<R>?,
    )

    fun getViewCache(realContext: Context, target: T): ViewCache<R>?
}