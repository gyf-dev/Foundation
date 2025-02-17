@file:OptIn(ExperimentalCoroutinesApi::class)
@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.helper

import com.gyf.foundation.ext.log.ITag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @Author  Ifan.Ge
 * @Date    2024/9/12 14:32
 */
open class ChannelHelper<T>(val scope: CoroutineScope) : ITag {

    private var channel = Channel<T>(Channel.UNLIMITED)
    private var job: Job? = null
    private val onTextListeners = mutableSetOf<(T) -> Unit>()
    private val onEndListeners = mutableSetOf<() -> Unit>()
    private var onTextListener: ((T) -> Unit)? = null
    private var onEndListener: (() -> Unit)? = null
    val isRunning = AtomicBoolean(false)
    var interval = 16L
        set(value) {
            field = if (value < 0) {
                0
            } else {
                value
            }
        }
    var maskEnd = false
    val isEnd get() = channel.isEmpty && maskEnd || !isRunning.get()
    var onBinding: (() -> Unit) = {}
    var onUnbinding: (() -> Unit) = {}
    var onNew: (() -> Unit) = {}
    var onStart: (() -> Unit) = {}
    var onStartJoin: (() -> Unit) = {}
    var onStop: (() -> Unit) = {}
    var onStopJoin: (() -> Unit) = {}
    var onEnd: (() -> Unit) = {}
    var onEndJoin: (() -> Unit) = {}
    var onCollect: (suspend (T) -> Unit) = {}


    fun bind(
        autoUnbind: Boolean = false,
        onTextListener: ((T) -> Unit) = {},
        onEndListener: (() -> Unit) = {}
    ) = apply {
        unbind()

        this.onTextListener = {
            onTextListener(it)
        }
        this.onEndListener = {
            onEndListener()
            if (autoUnbind) {
                unbind()
            }
        }
        this.onTextListener?.also { addOnTextListener(it) }
        this.onEndListener?.also { addOnEndListener(it) }
        onBinding()
    }

    fun unbind() = apply {
        onTextListener?.also { removeOnTextListener(it) }
        onEndListener?.also { removeOnEndListener(it) }
        onTextListener = null
        onEndListener = null
        onUnbinding()
    }

    fun new() = apply {
        stop("new")
        newChannel()
        maskEnd = false
        onNew()
    }

    fun start(from: String = "start") = apply {
        if (!isRunning.get()) {
            isRunning.set(true)
            scope.launch {
                startJob(from)
                onStart()
            }
        }
    }

    suspend fun startJoin(from: String = "startJoin") = apply {
        if (!isRunning.get()) {
            isRunning.set(true)
            startJob(from)
            onStartJoin()
        }
    }

    fun stop(from: String = "stop") = apply {
        if (isRunning.get()) {
            isRunning.set(false)
            stopJob(from)
            onStop()
        }
    }

    suspend fun stopJoin(from: String = "stopJoin") = apply {
        if (isRunning.get()) {
            isRunning.set(false)
            stopJobJoin(from)
            onStopJoin()
        }
    }

    fun end() = apply {
        stop("end")
        newChannel()
        maskEnd = true
        onEnd()
    }

    suspend fun endJoin() = apply {
        stopJoin("endSuspend")
        newChannel()
        maskEnd = true
        onEndJoin()
    }

    fun send(element: T?) = apply {
        element ?: return this
        channel.trySend(element)
    }

    fun cancel() = apply {
        end()
        scope.cancel()
    }

    fun addOnTextListener(listener: (T) -> Unit) = apply {
        onTextListeners.add(listener)
    }

    fun removeOnTextListener(listener: (T) -> Unit) = apply {
        onTextListeners.remove(listener)
    }

    fun addOnEndListener(listener: () -> Unit) = apply {
        onEndListeners.add(listener)
    }

    fun removeOnEndListener(listener: () -> Unit) = apply {
        onEndListeners.remove(listener)
    }

    private fun newChannel() {
        channel.cancel()
        channel = Channel(Channel.UNLIMITED)
    }

    private suspend fun startJob(from: String) {
        "Start job from $from".log
        coroutineScope {
            job = launch {
                try {
                    channel.receiveAsFlow().collect { collect(it) }
                } finally {
                    "End job".log
                    newChannel()
                    maskEnd = true
                    onEndListeners.forEach { it() }
                }
            }
        }
    }

    private suspend fun collect(t: T) {
        if (!isRunning.get()) {
            return
        }
        onCollect(t)
        onTextListeners.forEach { it(t) }
        if (isEnd) {
            job?.cancelAndJoin()
        }
        if (interval > 0) {
            delay(interval)
        }
    }

    private fun stopJob(from: String) {
        job?.apply {
            cancel()
            "Stop job is cancelled from $from".log
        }
        job = null
    }

    private suspend fun stopJobJoin(from: String) {
        job?.apply {
            cancelAndJoin()
            "Stop job is cancelled from $from".log
        }
        job = null
    }
}