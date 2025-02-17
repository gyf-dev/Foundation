package com.gyf.foundation.cacheview.thread

import android.annotation.SuppressLint
import android.os.Looper
import android.util.Log
import android.view.ViewGroup
import com.gyf.foundation.cacheview.CacheView
import com.gyf.foundation.cacheview.async.CacheViewSetting
import com.gyf.foundation.cacheview.async.ICacheViewManager
import com.gyf.foundation.cacheview.callback.OnViewCacheFinishListener
import com.gyf.foundation.cacheview.view.ViewCache

abstract class AbstractViewRunnable<T, R>(
    private val target: T,
    private val layoutParams: ViewGroup.LayoutParams?,
    private val onViewCacheFinishListener: OnViewCacheFinishListener<R>?,
    private val iCacheViewManager: ICacheViewManager<T, R>,
) : Runnable {

    companion object {
        private const val TAG = "AbstractViewRunnable"
    }

    @Synchronized
    final override fun run() {
        try {
            forceSetMainLoop()
            execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 强制切换为MainLoop
     */
    @SuppressLint("DiscouragedPrivateApi")
    @Suppress("UNCHECKED_CAST")
    @Throws(Exception::class)
    private fun forceSetMainLoop() {
        val field = Looper::class.java.getDeclaredField("sThreadLocal")
        field.isAccessible = true
        val obj = field.get(Looper.getMainLooper())
        if (obj is ThreadLocal<*>) {
            (obj as ThreadLocal<Looper>).set(Looper.getMainLooper())
        }
    }

    /**
     * 真正处理view的地方
     */
    @Suppress("UNCHECKED_CAST")
    private fun execute() {
        val list = ICacheViewManager.viewMapLayout[target] ?: mutableListOf()
        for (a in list.size until CacheViewSetting.asyncViewMax) {
            val viewWrapper = generateViewCache(target, layoutParams)

            list.add(viewWrapper as ViewCache<Any>)
            onViewCacheFinishListener?.also {
                it.onViewCacheFinish(viewWrapper)
            }
        }
        ICacheViewManager.viewMapLayout.put(target, list)
        if (CacheView.instance.isDebug) {
            Log.i(TAG, "$target size-${ICacheViewManager.viewMapLayout[target].size}")
        }
    }

    abstract fun generateViewCache(target: T, layoutParams: ViewGroup.LayoutParams?): ViewCache<R>

}