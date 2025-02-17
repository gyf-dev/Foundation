package com.gyf.foundation.blur

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.os.Build

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/29 10:52
 */

fun Canvas.drawBlur(
    context: Context,
    bitmap: Bitmap,
    radius: Float,
    rect: Rect
) {
    drawBlur(context, bitmap, radius, rect.left, rect.top, rect.right, rect.bottom)
}

fun Canvas.drawBlur(
    context: Context,
    bitmap: Bitmap,
    radius: Float,
    left: Int,
    top: Int,
    right: Int,
    bottom: Int
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        try {
            drawHardBlur(bitmap, radius, left, top, right, bottom)
        } catch (e: Exception) {
            drawSoftBlur(context, bitmap, radius, left, top, right, bottom)
        }
    } else {
        drawSoftBlur(context, bitmap, radius, left, top, right, bottom)
    }
}

fun Canvas.drawHardBlur(
    bitmap: Bitmap,
    radius: Float,
    rect: Rect
) {
    drawHardBlur(bitmap, radius, rect.left, rect.top, rect.right, rect.bottom)
}

fun Canvas.drawHardBlur(
    bitmap: Bitmap,
    radius: Float,
    left: Int,
    top: Int,
    right: Int,
    bottom: Int
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val blurRenderNode = BlurHelper.blurRenderNode(bitmap, radius, left, top, right, bottom)
        drawRenderNode(blurRenderNode)
    }
}

fun Canvas.drawSoftBlur(
    context: Context,
    bitmap: Bitmap,
    radius: Float,
    rect: Rect
) {
    drawSoftBlur(context, bitmap, radius, rect.left, rect.top, rect.right, rect.bottom)
}

fun Canvas.drawSoftBlur(
    context: Context,
    bitmap: Bitmap,
    radius: Float,
    left: Int,
    top: Int,
    right: Int,
    bottom: Int
) {
    val blurBitmap = BlurHelper.blurBitmap(context, bitmap, radius)
    drawBitmap(blurBitmap, left.toFloat(), top.toFloat(), null)
    val drawable = BitmapDrawable(context.resources, blurBitmap)
    drawable.setBounds(left, top, right, bottom)
    drawable.draw(this)
}