/*
 *
 *  * Copyright @ 2021 - 2022 Human Horizons (Shanghai) Cloud Computing Technology Co., Ltd.
 *  * All Rights Reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are NOT permitted except as agreed by
 *  * Human Horizons (Shanghai) Cloud Computing Technology Co., Ltd.
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */
@file:Suppress("UNCHECKED_CAST")

package com.gyf.foundation.window.ext

import android.content.Context
import com.gyf.foundation.ext.coroutine.ICoroutine
import com.gyf.foundation.ext.coroutine.mainScope
import com.gyf.foundation.window.Window
import com.gyf.foundation.window.intent.WindowIntent
import com.gyf.foundation.window.stack.WindowRecord
import kotlinx.coroutines.launch

/**
 * @author: Ifan Ge
 * @date: 2022-10-12  16:01
 * @Version: design3.0
 */
object WindowStarter : ICoroutine {

    private val WINDOW_RECORD_MAP = HashMap<String, WindowRecord>()

    private val windowRecordGlobal: WindowRecord = WindowRecord()

    @JvmStatic
    fun <T : Window> startWindow(context: Context, intent: WindowIntent) {
        mainScope.launch {
            startWindowInternal<T>(context, intent)
        }
    }

    @JvmStatic
    fun <T : Window> startWindowGet(context: Context, intent: WindowIntent): T {
        return startWindowInternal(context, intent)
    }

    private fun <T : Window> startWindowInternal(context: Context, intent: WindowIntent): T {
        val clazz = intent.clazz
        val mode = intent.mode
        val t: T?
        if (mode == WindowIntent.SINGLE_TOP) {
            val isHead = windowRecordGlobal.isHead(clazz)
            if (isHead) {
                t = windowRecordGlobal.head as T?
                t?.onNewIntent(intent)
            } else {
                t = newWindow(context, intent, windowRecordGlobal)
            }
        } else if (mode == WindowIntent.SINGLE_TASK) {
            val isHead = windowRecordGlobal.isHead(clazz)
            if (isHead) {
                t = windowRecordGlobal.head as T?
                t?.onNewIntent(intent)
            } else {
                val hasClass = windowRecordGlobal.containClass(clazz)
                if (hasClass) {
                    t = windowRecordGlobal.pop(clazz) as T?
                    t?.onNewIntent(intent)
                } else {
                    t = newWindow(context, intent, windowRecordGlobal)
                }
            }
        } else if (mode == WindowIntent.SINGLE_INSTANCE) {
            var windowRecord = WINDOW_RECORD_MAP[clazz]
            if (windowRecord == null) {
                windowRecord = WindowRecord()
                t = newWindow(context, intent, windowRecord)
                if (t != null) {
                    WINDOW_RECORD_MAP[clazz] = windowRecord
                }
            } else {
                t = windowRecord.head as T?
                t?.onNewIntent(intent)
            }
        } else if (mode == WindowIntent.NO_STACK) {
            t = newWindow(context, intent, null)
        } else {
            t = newWindow(context, intent, windowRecordGlobal)
        }
        if (t == null) {
            throw RuntimeException("Failed to instantiate " + intent.clazz)
        }
        return t
    }

    private fun <T : Window> newWindow(
        context: Context,
        intent: WindowIntent,
        windowRecord: WindowRecord?
    ): T? {
        try {
            val clazz = intent.clazz
            val aClass = Class.forName(clazz) as Class<T>
            val t = aClass.getDeclaredConstructor().newInstance() as Window
            t.attachBaseContext(context)
            t.intent = intent
            if (intent.show) {
                t.show()
            }
            windowRecord?.addAndHide(t)
            return t as T
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            return null
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
            return null
        } catch (e: InstantiationException) {
            e.printStackTrace()
            return null
        }
    }

    @JvmStatic
    fun remove(window: Window) {
        val intent = window.intent
        if (intent.mode == WindowIntent.SINGLE_INSTANCE) {
            WINDOW_RECORD_MAP.remove(window.javaClass.name)
        } else {
            windowRecordGlobal.remove(window)
            if (intent.mNeedShowPrevWindow) {
                val head: Window? = windowRecordGlobal.head?.value
                head?.show()
            }
        }
    }
}

@JvmOverloads
inline fun <reified T : Window> Context.startWindow(noinline windowIntentBlock: (WindowIntent.() -> Unit)? = null) =
    WindowStarter.startWindow<T>(this, WindowIntent(T::class.java).also {
        windowIntentBlock?.invoke(it)
    })

@JvmOverloads
inline fun <reified T : Window> Context.startWindowGet(noinline windowIntentBlock: (WindowIntent.() -> Unit)? = null): T =
    WindowStarter.startWindowGet(this, WindowIntent(T::class.java).also {
        windowIntentBlock?.invoke(it)
    })