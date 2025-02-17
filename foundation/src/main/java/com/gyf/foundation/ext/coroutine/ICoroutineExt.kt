package com.gyf.foundation.ext.coroutine

import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import java.util.concurrent.ConcurrentHashMap

/**
 * ICoroutineExt 文件包含了一些关于 ICoroutine 的扩展函数和属性。
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/21 15:23
 */

/**
 * 默认协程作用域的哈希映射，用于存储协程作用域。
 */
private val defaultScopeHashMap = ConcurrentHashMap<Any, CoroutineScope>()

/**
 * IO协程作用域的哈希映射，用于存储IO协程作用域。
 */
private val ioScopeHashMap = ConcurrentHashMap<Any, CoroutineScope>()


/**
 * Main协程作用域的哈希映射，用于存储Main协程作用域。
 */
private val mainScopeHashMap = ConcurrentHashMap<Any, CoroutineScope>()

/**
 * ICoroutine 的默认协程作用域属性，如果不存在则创建一个新的协程作用域并存入 defaultScopeHashMap。
 */
val ICoroutine.coroutineScope: CoroutineScope
    get() = defaultScopeHashMap.getOrPut(this) {
        CoroutineScope(
            SupervisorJob()
                    + Dispatchers.Default
                    + CoroutineName("$tagName-Default")
                    + CoroutineThreadName("$tagName-Default")
        )
    }

/**
 * ICoroutine 的 IO 协程作用域属性，如果不存在则创建一个新的 IO 协程作用域并存入 ioScopeHashMap。
 */
val ICoroutine.ioScope: CoroutineScope
    get() = ioScopeHashMap.getOrPut(this) {
        CoroutineScope(
            SupervisorJob()
                    + Dispatchers.IO
                    + CoroutineName("$tagName-IO")
                    + CoroutineThreadName("$tagName-IO")
        )
    }

val ICoroutine.mainScope: CoroutineScope
    get() = mainScopeHashMap.getOrPut(this) {
        CoroutineScope(
            SupervisorJob()
                    + Dispatchers.Main.immediate
                    + CoroutineName("$tagName-Main")
                    + CoroutineThreadName("$tagName-Main")
        )
    }

/**
 * 移除 ICoroutine 的默认协程作用域的方法，从 defaultScopeHashMap 中移除对应的协程作用域。
 */
fun ICoroutine.removeDefaultScope() {
    if (defaultScopeHashMap.contains(this)) {
        coroutineScope.cancel()
    }
    defaultScopeHashMap.remove(this)
}

/**
 * 移除 ICoroutine 的 IO 协程作用域的方法，从 ioScopeHashMap 中移除对应的协程作用域。
 */
fun ICoroutine.removeIoScope() {
    if (ioScopeHashMap.contains(this)) {
        ioScope.cancel()
    }
    ioScopeHashMap.remove(this)
}

/**
 * 移除 ICoroutine 的 Main 协程作用域的方法，从 mainScopeHashMap 中移除对应的协程作用域。
 */
fun ICoroutine.removeMainScope() {
    if (mainScopeHashMap.contains(this)) {
        mainScope.cancel()
    }
    mainScopeHashMap.remove(this)
}

/**
 * 移除 ICoroutine 的所有协程作用域的方法，从 defaultScopeHashMap ,ioScopeHashMap,mainScopeHashMap 中移除对应的协程作用域。
 */
fun ICoroutine.removeAllScope() {
    removeDefaultScope()
    removeIoScope()
    removeMainScope()
}

/**
 * 绑定 ICoroutine 的生命周期方法
 *
 * @receiver ICoroutine
 * @param lifecycleOwner LifecycleOwner 生命周期所有者
 * @return ICoroutine
 */
fun ICoroutine.bindLifecycleOwner(lifecycleOwner: LifecycleOwner) {
    lifecycleOwner.lifecycle.addObserver(this)
}

/**
 * 解绑 ICoroutine 的生命周期方法
 *
 * @receiver ICoroutine
 * @param lifecycleOwner LifecycleOwner 生命周期所有者
 * @return ICoroutine
 */
fun ICoroutine.unbindLifecycleOwner(lifecycleOwner: LifecycleOwner) {
    lifecycleOwner.lifecycle.removeObserver(this)
}