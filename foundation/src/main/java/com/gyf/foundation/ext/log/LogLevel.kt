package com.gyf.foundation.ext.log

/**
 * LogLevel 是一个封闭类，代表日志级别。
 * 它有四个数据对象：D、I、W、E，分别代表 Debug、Info、Warning 和 Error。
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/13 15:36
 */
sealed class LogLevel {
    /**
     * D 代表 Debug 级别
     */
    data object D : LogLevel()

    /**
     * I 代表 Info 级别
     */
    data object I : LogLevel()

    /**
     * W 代表 Warning 级别
     */
    data object W : LogLevel()

    /**
     * E 代表 Error 级别
     */
    data object E : LogLevel()
}