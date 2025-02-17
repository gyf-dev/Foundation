@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.ext.percentage

/**
 * 百分比映射器
 * Percentage Mapper
 *
 * 这个类提供了两个主要的功能：
 * 1. 将一个值映射为百分比
 * 2. 根据百分比计算对应的值
 *
 * This class provides two main functions:
 * 1. Maps a value to a percentage
 * 2. Calculates the corresponding value based on the percentage
 *
 * @Author  Ifan.Ge
 * @Date    2024/5/28 16:58
 */
object PercentageMapper {

    /**
     * 将当前值映射为百分比
     * Maps the current value to a percentage
     *
     * @param minValue Double 最小值，用于定义映射范围的下限
     *                 The minimum value, used to define the lower limit of the mapping range
     * @param maxValue Double 最大值，用于定义映射范围的上限
     *                 The maximum value, used to define the upper limit of the mapping range
     * @param currentValue Double 当前值，将被映射到百分比
     *                     The current value, which will be mapped to a percentage
     * @return Double 返回当前值对应的百分比
     *                Returns the percentage corresponding to the current value
     */
    fun to(minValue: Double, maxValue: Double, currentValue: Double): Double {
        require(minValue < maxValue) { "minValue must be less than maxValue." }
        require(currentValue in minValue..maxValue) { "currentValue must be between minValue and maxValue." }
        return ((currentValue - minValue) / (maxValue - minValue)) * 100
    }

    /**
     * 根据百分比计算对应的值
     * Calculates the corresponding value based on the percentage
     *
     * @param minValue Double 最小值，用于定义映射范围的下限
     *                 The minimum value, used to define the lower limit of the mapping range
     * @param maxValue Double 最大值，用于定义映射范围的上限
     *                 The maximum value, used to define the upper limit of the mapping range
     * @param percentage Double 百分比，用于计算对应的值
     *                   The percentage, used to calculate the corresponding value
     * @return Double 返回百分比对应的值
     *                Returns the value corresponding to the percentage
     */
    fun from(minValue: Double, maxValue: Double, percentage: Double): Double {
        require(minValue < maxValue) { "minValue must be less than maxValue." }
        require(percentage in 0.0..100.0) { "Percentage must be between 0 and 100." }
        return minValue + (percentage / 100) * (maxValue - minValue)
    }

    /**
     * 将当前值映射为百分比
     * Maps the current value to a percentage
     *
     * @param minValue Number 最小值，用于定义映射范围的下限
     *                 The minimum value, used to define the lower limit of the mapping range
     * @param maxValue Number 最大值，用于定义映射范围的上限
     *                 The maximum value, used to define the upper limit of the mapping range
     * @param currentValue Number 当前值，将被映射到百分比
     *                     The current value, which will be mapped to a percentage
     * @return Double 返回当前值对应的百分比
     *                Returns the percentage corresponding to the current value
     */
    fun to(minValue: Number, maxValue: Number, currentValue: Number): Double =
        to(minValue.toDouble(), maxValue.toDouble(), currentValue.toDouble())

    /**
     * 根据百分比计算对应的值，接受Number类型的参数
     * Calculates the corresponding value based on the percentage, accepts parameters of Number type
     *
     * @param minValue Number 最小值，用于定义映射范围的下限
     *                 The minimum value, used to define the lower limit of the mapping range
     * @param maxValue Number 最大值，用于定义映射范围的上限
     *                 The maximum value, used to define the upper limit of the mapping range
     * @param percentage Number 百分比，用于计算对应的值
     *                   The percentage, used to calculate the corresponding value
     * @return Double 返回百分比对应的值
     *                Returns the value corresponding to the percentage
     */
    fun from(minValue: Number, maxValue: Number, percentage: Number) =
        from(minValue.toDouble(), maxValue.toDouble(), percentage.toDouble())
}