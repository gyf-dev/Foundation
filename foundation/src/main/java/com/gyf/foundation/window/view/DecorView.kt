/*
 * Copyright @ 2021 - 2022 Human Horizons (Shanghai) Cloud Computing Technology Co., Ltd.
 * All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are NOT permitted except as agreed by
 * Human Horizons (Shanghai) Cloud Computing Technology Co., Ltd.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.gyf.foundation.window.view

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.FrameLayout
import com.gyf.foundation.window.callback.WindowCallback

class DecorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var windowCallback: WindowCallback? = null

    fun setWindowCallback(windowCallback: WindowCallback?) {
        this.windowCallback = windowCallback
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return windowCallback?.dispatchTouchEvent(ev) ?: super.dispatchTouchEvent(ev)
    }

    fun superDispatchTouchEvent(event: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(event)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        return windowCallback?.dispatchKeyEvent(event) ?: super.dispatchKeyEvent(event)
    }

    fun superDispatchKeyEvent(event: KeyEvent?): Boolean {
        return super.dispatchKeyEvent(event)
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        windowCallback?.onWindowFocusChanged(hasWindowFocus)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        windowCallback?.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        windowCallback?.onDetachedFromWindow()
    }
}
