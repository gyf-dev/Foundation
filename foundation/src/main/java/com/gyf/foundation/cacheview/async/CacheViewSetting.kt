package com.gyf.foundation.cacheview.async

import com.gyf.foundation.cacheview.ext.cpuExecutor

/**
 * @author geyifeng
 * @date 2020/4/15 6:13 PM
 */
object CacheViewSetting {

    /**
     * 所有缓存view最大值
     */
    private const val ASYNC_VIEW_MAX_ALL = Int.MAX_VALUE

    /**
     * 缓存view最大值
     */
    private const val ASYNC_VIEW_MAX = 8

    /**
     * 缓存view最小值
     */
    private const val ASYNC_VIEW_MIN = ASYNC_VIEW_MAX / 4

    /**
     * 线程池
     */
    var executor = cpuExecutor

    /**
     * 所有缓存view最大值
     */
    var asyncViewMaxAll: Int = 10000
        set(value) {
            field = if (value < ASYNC_VIEW_MAX_ALL) value else ASYNC_VIEW_MAX_ALL
        }

    /**
     * 缓存view最大值
     */
    var asyncViewMax: Int = ASYNC_VIEW_MAX
        set(value) {
            field = if (value < ASYNC_VIEW_MAX) value else ASYNC_VIEW_MAX
        }

    /**
     * 缓存view临界点，当小于这个临界点的时候会自动缓存view到最大值
     */
    var asyncViewCritical: Int = ASYNC_VIEW_MIN
        set(value) {
            field = if (value < ASYNC_VIEW_MIN) value else ASYNC_VIEW_MIN
        }

    /**
     * 是否可以使用缓存view
     */
    var asyncViewEnabled = true

}