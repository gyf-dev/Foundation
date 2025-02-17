package com.gyf.foundation.ext.countdown

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/2 19:28
 */
fun countdownTimer(
    initialTime: Long,
    start: Boolean = true,
    onTick: ((Long) -> Unit)? = null,
    onCancel: (() -> Unit)? = null,
    onFinish: () -> Unit
): CountdownTimer {
    val countdownTimer = CountdownTimer(initialTime, onTick, onCancel, onFinish)
    if (start) {
        countdownTimer.start()
    }
    return countdownTimer
}