package com.gyf.foundation.ext.flow

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 扩展包，包含了一些关于 StateFlow 的扩展方法和类
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/20 14:52
 */

/**
 * 创建一个 StateFlowWrapperDelegate 实例
 *
 * @param initializer 用于初始化 StateFlowWrapperDelegate 的函数
 * @return 返回一个 StateFlowWrapperDelegate 实例
 */
fun <T> stateFlow(initializer: () -> T): StateFlowWrapperDelegate<T> =
    StateFlowWrapperDelegate(initializer)

/**
 * 创建一个 StateFlowWrapperDelegate 实例
 *
 * @param value 用于初始化 StateFlowWrapperDelegate 的值
 * @return 返回一个 StateFlowWrapperDelegate 实例
 */
fun <T> stateFlow(value: T): StateFlowWrapperDelegate<T> =
    StateFlowWrapperDelegate { value }

/**
 * 创建一个 StateFlowDelegate 实例
 *
 * @param initializer 用于初始化 StateFlowDelegate 的函数
 * @return 返回一个 StateFlowDelegate 实例
 */
fun <T> stateFlowDelegate(initializer: () -> T): StateFlowDelegate<T> =
    StateFlowDelegate(initializer)

/**
 * 创建一个 StateFlowDelegate 实例
 *
 * @param value 用于初始化 StateFlowDelegate 的值
 * @return 返回一个 StateFlowDelegate 实例
 */
fun <T> stateFlowDelegate(value: T): StateFlowDelegate<T> =
    StateFlowDelegate { value }

/**
 * 定义一个接口，该接口提供了一个 asFlow 方法，用于将对象转换为 StateFlow
 */
interface StateFlowProvider<T> {
    fun asFlow(): StateFlow<T>
}

/**
 * StateFlowDelegate 类，实现了 ReadWriteProperty 接口和 StateFlowProvider 接口
 */
class StateFlowDelegate<T>(initializer: () -> T) : ReadWriteProperty<Any?, T>,
    StateFlowProvider<T> {

    /**
     * 创建一个 MutableStateFlow 实例
     *
     * State flow
     */
    internal val stateFlow = MutableStateFlow(initializer())

    /**
     * 重写 getValue 方法，返回 stateFlow 的当前值
     *
     * @param thisRef Any?
     * @param property KProperty<*>
     * @return T
     */
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return stateFlow.value
    }

    /**
     * 重写 setValue 方法，设置 stateFlow 的值
     *
     * @param thisRef Any?
     * @param property KProperty<*>
     * @param value T
     */
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        stateFlow.value = value
    }

    /**
     * 重写 asFlow 方法，返回 stateFlow
     *
     * @return StateFlow<T>
     */
    override fun asFlow(): StateFlow<T> = stateFlow
}

/**
 * StateFlowWrapper 类，包含了一个 StateFlowDelegate 实例
 */
class StateFlowWrapper<T>(initializer: () -> T) {

    /**
     * 创建一个 StateFlowDelegate 实例
     *
     * Delegate
     */
    private val delegate = stateFlowDelegate(initializer)

    /**
     * 使用 delegate 作为 value 的委托
     *
     * Value
     */
    var value by delegate

    /**
     * 获取 delegate 的 flow
     *
     * Flow
     */
    val flow = delegate.asFlow()

    /**
     * 获取 delegate 的 stateFlow
     *
     * State flow
     */
    val stateFlow = delegate.stateFlow

}

/**
 * StateFlowWrapperDelegate 类，包含了一个 StateFlowWrapper 实例
 */
class StateFlowWrapperDelegate<T>(initializer: () -> T) {

    /**
     * 创建一个 StateFlowWrapper 实例
     *
     * State flow wrapper
     */
    private val stateFlowWrapper = StateFlowWrapper(initializer)

    /**
     * 重载 getValue 方法，返回 stateFlowWrapper
     *
     * @param thisRef Any?
     * @param property KProperty<*>
     * @return StateFlowWrapper<T>
     */
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): StateFlowWrapper<T> {
        return stateFlowWrapper
    }
}