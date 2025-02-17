package com.gyf.foundation.lifecycle

import androidx.lifecycle.Lifecycle
import java.util.concurrent.atomic.AtomicReference

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/17 14:15
 */
class SafeLifecycleEvent {

    private val _event: AtomicReference<Lifecycle.Event> = AtomicReference(Lifecycle.Event.ON_STOP)

    var value: Lifecycle.Event
        get() = _event.get()
        set(value) = _event.set(value)
}