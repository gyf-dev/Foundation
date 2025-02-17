@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.blur

import android.content.Context
import android.graphics.Canvas
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gyf.foundation.ext.log.ITag

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/29 11:00
 */
class BlurItemDecoration(
    private val context: Context,
    private val radius: Float
) : RecyclerView.ItemDecoration(), ITag {

    val blur by lazy { Blur(context, radius) }

    private var canBlur: (ViewHolder) -> Boolean = { true }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        drawItemBlur(c, parent)
    }

    fun canBlur(block: (ViewHolder) -> Boolean) = apply {
        canBlur = block
    }

    private fun drawItemBlur(c: Canvas, parent: RecyclerView) {
        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            val viewHolder = parent.getChildViewHolder(view) ?: continue
            val can = canBlur(viewHolder)
            if (can) {
                blur.drawBlur(view, c)
            }
        }
    }
}