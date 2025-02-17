@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.blur

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gyf.foundation.R

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/29 16:55
 */
class BlurRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RecyclerView(context, attrs) {

    var radius = 25f
        set(value) {
            if (field == value) return
            field = value
            blur.radius = value
            invalidate()
        }

    val blur = Blur(context, radius)

    private var canBlur: (ViewHolder) -> Boolean = { true }

    init {
        attrs.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.BlurRecyclerView)
            radius =
                typedArray.getDimension(R.styleable.BlurRecyclerView_blur_radius, 25f)
            typedArray.recycle()
        }
    }

    fun canBlur(block: (ViewHolder) -> Boolean) = apply {
        canBlur = block
    }

    override fun drawChild(canvas: Canvas, child: View, drawingTime: Long): Boolean {
        val viewHolder =
            getChildViewHolder(child) ?: return super.drawChild(canvas, child, drawingTime)
        val can = canBlur(viewHolder)
        if (can) {
            blur.drawBlur(child, canvas)
        }
        return super.drawChild(canvas, child, drawingTime)
    }
}