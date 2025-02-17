package com.gyf.foundation.window.callback

import androidx.core.util.Consumer
import com.gyf.foundation.window.Window
import com.gyf.foundation.window.intent.WindowIntent

/**
 * OnNewWindowIntentProvider接口，用于提供新窗口意图
 * The OnNewWindowIntentProvider interface, used for providing new window intents
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/26 19:48
 */
interface OnNewWindowIntentProvider {
    /**
     * 添加一个新的监听器，当[Window.onNewIntent]与新的[WindowIntent]关联时，会回调该监听器
     * Add a new listener that will get a callback associated with [Window.onNewIntent] with the new [WindowIntent].
     *
     * @param listener Consumer<WindowIntent> 监听器，当[Window.onNewIntent]被调用时，应该调用该监听器
     *                 The listener that should be called whenever [Window.onNewIntent] was called.
     */
    fun addOnNewWindowIntentListener(listener: Consumer<WindowIntent>)

    /**
     * 移除之前添加的监听器，它将不会接收到任何未来的回调
     * Remove a previously added listener. It will not receive any future callbacks.
     *
     * @param listener Consumer<WindowIntent> 之前通过[addOnNewWindowIntentListener]添加的监听器，应该被移除
     *                 The listener previously added with [addOnNewWindowIntentListener] that should be removed.
     */
    fun removeOnNewWindowIntentListener(listener: Consumer<WindowIntent>)
}