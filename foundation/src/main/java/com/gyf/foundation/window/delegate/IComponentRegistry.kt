package com.gyf.foundation.window.delegate

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import com.gyf.foundation.window.intent.WindowIntent

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/26 19:29
 */
interface IComponentRegistry {
    fun create(context: Context, savedInstanceState: Bundle?) {}
    fun start(context: Context) {}
    fun resume(context: Context) {}
    fun pause(context: Context) {}
    fun stop(context: Context) {}
    fun destroy(context: Context) {}
    fun newIntent(context: Context, intent: WindowIntent) {}
    fun configurationChanged(context: Context, newConfig: Configuration) {}
    fun trimMemory(context: Context, level: Int) {}
    fun saveInstanceState(context: Context, outState: Bundle) {}
}