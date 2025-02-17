@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.ext.log

import com.gyf.foundation.Foundation
import com.gyf.foundation.ext.coroutine.ICoroutine
import com.gyf.foundation.ext.coroutine.ioScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Logger类用于管理日志的写入和读取。
 * 它实现了ICoroutine接口，可以在协程中进行日志操作。
 *
 * @Author  Ifan.Ge
 * @Date    2024/5/13 15:40
 */
class Logger(private val dirName: String) : ICoroutine {

    companion object {

        /**
         * 日志目录名称常量
         */
        const val DEFAULT_LOG_DIR_NAME = "logs"

        internal val loggers = mutableListOf(Logger(DEFAULT_LOG_DIR_NAME))

        /**
         * 添加日志保存位置的方法。
         *
         * @param logger 日志保存位置。
         */
        fun addLogger(logger: Logger) {
            loggers += logger
        }

        /**
         * 移除日志保存位置的方法。
         *
         * @param logger 日志保存位置。
         */
        fun removeLogger(logger: Logger) {
            loggers -= logger
        }
    }

    /**
     * 用于写入操作的互斥锁。
     */
    private val mutexWrite = Mutex()

    /**
     * 用于读取操作的互斥锁。
     */
    private val mutexRead = Mutex()

    /**
     * 写入日志方法，将标签和消息写入日志文件。
     *
     * @param tag 日志标签。
     * @param message 日志消息。
     */
    fun write(tag: String, message: String) {
        ioScope.launch {
            mutexWrite.withLock {
                writeInternal(tag, message)
            }
        }
    }

    /**
     * 读取日志方法，根据日期读取日志文件。
     *
     * @param date 日期字符串，格式为"yyyy-MM-dd"。
     * @return 日志文件内容。
     */
    fun read(date: String): String {
        val logDir = File(Foundation.context.externalCacheDir, dirName)
        val logFile = File(logDir, "$date.txt")
        if (!logFile.exists()) {
            return ""
        }
        return logFile.readText()
    }

    /**
     * 协程版本的读取日志方法，根据日期读取日志文件。
     *
     * @param date 日期字符串，格式为"yyyy-MM-dd"。
     * @return 日志文件内容。
     */
    suspend fun readBySuspend(date: String): String {
        return mutexRead.withLock { read(date) }
    }

    /**
     * 异步读取日志方法，根据日期读取日志文件，并在读取完成后调用回调函数。
     *
     * @param date 日期字符串，格式为"yyyy-MM-dd"。
     * @param block 读取完成后的回调函数。
     */
    fun read(date: String, block: (String) -> Unit) {
        ioScope.launch {
            block(readBySuspend(date))
        }
    }

    /**
     * 内部写入日志方法，将标签和消息写入日志文件。
     *
     * @param tag 日志标签。
     * @param message 日志消息。
     */
    private fun writeInternal(tag: String, message: String) {
        val logDir = File(Foundation.context.cacheDir, dirName)
        if (!logDir.exists()) {
            logDir.mkdirs()
        }

        val logFile = File(logDir, getLogFileDate() + ".txt")

        FileWriter(logFile, true).use { writer ->
            val currentTime =
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
            writer.appendLine("$currentTime - $tag$message")
        }
    }

    /**
     * 获取日志文件日期的方法，返回当前日期的字符串，格式为"yyyy-MM-dd"。
     *
     * @return 当前日期的字符串。
     */
    private fun getLogFileDate(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }
}