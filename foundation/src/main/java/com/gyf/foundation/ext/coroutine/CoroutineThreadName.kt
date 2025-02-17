package com.gyf.foundation.ext.coroutine

import kotlinx.coroutines.ThreadContextElement
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * CoroutineThreadName 类用于管理协程的线程名称。
 * 它实现了 ThreadContextElement 接口，可以在协程上下文中保存和恢复线程名称。
 *
 * @property name 线程名称。
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/17 11:43
 */
class CoroutineThreadName(val name: String) : ThreadContextElement<String>,
    AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<CoroutineThreadName>

    /**
     * 更新线程上下文的方法，将当前线程的名称设置为新的名称，并返回旧的名称。
     *
     * @param context 协程上下文。
     * @return 旧的线程名称。
     */
    override fun updateThreadContext(context: CoroutineContext): String {
        val previousName = Thread.currentThread().name
        Thread.currentThread().name = name
        return previousName
    }

    /**
     * 恢复线程上下文的方法，将当前线程的名称设置为旧的名称。
     *
     * @param context 协程上下文。
     * @param oldState 旧的线程名称。
     */
    override fun restoreThreadContext(context: CoroutineContext, oldState: String) {
        Thread.currentThread().name = oldState
    }
}