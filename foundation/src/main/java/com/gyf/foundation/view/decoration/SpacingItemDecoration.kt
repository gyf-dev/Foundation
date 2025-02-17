package com.gyf.foundation.view.decoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView

/**
 * 自定义RecyclerView的Item装饰类，用于添加间距和绘制分割线。
 * Custom RecyclerView ItemDecoration class for adding spacing and drawing dividers.
 *
 * @Author Ifan.Ge
 * @Date 2024/7/9 10:47
 */
class SpacingItemDecoration(
    /**
     * 左侧间距大小，以像素为单位。
     * Left spacing size in pixels.
     */
    private val leftSpacing: Int = 0,
    /**
     * 顶部间距大小，以像素为单位。
     * Top spacing size in pixels.
     */
    private val topSpacing: Int = 0,
    /**
     * 右侧间距大小，以像素为单位。
     * Right spacing size in pixels.
     */
    private val rightSpacing: Int = 0,
    /**
     * 底部间距大小，以像素为单位。
     * Bottom spacing size in pixels.
     */
    private val bottomSpacing: Int = 0,
    /**
     * 是否为第一个Item添加偏移。
     * Whether to offset the first item.
     */
    private val offsetFirstItem: Boolean = true,
    /**
     * 是否为最后一个Item添加偏移。
     * Whether to offset the last item.
     */
    private val offsetLastItem: Boolean = true,
    /**
     * 分割线颜色。
     * Divider color.
     * @param color Int 分割线的颜色
     */
    @ColorInt color: Int = Color.TRANSPARENT
) : RecyclerView.ItemDecoration() {

    init {
        require(leftSpacing >= 0) { "Left spacing must be non-negative" }
        require(topSpacing >= 0) { "Top spacing must be non-negative" }
        require(rightSpacing >= 0) { "Right spacing must be non-negative" }
        require(bottomSpacing >= 0) { "Bottom spacing must be non-negative" }
    }

    /**
     * 用于绘制分割线的画笔。
     * Paint for drawing dividers.
     */
    private val paint = Paint().apply { this.color = color }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) return

        outRect.set(leftSpacing, topSpacing, rightSpacing, bottomSpacing)

        if (!offsetFirstItem && position == 0) {
            outRect.top = 0
        }

        if (!offsetLastItem && position == state.itemCount - 1) {
            outRect.bottom = 0
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams

            // Draw left spacing
            if (leftSpacing > 0) {
                val left = child.left - params.leftMargin - leftSpacing
                val right = child.left - params.leftMargin
                val top = child.top - params.topMargin
                val bottom = child.bottom + params.bottomMargin
                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
            }

            // Draw top spacing
            if (topSpacing > 0) {
                val left = child.left - params.leftMargin
                val right = child.right + params.rightMargin
                val top = child.top - params.topMargin - topSpacing
                val bottom = child.top - params.topMargin
                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
            }

            // Draw right spacing
            if (rightSpacing > 0) {
                val left = child.right + params.rightMargin
                val right = child.right + params.rightMargin + rightSpacing
                val top = child.top - params.topMargin
                val bottom = child.bottom + params.bottomMargin
                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
            }

            // Draw bottom spacing
            if (bottomSpacing > 0) {
                val left = child.left - params.leftMargin
                val right = child.right + params.rightMargin
                val top = child.bottom + params.bottomMargin
                val bottom = child.bottom + params.bottomMargin + bottomSpacing
                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
            }
        }
    }
}