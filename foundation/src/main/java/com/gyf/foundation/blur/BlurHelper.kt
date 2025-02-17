@file:Suppress("DEPRECATION")

package com.gyf.foundation.blur

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import android.graphics.RenderEffect
import android.graphics.RenderNode
import android.graphics.Shader
import android.os.Build
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import androidx.annotation.RequiresApi

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/29 10:32
 */
object BlurHelper {

    @RequiresApi(Build.VERSION_CODES.S)
    fun blurRenderNode(
        bitmap: Bitmap,
        radius: Float,
        rect: Rect
    ) = blurRenderNode(bitmap, radius, rect.left, rect.top, rect.right, rect.bottom)

    @RequiresApi(Build.VERSION_CODES.S)
    fun blurRenderNode(
        bitmap: Bitmap,
        radius: Float,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ): RenderNode {
        val renderNode = RenderNode("BlurredRenderNode")
        renderNode.setPosition(left, top, right, bottom)
        val blurEffect =
            RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP)
        renderNode.setRenderEffect(blurEffect)
        val recordingCanvas = renderNode.beginRecording(bitmap.width, bitmap.height)
        recordingCanvas.drawBitmap(bitmap, 0f, 0f, null)
        renderNode.endRecording()
        return renderNode
    }

    fun blurBitmap(context: Context, bitmap: Bitmap, radius: Float): Bitmap {
        val validRadius = radius.coerceIn(0f, 25f)
        val renderScript = RenderScript.create(context)
        val input = Allocation.createFromBitmap(renderScript, bitmap)
        val output = Allocation.createTyped(renderScript, input.type)
        val scriptIntrinsicBlur =
            ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))

        scriptIntrinsicBlur.setRadius(validRadius)
        scriptIntrinsicBlur.setInput(input)
        scriptIntrinsicBlur.forEach(output)
        output.copyTo(bitmap)

        renderScript.destroy()

        return bitmap
    }
}