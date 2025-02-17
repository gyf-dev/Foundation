package com.gyf.foundation.ext.log

import android.util.Log
import com.gyf.foundation.Foundation

/**
 * 日志扩展文件，提供了一些方便的日志打印方法。
 *
 * @Author  Ifan.Ge
 * @Date    2024/5/11 16:13
 */

/**
 * 字符串的日志打印扩展函数。
 *
 * @receiver String
 * @param tag String 日志标签
 * @param logLevel LogLevel 日志级别，默认为 LogLevel.D
 * @param enabled Boolean 是否启用日志，默认为 true
 * @param saveLogger Logger 日志保存的位置，默认为 logger
 */
fun String.log(
    tag: String,
    logLevel: LogLevel = LogLevel.D,
    enabled: Boolean = true,
    saveLogger: Logger? = null
) {
    if (enabled.not()) return
    val prefix = "${tag.modifyStringLength(20)} :   "
    val msg = "$prefix$this"
    when (logLevel) {
        LogLevel.D -> Log.d(tag, msg)
        LogLevel.I -> Log.i(tag, msg)
        LogLevel.W -> Log.w(tag, msg)
        LogLevel.E -> Log.e(tag, msg)
    }
    if (Foundation.isInitialized.not()) return

    if (saveLogger != null) {
        saveLogger.write(tag, msg)
    } else {
        for (logger in Logger.loggers) {
            logger.write(tag, msg)
        }
    }
}

/**
 * 任意对象的日志打印扩展函数。
 *
 * @receiver Any?
 * @param tag String 日志标签
 * @param logLevel LogLevel 日志级别，默认为 LogLevel.D
 * @param enabled Boolean 是否启用日志，默认为 true
 * @param saveLogger Logger 日志保存的位置，默认为 logger
 */
fun Any?.log(
    tag: String,
    logLevel: LogLevel = LogLevel.D,
    enabled: Boolean = true,
    saveLogger: Logger? = null
) {
    if (this is String) {
        this.log(tag, logLevel, enabled, saveLogger)
    } else {
        this.toString().log(tag, logLevel, enabled, saveLogger)
    }
}

/**
 * 修改字符串长度的扩展函数，用于格式化日志输出。
 *
 * @receiver String
 * @param size Int 目标长度
 * @return String 修改后的字符串
 */
private fun String.modifyStringLength(size: Int): String {
    return when {
        length < size -> this.padEnd(size, ' ')
        length > size -> this.substring(0, size)
        else -> this
    }
}