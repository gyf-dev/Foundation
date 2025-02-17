package com.gyf.foundation.cacheview.ext

import android.content.Context
import android.content.res.Configuration
import android.view.View
import com.gyf.foundation.cacheview.thread.ViewThreadFactory
import com.gyf.foundation.ext.resources.isOrientationLandscape
import com.gyf.foundation.ext.resources.isOrientationPortrait
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


private const val KEEP_ALIVE_SECONDS = 5
private val CPU_COUNT = Runtime.getRuntime().availableProcessors()
private val CORE_POOL_SIZE = 2.coerceAtLeast((CPU_COUNT - 1).coerceAtMost(5))
private val MAXIMUM_POOL_SIZE = CORE_POOL_SIZE

/**
 * 线程池
 */
internal val cpuExecutor by lazy {
    ThreadPoolExecutor(
        CORE_POOL_SIZE,
        MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS.toLong(),
        TimeUnit.SECONDS, LinkedBlockingQueue(),
        ViewThreadFactory()
    ) { r, _ ->
        Executors.newCachedThreadPool().execute(r)
    }.apply {
        allowCoreThreadTimeOut(true)
    }
}


val Class<*>.isInt get() = isClassOf(java.lang.Integer::class.java) || isClassOf(Int::class.java)

fun <T> Class<*>.isClassOf(clazz: Class<T>) = clazz.isAssignableFrom(this)

val Configuration.isNightActive
    get() = uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

val Context.isNightActive
    get() = resources.configuration.isNightActive

val View.isNightActive
    get() = resources.configuration.isNightActive

val Context.isOrientationPortrait
    get() = resources.isOrientationPortrait

val View.isOrientationPortrait get() = context.isOrientationPortrait

val Context.isOrientationLandscape
    get() = resources.isOrientationLandscape

val View.isOrientationLandscape get() = context.isOrientationLandscape
