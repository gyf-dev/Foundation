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
package com.gyf.foundation.window.callback

import android.view.KeyEvent
import android.view.MotionEvent
import android.view.WindowManager

/**
 * WindowCallback接口，用于处理窗口的回调
 * The WindowCallback interface, used for handling window callbacks
 *
 * @author: Ifan Ge
 * @date: 2022 -10-14  14:28
 * @Version: design3.0
 */
interface WindowCallback {

    /**
     * 当窗口属性改变时的回调方法
     * Callback method when window attributes change
     *
     * @param params WindowManager.LayoutParams 窗口参数
     *               The window parameters
     */
    fun onWindowAttributesChanged(params: WindowManager.LayoutParams)

    /**
     * 分发触摸事件的方法
     * Method for dispatching touch events
     *
     * @param event MotionEvent 触摸事件
     *              The touch event
     * @return Boolean 返回是否消费了这个事件
     *                 Returns whether the event was consumed
     */
    fun dispatchTouchEvent(event: MotionEvent): Boolean

    /**
     * 分发键盘事件的方法
     * Method for dispatching keyboard events
     *
     * @param event KeyEvent 键盘事件
     *              The keyboard event
     * @return Boolean 返回是否消费了这个事件
     *                 Returns whether the event was consumed
     */
    fun dispatchKeyEvent(event: KeyEvent): Boolean

    /**
     * 当窗口焦点改变时的回调方法
     * Callback method when window focus changes
     *
     * @param hasWindowFocus Boolean 窗口是否有焦点
     *                       Whether the window has focus
     */
    fun onWindowFocusChanged(hasWindowFocus: Boolean)

    /**
     * 当窗口附加到窗口时的回调方法
     * Callback method when the window is attached to the window
     */
    fun onAttachedToWindow()

    /**
     * 当窗口从窗口分离时的回调方法
     * Callback method when the window is detached from the window
     */
    fun onDetachedFromWindow()
}