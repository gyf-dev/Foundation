@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.ext.coroutine

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.gyf.foundation.ext.log.ITag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

/**
 * ICoroutine 接口定义了协程的基本行为。
 * 它继承了 ITag 接口，可以获取日志标签和日志级别，以及打印日志。
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/21 10:58
 */
interface ICoroutine : ITag, LifecycleEventObserver {

    /**
     * 声明周期
     *
     * @param source LifecycleOwner 生命周期所有者
     * @param event Event 生命周期事件
     */
    @CallSuper
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                removeAllScope()
                source.lifecycle.removeObserver(this)
            }

            else -> {

            }
        }
    }

    fun <T> Flow<T>.collectQuick(
        scope: CoroutineScope = coroutineScope,
        collector: FlowCollector<T>
    ) = scope.launch { collect(collector) }


    fun <T> Flow<T>.collectQuick2(
        scope: CoroutineScope = coroutineScope,
        block: (scope: CoroutineScope, value: T) -> Unit
    ) = scope.launch { collect { block(this, it) } }
}