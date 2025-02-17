package com.gyf.foundation.cs.common.face

import android.os.Message

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 16:21
 */
interface IGetQuick {

    fun getQuick(data: Any?): Message?
    fun getQuick(data: Any?, data2: Any?): Message?
    fun getQuick(data: Any?, data2: Any?, data3: Any?): Message?
    fun getQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?): Message?
    fun getQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?): Message?

    fun getQuick(clientTag: String, data: Any?): Message?
    fun getQuick(clientTag: String, data: Any?, data2: Any?): Message?
    fun getQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?): Message?
    fun getQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message?

    fun getQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message?

    fun getQuick(what: Int, data: Any?): Message?
    fun getQuick(what: Int, data: Any?, data2: Any?): Message?
    fun getQuick(what: Int, data: Any?, data2: Any?, data3: Any?): Message?
    fun getQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?): Message?
    fun getQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?): Message?

    fun getQuick(clientTag: String, what: Int, data: Any?): Message?
    fun getQuick(clientTag: String, what: Int, data: Any?, data2: Any?): Message?
    fun getQuick(clientTag: String, what: Int, data: Any?, data2: Any?, data3: Any?): Message?
    fun getQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message?

    fun getQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message?
}