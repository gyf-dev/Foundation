@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.blur

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Build
import android.util.LruCache
import android.view.SurfaceView
import android.view.View
import android.view.ViewTreeObserver
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import com.gyf.foundation.cacheview.ext.isNightActive
import com.gyf.foundation.cacheview.ext.isOrientationPortrait
import com.gyf.foundation.ext.capture.drawToBitmap
import com.gyf.foundation.ext.log.ITag

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/29 13:29
 */
class Blur(private val context: Context, var radius: Float) : ITag {

    private var behindBitmap: Bitmap? = null

    private val cacheSize = (Runtime.getRuntime().maxMemory() / 1024 / 4).toInt()

    val dayNightString get() = if (context.isNightActive) "night" else "day"

    val orientationString get() = if (context.isOrientationPortrait) "portrait" else "landscape"

    var isPreBlurLowerSEnabled: Boolean = true

    var isPreBlurEnabled: Boolean = false

    private val bitmapCache: LruCache<String, Bitmap> =
        object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String, bitmap: Bitmap): Int {
                return bitmap.byteCount / 1024
            }
        }

    fun behind(@DrawableRes resId: Int, key: String = "$resId $dayNightString $orientationString") {
        val drawable = AppCompatResources.getDrawable(context, resId)
            ?: throw IllegalArgumentException("resId not found")
        behindBitmap = bitmapCache.getOrPut(key) {
            if (canPreBlurEnabled()) {
                BlurHelper.blurBitmap(context, drawable.toBitmap(), radius)
            } else {
                drawable.toBitmap()
            }
        }
    }

    fun behind(bitmap: Bitmap, key: String = "") {
        if (behindBitmap == bitmap) {
            return
        }
        behindBitmap = bitmapCache.getOrPut(key) {
            if (canPreBlurEnabled()) {
                BlurHelper.blurBitmap(context, bitmap, radius)
            } else {
                bitmap
            }
        }
    }

    fun behind(view: View, key: String = "", after: () -> Unit = {}) {
        if (!view.isLaidOut) {
            view.viewTreeObserver.addOnGlobalLayoutListener(object :
                ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    behindInternal(view, key, after)
                    view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            })
        } else {
            behindInternal(view, key, after)
        }
    }

    private fun behindInternal(view: View, key: String = "", after: () -> Unit = {}) {
        behindBitmap = bitmapCache.getOrPut(key) {
            if (canPreBlurEnabled()) {
                BlurHelper.blurBitmap(context, view.drawToBitmap(), radius)
            } else {
                view.drawToBitmap()
            }
        }
        after()
    }

    fun behind(surfaceView: SurfaceView, after: () -> Unit = {}) {
        surfaceView.drawToBitmap { bitmap ->
            bitmap?.also {
                behindBitmap = if (canPreBlurEnabled()) {
                    BlurHelper.blurBitmap(context, it, radius)
                } else {
                    it
                }
                after()
            }
        }
    }

    fun drawBlur(view: View, c: Canvas) = drawBlur(view, c, getBlurRect(view))

    fun drawBlur(view: View, c: Canvas, dx: Int, dy: Int) =
        drawBlur(view, c, getBlurRect(view, dx, dy))

    fun drawBlur(view: View, c: Canvas, rect: Rect) =
        drawBlur(view, c, rect.left, rect.top, rect.right, rect.bottom)

    fun drawBlur(
        view: View,
        c: Canvas,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ) {
        behindBitmap?.also {
            val croppedBitmap = getCroppedBitmap(view, it) ?: return
            if (canPreBlurEnabled()) {
                c.drawBitmap(croppedBitmap, left.toFloat(), top.toFloat(), null)
            } else {
                c.drawBlur(
                    context,
                    croppedBitmap,
                    radius,
                    left, top, right, bottom
                )
            }
        }
    }

    fun getBlurRect(view: View, dx: Int = 0, dy: Int = 0): Rect {
        val visibleRect = Rect()
        view.getGlobalVisibleRect(visibleRect)
        val invisibleWidth = view.width - visibleRect.width()
        val invisibleHeight = view.height - visibleRect.height()

        val x = view.left + dx
        val left = if (invisibleWidth > 0 && x < 0) {
            x + invisibleWidth
        } else {
            x
        }
        val y = view.top + dy
        val top = if (invisibleHeight > 0 && y < 0) {
            y + invisibleHeight
        } else {
            y
        }
        val right = view.right + dx
        val bottom = view.bottom + dy
        return Rect(left, top, right, bottom)
    }

    private fun canPreBlurEnabled() =
        isPreBlurLowerSEnabled && Build.VERSION.SDK_INT < Build.VERSION_CODES.S || isPreBlurEnabled

    private fun getCroppedBitmap(view: View, bitmap: Bitmap): Bitmap? {

        // 获取 view 在屏幕上的可见区域
        val rect = Rect()
        view.getGlobalVisibleRect(rect)
        val visibleWidth = rect.width()
        val visibleHeight = rect.height()

        // 计算裁剪的起始点和宽高
        val itemCoordinates = IntArray(2)
        view.getLocationOnScreen(itemCoordinates)
        val x = itemCoordinates[0].coerceAtLeast(0)
        val y = itemCoordinates[1].coerceAtLeast(0)
        val width = visibleWidth.coerceAtMost(bitmap.width - x)
        val height = visibleHeight.coerceAtMost(bitmap.height - y)

        // 如果裁剪范围无效，返回 null
        if (width <= 0 || height <= 0) {
            return null
        }
        return Bitmap.createBitmap(bitmap, x, y, width, height)
    }

    private fun LruCache<String, Bitmap>.getOrPut(key: String, block: () -> Bitmap) =
        get(key) ?: block().also {
            if (key.isNotBlank()) {
                put(key, it)
            }
        }
}