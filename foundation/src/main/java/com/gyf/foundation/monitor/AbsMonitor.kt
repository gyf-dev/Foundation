@file:Suppress("PropertyName", "MemberVisibilityCanBePrivate")

package com.gyf.foundation.monitor

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.gyf.foundation.ext.coroutine.ICoroutine
import com.gyf.foundation.ext.flow.stateFlow
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 抽象监视器类
 * Abstract monitor class
 *
 * @Author  Ifan.Ge
 * @Date    2024/5/21 19:05
 */
abstract class AbsMonitor<T>(defaultValue: T) : ICoroutine {

    /**
     * 值属性，通过stateFlow获取值
     * Value property, get the default value through stateFlow
     */
    val value by stateFlow(defaultValue)

    /**
     * 是否已启动的标志
     * Flag of whether it has started
     */
    private var isStart = AtomicBoolean(false)

    /**
     * 启动方法
     * Start method
     */
    fun start() {
        if (!isStart.get()) {
            isStart.set(true)
            startInternal()
        }
    }

    /**
     * 停止方法
     * Stop method
     */
    fun stop() {
        if (isStart.get()) {
            isStart.set(false)
            stopInternal()
        }
    }

    /**
     * 声明周期
     *
     * @param source LifecycleOwner 生命周期所有者
     * @param event Event 生命周期事件
     */
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        super.onStateChanged(source, event)
        when (event) {
            Lifecycle.Event.ON_CREATE -> start()
            Lifecycle.Event.ON_DESTROY -> stop()
            else -> {
            }
        }
    }

    /**
     * 内部启动方法，由子类实现
     * Internal start method, implemented by subclasses
     */
    protected abstract fun startInternal()

    /**
     * 内部停止方法，由子类实现
     * Internal stop method, implemented by subclasses
     */
    protected abstract fun stopInternal()

}