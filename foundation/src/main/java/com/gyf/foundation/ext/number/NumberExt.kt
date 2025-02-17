package com.gyf.foundation.ext.number

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.ceil
import kotlin.math.floor

/**
 * 数字扩展类
 * Number Extension Class
 *
 * @author  ifan.ge
 * @date  2024/6/28 13:40
 */

/**
 * 设置新的小数位数
 * Set new decimal places
 *
 * @param newScale Int 新的小数位数
 *                 The new number of decimal places
 * @return String 返回设置新的小数位数后的字符串
 *                Returns the string after setting the new number of decimal places
 */
fun Number.newScale(newScale: Int = 2): String {
    val bd = BigDecimal(this.toDouble())
    return bd.setScale(newScale, RoundingMode.HALF_UP).toString()
}

/**
 * 向上取整并转换为整数
 * Round up and convert to integer
 *
 * @return Int 返回向上取整后的整数
 *             Returns the integer after rounding up
 */
fun Number.ceilToInt(): Int {
    return ceil(this.toDouble()).toInt()
}

/**
 * 向下取整并转换为整数
 * Round down and convert to integer
 *
 * @return Int 返回向下取整后的整数
 *             Returns the integer after rounding down
 */
fun Number.floorToInt(): Int {
    return floor(this.toDouble()).toInt()
}