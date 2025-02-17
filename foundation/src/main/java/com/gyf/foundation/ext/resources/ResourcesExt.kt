package com.gyf.foundation.ext.resources

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.gyf.foundation.Foundation
import com.gyf.foundation.ext.configuration.currentLocale
import com.gyf.foundation.ext.configuration.currentNightMode
import com.gyf.foundation.ext.configuration.currentOrientation
import java.util.Locale

/**
 * 资源扩展类，提供了一系列的资源获取方法
 * Resource extension class, provides a series of resource acquisition methods
 *
 * @author  ifan.ge
 * @date  2024/06/28 11:18
 */

/**
 * 从资源中获取字符串
 * Get string from resources
 *
 * @param resId Int 资源ID
 *              Resource ID
 * @return String 返回的字符串
 *                The returned string
 */
fun Context.stringRes(@StringRes resId: Int) = this.getString(resId)

/**
 * 从资源中获取字符串
 * Get string from resources
 *
 * @receiver Int 资源ID
 *           Resource ID
 * @return String 返回的字符串
 *                The returned string
 */
val Int.stringRes get() = Foundation.context.stringRes(this)

/**
 * 从资源中获取Drawable
 * Get Drawable from resources
 *
 * @param resId Int 资源ID
 *              Resource ID
 * @return Drawable? 返回的Drawable
 *                   The returned Drawable
 */
fun Context.drawableRes(@DrawableRes resId: Int) = ContextCompat.getDrawable(this, resId)
    ?: throw Resources.NotFoundException("Drawable not found")

/**
 * 从资源中获取Drawable
 * Get Drawable from resources
 *
 * @receiver Int 资��ID
 *           Resource ID
 * @return Drawable? 返回的Drawable
 *                   The returned Drawable
 */
val Int.drawableRes get() = Foundation.context.drawableRes(this)

/**
 * 从资源中获取颜色
 * Get color from resources
 *
 * @param resId Int 资源ID
 *              Resource ID
 * @return Int 返回的颜色值
 *             The returned color value
 */
fun Context.colorRes(@ColorRes resId: Int) = ContextCompat.getColor(this, resId)

/**
 * 从资源中获取颜色
 * Get color from resources
 *
 * @receiver Int 资源ID
 *           Resource ID
 * @return Int 返回的颜色值
 *             The returned color value
 */
val Int.colorRes get() = Foundation.context.colorRes(this)

/**
 * 从资源中获取尺寸
 * Get dimension from resources
 *
 * @param resId Int 资源ID
 *              Resource ID
 * @return Int 返回的尺寸值
 *             The returned dimension value
 */
fun Context.dimenRes(@DimenRes resId: Int) = this.resources.getDimensionPixelSize(resId)

/**
 * 从资源中获取尺寸
 * Get dimension from resources
 *
 * @receiver Int 资源ID
 *           Resource ID
 * @return Int 返回的尺寸值
 *             The returned dimension value
 */
val Int.dimenRes get() = Foundation.context.dimenRes(this)

/**
 * 获取当前的Locale
 * Get the current Locale
 *
 * @receiver Resources
 * @return Locale 当前的Locale
 *                The current Locale
 */
val Resources.currentLocale: Locale
    get() = configuration.currentLocale

/**
 * 获取当前的夜间模式
 * Get the current night mode
 *
 * @receiver Resources
 * @return Boolean 当前的夜间模式
 *                 The current night mode
 */
val Resources.currentNightMode: Boolean
    get() = configuration.currentNightMode

/**
 * 获取当前的屏幕方向
 * Get the current screen orientation
 *
 * @receiver Resources
 * @return Int 当前的屏幕方向
 *            The current screen orientation
 */
val Resources.currentOrientation: Int
    get() = configuration.currentOrientation

/**
 * 屏幕方向是否为竖屏
 * Whether the screen orientation is portrait
 *
 * @receiver Resources
 * @return Boolean 是否为竖屏
 *                 Whether it is portrait
 */
val Resources.isOrientationPortrait: Boolean
    get() = currentOrientation == Configuration.ORIENTATION_PORTRAIT

/**
 * 屏幕方向是否为横屏
 * Whether the screen orientation is landscape
 *
 * @receiver Resources
 * @return Boolean 是否为横屏
 *                 Whether it is landscape
 */
val Resources.isOrientationLandscape: Boolean
    get() = currentOrientation == Configuration.ORIENTATION_LANDSCAPE