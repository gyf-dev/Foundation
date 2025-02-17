@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Shader
import android.util.AttributeSet
import android.util.SparseIntArray
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.graphics.toRectF
import com.gyf.foundation.R
import com.gyf.foundation.ext.log.ITag
import com.gyf.foundation.ext.resources.colorRes
import com.gyf.foundation.ext.typedarray.applyAttrChanged
import com.gyf.foundation.ext.typedarray.getOr
import com.gyf.foundation.ext.typedarray.getResourceIdS
import kotlin.math.abs


/**
 * @Author  Ifan.Ge
 * @Date    2024/8/15 19:20
 */
@SuppressLint("AppCompatCustomView")
open class FeatherEffectTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr), ITag {

    var isFeatherEffectEnabled = true
        set(value) {
            if (field == value) return
            field = value
            invalidate()
        }

    private var previousLineCount = 0 // 用于存储之前的行数
    private var onLineChangeListener: ((Int) -> Unit)? = null // 换行监听器（Lambda）

    // 羽化效果
    private var fadePaint: Paint = Paint()
    private var fadeShader: LinearGradient? = null
    private var resourceIdS: SparseIntArray

    @ColorInt
    var fadeStartColor: Int = 0x00FFFFFF
        set(value) {
            if (field == value) return
            field = value
            invalidate()
        }

    @ColorInt
    var fadeEndColor: Int = 0xFFFFFFFF.toInt()
        set(value) {
            if (field == value) return
            field = value
            invalidate()
        }

    init {
        isClickable = true
        init(context, attrs)
        resourceIdS = context.getResourceIdS(R.styleable.FeatherEffectTextView, attrs)
    }

    //初始化属性和变量
    private fun init(context: Context, attrs: AttributeSet?) {
        attrs.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.FeatherEffectTextView
            )
            isFeatherEffectEnabled =
                typedArray.getBoolean(R.styleable.FeatherEffectTextView_effect_Enabled, true)
            fadeStartColor =
                typedArray.getColor(
                    R.styleable.FeatherEffectTextView_effect_StartColor,
                    fadeStartColor
                )
            fadeEndColor =
                typedArray.getColor(
                    R.styleable.FeatherEffectTextView_effect_EndColor,
                    fadeEndColor
                )
            typedArray.recycle()
        }
    }

    // 换行监听器使用Lambda表达式
    fun setOnLineChangeListener(listener: (Int) -> Unit) {
        this.onLineChangeListener = listener
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (layout != null) {
            val currentLineCount = layout.lineCount

            // 如果行数发生变化，触发换行监听器
            if (currentLineCount != previousLineCount) {
                onLineChangeListener?.invoke(currentLineCount)
                previousLineCount = currentLineCount
            }

            if (isFeatherEffectEnabled) {

                val lastLine = layout.lineCount - 1 // 最后一行的行号

                val lineStart = layout.getLineStart(lastLine)
                val lineEnd = layout.getLineEnd(lastLine)
                if (abs(lineStart - lineEnd) <= 1) {
                    // 最后一行没有文字，跳过羽化效果
                    return
                }

                val rect = Rect()
                layout.getLineBounds(lastLine, rect)
                val rectF = rect.toRectF().apply {
                    top += paddingTop
                    bottom += paddingTop
                    left = layout.getLineLeft(lastLine) + paddingLeft
                    right = layout.getLineRight(lastLine) + paddingLeft
                }

                fadeShader = LinearGradient(
                    rectF.left, rectF.top, rectF.right, rectF.top,
                    fadeStartColor, fadeEndColor,
                    Shader.TileMode.CLAMP
                )

                fadePaint.shader = fadeShader

                canvas.save()
                canvas.clipRect(rectF)
                canvas.drawRect(rectF, fadePaint)
                canvas.restore()
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        applyAttrChanged(resourceIdS)
        resourceIdS.getOr(R.attr.effect_StartColor) {
            fadeStartColor = it.colorRes
        }
        resourceIdS.getOr(R.attr.effect_EndColor) {
            fadeEndColor = it.colorRes
        }
    }
}
