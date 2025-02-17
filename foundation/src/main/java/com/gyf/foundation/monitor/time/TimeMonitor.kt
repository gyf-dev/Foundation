package com.gyf.foundation.monitor.time

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.gyf.foundation.Foundation
import com.gyf.foundation.monitor.AbsMonitor

/**
 * @Author  Ifan.Ge
 * @Date    2024/9/10 15:12
 */
class TimeMonitor(private val context: Context) : AbsMonitor<Long>(System.currentTimeMillis()) {

    private val timeChangeReceiver = TimeChangeReceiver()

    override fun startInternal() {
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_TIME_CHANGED)
            addAction(Intent.ACTION_TIME_TICK)
            addAction(Intent.ACTION_TIMEZONE_CHANGED)
        }
        context.registerReceiver(timeChangeReceiver, filter)
    }

    override fun stopInternal() {
        context.unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                Intent.ACTION_TIME_CHANGED -> {
                    // 系统时间发生变化
                    value.value = System.currentTimeMillis()
                }

                Intent.ACTION_TIME_TICK -> {
                    // 每分钟触发一次
                    value.value = System.currentTimeMillis()
                }

                Intent.ACTION_TIMEZONE_CHANGED -> {
                    // 时区发生变化
                    value.value = System.currentTimeMillis()
                }
            }
        }
    }

    companion object {
        val instance by lazy { TimeMonitor(Foundation.context) }
    }
}
