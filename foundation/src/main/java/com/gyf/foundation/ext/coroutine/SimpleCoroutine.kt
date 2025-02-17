package com.gyf.foundation.ext.coroutine

import androidx.lifecycle.Lifecycle
import com.gyf.foundation.lifecycle.SafeLifecycleEvent

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/2 19:11
 */
open class SimpleCoroutine : ICoroutine {

    val event by lazy { SafeLifecycleEvent() }

    val eventValue: Lifecycle.Event
        get() = event.value
}