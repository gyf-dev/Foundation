@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import com.gyf.foundation.ext.markdown.markdown
import com.gyf.foundation.ext.markdown.setMarkdown
import com.gyf.foundation.helper.FlowTextHelper


/**
 * @Author  Ifan.Ge
 * @Date    2024/8/15 19:20
 */
@SuppressLint("AppCompatCustomView")
class TypewriterFadeTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FeatherEffectTextView(context, attrs, defStyleAttr) {

    private val helper = FlowTextHelper()

    var onEndListener: (() -> Unit)? = null

    var maskEnd: Boolean
        get() = helper.maskEnd
        set(value) {
            helper.maskEnd = value
        }

    var newText: CharSequence?
        get() = helper.text
        set(text) {
            helper.new()
            isFeatherEffectEnabled = true
            setText("")
            send(text)
        }

    var appendText: CharSequence?
        get() = helper.text
        set(value) {
            send(value)
        }

    init {
        helper
            .attach(this)
            .bind(
                onTextListener = {
                    setMarkdown(helper.text, false)
                },
                onEndListener = {
                    markdown = helper.text
                    isFeatherEffectEnabled = false
                    onEndListener?.invoke()
                })
    }

    fun start() {
        helper.start()
    }

    fun stop() {
        helper.stop()
    }

    fun send(text: CharSequence?) {
        helper.send(text)
    }
}
