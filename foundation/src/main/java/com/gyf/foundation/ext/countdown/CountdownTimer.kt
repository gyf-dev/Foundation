package com.gyf.foundation.ext.countdown

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.gyf.foundation.ext.coroutine.coroutineScope
import com.gyf.foundation.lifecycle.SimpleLifecycle
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong

/**
 * @Author  Ifan.Ge
 * @Date    2024/5/11 19:00
 */
class CountdownTimer(
    private val initialTime: Long,
    private val onTick: ((Long) -> Unit)? = null,
    private val onCancel: (() -> Unit)? = null,
    private val onFinish: () -> Unit
) : SimpleLifecycle() {


    /**
     * Job
     */
    private var job: Job? = null

    /**
     * Remaining time
     */
    @Volatile
    private var remainingTime = AtomicLong(initialTime)

    init {
        create()
    }

    override fun create(vararg inParams: Any) {
        if (initialTime <= 0) {
            throw IllegalArgumentException("The countdown time must be greater than 0")
        }
        "reset time".log
        remainingTime.set(initialTime)
    }

    override fun start(vararg inParams: Any) {
        when (eventValue) {
            Lifecycle.Event.ON_PAUSE -> {
                "It is paused, please do not start it again or call resume".log
                return
            }

            Lifecycle.Event.ON_START -> {
                "It is started, please do not start it again.".log
                return
            }

            Lifecycle.Event.ON_STOP -> {
                event.value = Lifecycle.Event.ON_START
                job = timing()
            }

            else -> {}
        }
    }

    /**
     * Timing
     */
    private fun timing() = coroutineScope.launch {
        while (remainingTime.get() >= 0 && event.value != Lifecycle.Event.ON_STOP) {
            if (event.value == Lifecycle.Event.ON_START) {
                if (remainingTime.get() == initialTime) {
                    "start".log
                }
                delay(INTERVAL)
                val decrementAndGet = remainingTime.addAndGet(-INTERVAL)
                val tick = decrementAndGet + INTERVAL
                onTick?.invoke(tick)
            }
        }
        if (remainingTime.get() <= 0) {
            "countdown onFinish remainingTime:$remainingTime".log
            event.value = Lifecycle.Event.ON_STOP
            onFinish()
        }
    }

    override fun resume(vararg inParams: Any) {
        when (eventValue) {
            Lifecycle.Event.ON_STOP -> {
                "Already stopped, no need to resume".log
            }

            Lifecycle.Event.ON_START -> {
                "Already started, no need to resume".log
            }

            Lifecycle.Event.ON_PAUSE -> {
                event.value = Lifecycle.Event.ON_START
                "The countdown is resumed $event".log
            }

            else -> {}
        }
    }

    override fun pause(vararg inParams: Any) {
        when (eventValue) {
            Lifecycle.Event.ON_STOP -> {
                "Already stopped, no need to pause".log
            }

            Lifecycle.Event.ON_PAUSE -> {
                "Already paused, no need to pause".log
            }

            Lifecycle.Event.ON_START -> {
                event.value = Lifecycle.Event.ON_PAUSE
                "The countdown is paused".log
            }

            else -> {}
        }
    }

    override fun stop(vararg inParams: Any) {
        when (eventValue) {
            Lifecycle.Event.ON_STOP -> {
                "Already stopped, no need to stop".log
                create()
            }

            else -> {
                var needCancel: Boolean? = null
                if (inParams.isNotEmpty() && inParams[0] is Boolean) {
                    needCancel = inParams[0] as Boolean
                }
                coroutineScope.launch {
                    event.value = Lifecycle.Event.ON_STOP
                    job?.cancel()
                    job = null
                    if (needCancel == true) {
                        "countdown onCancel".log
                        onCancel?.invoke()
                    }
                    "The countdown has stopped".log
                    create()
                }
            }
        }
    }

    override fun destroy(vararg inParams: Any) {
        stop()
    }

    override fun reset(vararg inParams: Any) {
        create()
        when (eventValue) {
            Lifecycle.Event.ON_STOP -> start()
            Lifecycle.Event.ON_PAUSE -> resume()
            Lifecycle.Event.ON_START -> {}
            else -> {}
        }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                destroy()
            }

            else -> {

            }
        }
        super.onStateChanged(source, event)
    }

    companion object {
        private const val INTERVAL = 1000L
    }
}
