@file:OptIn(ExperimentalCoroutinesApi::class)
@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.helper

import android.view.View
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope

/**
 * @Author  Ifan.Ge
 * @Date    2024/9/12 14:32
 */
class FlowTextHelper : ChannelHelper<CharSequence>(MainScope()) {

    private var needStart = false
    private val listener = object : View.OnAttachStateChangeListener {

        override fun onViewAttachedToWindow(v: View) {
            if (needStart) {
                start("attach")
            }
        }

        override fun onViewDetachedFromWindow(v: View) {
            if (isRunning.get()) {
                stop("detach")
                needStart = true
            }
        }
    }
    private var isAttached = false
    val text = StringBuilder()

    init {
        onNew = { text.clear() }
        onCollect = { text.append(it) }
    }

    fun attach(view: View) = apply {
        if (isAttached) {
            return this
        }
        isAttached = true
        view.addOnAttachStateChangeListener(listener)
    }

    fun detach(view: View) = apply {
        if (!isAttached) {
            return this
        }
        isAttached = false
        view.removeOnAttachStateChangeListener(listener)
    }
}