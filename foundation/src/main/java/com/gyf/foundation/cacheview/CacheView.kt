package com.gyf.foundation.cacheview

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import com.gyf.foundation.cacheview.async.CacheViewManager
import com.gyf.foundation.cacheview.callback.OnViewCacheFinishListener
import com.gyf.foundation.cacheview.ext.isNightActive
import com.gyf.foundation.cacheview.view.ContextViewWrapper

/**
 * @author geyifeng
 * @date 2020/4/15 1:35 PM
 */
class CacheView private constructor() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context

        @JvmStatic
        fun init(context: Context) {
            if (!this::context.isInitialized) {
                this.context = context
            }
        }

        @JvmStatic
        val instance by lazy { CacheView() }
    }

    /**
     * 是否debug模式
     */
    internal var isDebug = false

    /**
     * view的context的包装类
     */
    private var defaultContext = ContextViewWrapper(context)

    /**
     * 是否debug模式
     *
     * @param debug Boolean
     * @return CacheViewHelper
     */
    fun setDebug(debug: Boolean) = apply {
        isDebug = debug
    }

    /**
     * 获得ContextViewWrapper
     *
     * @return ContextViewWrapper
     */
    fun getDefaultContext() = defaultContext

    @JvmOverloads
    fun <T, R> preViewCache(
        target: T,
        layoutParams: ViewGroup.LayoutParams? = null,
        onViewCacheFinishListener: OnViewCacheFinishListener<R>? = null,
    ) = apply {
        CacheViewManager<T, R>().preViewCache(target, layoutParams, onViewCacheFinishListener)
    }

    fun <T, R> preViewCache(
        target: T,
        onViewCacheFinishListener: OnViewCacheFinishListener<R>,
    ) = apply {
        CacheViewManager<T, R>().preViewCache(target, null, onViewCacheFinishListener)
    }

    fun <T, R> getViewCache(
        context: Context, owner: T,
    ) = CacheViewManager<T, R>().getViewCache(context, owner)?.apply {
        if (context.isNightActive != isNightActive) {
            // nothing
        }
    }
}