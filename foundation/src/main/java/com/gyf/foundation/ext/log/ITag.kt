package com.gyf.foundation.ext.log

/**
 * ITag 接口定义了日志标签和日志级别的获取方式，以及日志的打印方法。
 *
 * @Author  Ifan.Ge
 * @Date    2024/5/11 16:22
 */
interface ITag {

    /**
     * 获取日志标签，缺省值为类名。
     */
    val tagName: String get() = this::class.java.simpleName

    /**
     * 获取是否启用日志，缺省值为 true。
     */
    val enableLog: Boolean get() = true

    /**
     * 获取日志级别，缺省值为 LogLevel.D。
     */
    val logLevel: LogLevel get() = LogLevel.D

    /**
     * 打印日志，缺省值为 log()。
     */
    val Any?.log: Unit get() = log()

    /**
     * 打印日志的方法，可以指定日志级别、是否启用日志以及日志保存的位置。
     *
     * @param logLevel LogLevel 日志级别，默认为接口定义的日志级别。
     * @param enabled Boolean 是否启用日志，默认为接口定义的启用日志。
     * @param saveLogger Logger 日志保存的位置，默认为 logger。
     */
    fun Any?.log(
        logLevel: LogLevel = this@ITag.logLevel,
        enabled: Boolean = this@ITag.enableLog,
        saveLogger: Logger? = null
    ) {
        this.log(tagName, logLevel, enabled, saveLogger)
    }
}