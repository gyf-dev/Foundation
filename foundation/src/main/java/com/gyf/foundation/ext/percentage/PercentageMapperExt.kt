package com.gyf.foundation.ext.percentage

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/28 17:53
 */

/**
 * 将一个数值转换为百分比形式。
 * Converts a number to its percentage form.
 *
 * @param minValue 最小值。
 *                 The minimum value.
 * @param maxValue 最大值。
 *                 The maximum value.
 * @return Double 返回原始形式的数值。
 *                Returns the number in its original form.
 */
fun Number.toPercentage(minValue: Number, maxValue: Number): Double =
    PercentageMapper.to(minValue.toDouble(), maxValue.toDouble(), this.toDouble())

/**
 * 从百分比形式转换回原始数值。
 * Converts a number from its percentage form back to its original form.
 *
 * @param minValue 最小值。
 *                 The minimum value.
 * @param maxValue 最大值。
 *                 The maximum value.
 * @return Double 返回原始形式的数值。
 *                Returns the number in its original form.
 */
fun Number.fromPercentage(minValue: Number, maxValue: Number): Double =
    PercentageMapper.from(minValue.toDouble(), maxValue.toDouble(), this.toDouble())