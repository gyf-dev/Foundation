package com.gyf.foundation.ext.capture

import android.graphics.Bitmap
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.PixelCopy
import android.view.SurfaceView
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

fun SurfaceView.drawToBitmap(callback: (Bitmap?) -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        // 检查 SurfaceView 是否有效
        if (holder.surface == null || !holder.surface.isValid) {
            callback(null)
            return
        }
        // 创建与 SurfaceView 大小相同的 Bitmap
        if (width <= 0 || height <= 0) {
            callback(null)
            return
        }
        val bitmap =
            Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        // 使用 PixelCopy 捕获 SurfaceView 的内容
        PixelCopy.request(this, bitmap, { result ->
            if (result == PixelCopy.SUCCESS) {
                // 捕获成功，返回 Bitmap
                callback(bitmap)
            } else {
                // 捕获失败，返回 null
                callback(null)
            }
        }, Handler(Looper.getMainLooper()))
    }
}

suspend fun SurfaceView.drawToBitmap(): Bitmap? {
    return suspendCancellableCoroutine { continuation ->
        drawToBitmap { bitmap ->
            continuation.resume(bitmap)
        }
    }
}