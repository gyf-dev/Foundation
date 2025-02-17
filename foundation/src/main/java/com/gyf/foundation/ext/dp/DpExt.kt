package com.gyf.foundation.ext.dp

import android.util.TypedValue
import com.gyf.foundation.Foundation

private val resources get() = Foundation.context.resources

/**
 * 将dp转换为px
 * Converts dp to px
 *
 * @return Int 返回转换后的px值
 *             Returns the converted px value
 */
val Number.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        toFloat(),
        resources.displayMetrics
    ).toInt()

/**
 * 将px转换为dp
 * Converts px to dp
 *
 * @return Int 返回转换后的dp值
 *             Returns the converted dp value
 */
val Number.px2dp get() = (toFloat() / resources.displayMetrics.density).toInt()

/**
 * 将sp转换为px
 * Converts sp to px
 *
 * @return Int 返回转换后的px值
 *             Returns the converted px value
 */
val Number.sp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        toFloat(),
        resources.displayMetrics
    ).toInt()

/**
 * 将px转换为sp
 * Converts px to sp
 *
 * @return Int 返回转换后的sp值
 *             Returns the converted sp value
 */
@Suppress("DEPRECATION")
val Number.px2sp get() = (toFloat() / resources.displayMetrics.scaledDensity).toInt()