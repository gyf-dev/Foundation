@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.view

import android.content.Context
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Shader
import android.util.AttributeSet
import android.util.SparseIntArray
import android.view.View
import android.widget.FrameLayout
import com.gyf.foundation.R
import com.gyf.foundation.ext.dp.dp
import com.gyf.foundation.ext.resources.colorRes
import com.gyf.foundation.ext.typedarray.applyAttrChanged
import com.gyf.foundation.ext.typedarray.getOr
import com.gyf.foundation.ext.typedarray.getResourceIdS

/**
 * @Author Ifan.Ge
 * @Date 2024/8/14 9:36
 */
class EdgeTransparentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
    }
    var edgeStartColor: Int = 0xFF15202E.toInt()
        set(value) {
            if (field == value) return
            field = value
            initShader()
            invalidate()
        }
    var edgeEndColor: Int = 0x0015202E
        set(value) {
            if (field == value) return
            field = value
            initShader()
            invalidate()
        }

    var maskPosition = Mask.NONE.value
        set(value) {
            if (field == value) return
            field = value
            invalidate()
        }

    var maskSize = 100.dp.toFloat()
        set(value) {
            if (field == value) return
            field = value
            initShader()
            invalidate()
        }

    private val gradientPosition = floatArrayOf(0f, 1f)

    private val isNoneMask: Boolean
        get() = maskPosition and Mask.NONE.value != 0
    private val isAllMask: Boolean
        get() = maskPosition and Mask.ALL.value != 0
    private val isTopMask: Boolean
        get() = maskPosition and Mask.TOP.value != 0 || isAllMask
    private val isBottomMask: Boolean
        get() = maskPosition and Mask.BOTTOM.value != 0 || isAllMask
    private val isRightMask: Boolean
        get() = maskPosition and Mask.RIGHT.value != 0 || isAllMask
    private val isLeftMask: Boolean
        get() = maskPosition and Mask.LEFT.value != 0 || isAllMask
    private var resourceIdS: SparseIntArray

    init {
        init(context, attrs)
        resourceIdS = context.getResourceIdS(R.styleable.EdgeTransparentView, attrs)
    }

    //初始化属性和变量
    private fun init(context: Context, attrs: AttributeSet?) {
        attrs.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.EdgeTransparentView)
            maskPosition =
                typedArray.getInt(
                    R.styleable.EdgeTransparentView_edge_maskPosition,
                    Mask.NONE.value
                )
            maskSize =
                typedArray.getDimension(
                    R.styleable.EdgeTransparentView_edge_maskSize,
                    100.dp.toFloat()
                )
            edgeStartColor =
                typedArray.getColor(
                    R.styleable.EdgeTransparentView_edge_edgeStartColor,
                    edgeStartColor
                )
            edgeEndColor =
                typedArray.getColor(R.styleable.EdgeTransparentView_edge_edgeEndColor, edgeEndColor)
            typedArray.recycle()
        }
        initShader()
    }

    //尺寸改变时候回调
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        initShader()
    }

    private fun initShader() {
        paint.setShader(
            LinearGradient(
                0f,
                0f,
                0f,
                maskSize,
                intArrayOf(edgeStartColor, edgeEndColor),
                gradientPosition,
                Shader.TileMode.CLAMP
            )
        )
    }

    //绘制childview
    override fun drawChild(canvas: Canvas, child: View, drawingTime: Long): Boolean {
        val layerSave =
            canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        val drawChild = super.drawChild(canvas, child, drawingTime)

        if (isNoneMask) {
            canvas.restoreToCount(layerSave)
            return drawChild
        }

        if (isTopMask) {
            canvas.drawRect(0f, 0f, width.toFloat(), maskSize, paint)
        }

        if (isBottomMask) {
            val save = canvas.save()
            canvas.rotate(180f, (width / 2).toFloat(), (height / 2).toFloat())
            canvas.drawRect(0f, 0f, width.toFloat(), maskSize, paint)
            canvas.restoreToCount(save)
        }

        val offset = (height - width) / 2

        if (isRightMask) {
            val saveCount = canvas.save()
            canvas.rotate(90f, (width / 2).toFloat(), (height / 2).toFloat())
            canvas.translate(0f, offset.toFloat())
            canvas.drawRect(
                (0 - offset).toFloat(),
                0f,
                (width + offset).toFloat(),
                maskSize,
                paint
            )
            canvas.restoreToCount(saveCount)
        }
        if (isLeftMask) {
            val saveCount = canvas.save()
            canvas.rotate(270f, (width / 2).toFloat(), (height / 2).toFloat())
            canvas.translate(0f, offset.toFloat())
            canvas.drawRect(
                (0 - offset).toFloat(),
                0f,
                (width + offset).toFloat(),
                maskSize,
                paint
            )
            canvas.restoreToCount(saveCount)
        }
        canvas.restoreToCount(layerSave)
        return drawChild
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        applyAttrChanged(resourceIdS)
        resourceIdS.getOr(R.attr.edge_edgeStartColor) {
            edgeStartColor = it.colorRes
        }
        resourceIdS.getOr(R.attr.edge_edgeEndColor) {
            edgeEndColor = it.colorRes
        }
    }

    enum class Mask(val value: Int) {
        NONE(0x01),
        TOP(0x01 shl 1),
        BOTTOM(0x01 shl 2),
        LEFT(0x01 shl 3),
        RIGHT(0x01 shl 4),
        ALL(0x01 shl 5)
    }
}
