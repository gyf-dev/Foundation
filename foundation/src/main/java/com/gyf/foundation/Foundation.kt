@file:Suppress("SameParameterValue")

package com.gyf.foundation

import android.annotation.SuppressLint
import android.content.Context
import com.gyf.foundation.ext.coroutine.ICoroutine
import com.gyf.foundation.ext.coroutine.coroutineScope
import com.gyf.foundation.ext.pkg.getClassesInPackage
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Foundation类，用于初始化和管理基础设施
 * The Foundation class, used for initializing and managing infrastructure
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/27 20:50
 */
@SuppressLint("StaticFieldLeak")
object Foundation : ICoroutine {


    /**
     * 上下文对象
     * Context object
     */
    lateinit var context: Context
        private set

    /**
     * 是否已经初始化
     * Whether it has been initialized
     */
    val isInitialized: Boolean
        get() = ::context.isInitialized

    private val mutex = Mutex()

    internal val invalidClientTagS = mutableSetOf<String>()

    /**
     * 初始化方法，接收一个上下文对象作为参数
     * Initialization method, accepts a context object as a parameter
     *
     * @param context Context 上下文对象
     *                The context object
     */
    fun init(context: Context) {
        if (::context.isInitialized) {
            throw IllegalStateException("Foundation is already initialized")
        }
        this.context = context.applicationContext
        initInvalidClientTagS(context)
        "Foundation initialized".log
    }

    /**
     * 初始化无效的客户端标签集合
     *
     * @param context Context
     */
    private fun initInvalidClientTagS(context: Context) {
        coroutineScope.launch {
            mutex.withLock(invalidClientTagS) {
                context.getClassesInPackage("com.gyf.foundation.cs").forEach {
                    if (it.simpleName.isNotBlank()) {
                        invalidClientTagS += it.simpleName
                    }
                    if (it.name.isNotBlank()) {
                        invalidClientTagS += it.name
                    }
                }
            }
        }
    }

}