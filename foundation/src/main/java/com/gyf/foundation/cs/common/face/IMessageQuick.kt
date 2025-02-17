package com.gyf.foundation.cs.common.face

import android.os.Message

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 18:14
 */
interface IMessageQuick {

    fun obtainMessageQuick(data: Any?): Message
    fun obtainMessageQuick(data: Any?, data2: Any?): Message
    fun obtainMessageQuick(data: Any?, data2: Any?, data3: Any?): Message
    fun obtainMessageQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?): Message
    fun obtainMessageQuick(
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message

    fun obtainMessageQuick(clientTag: String, data: Any?): Message
    fun obtainMessageQuick(clientTag: String, data: Any?, data2: Any?): Message
    fun obtainMessageQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?): Message
    fun obtainMessageQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message

    fun obtainMessageQuick(what: Int, data: Any?): Message
    fun obtainMessageQuick(what: Int, data: Any?, data2: Any?): Message
    fun obtainMessageQuick(what: Int, data: Any?, data2: Any?, data3: Any?): Message
    fun obtainMessageQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?): Message
    fun obtainMessageQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message

    fun obtainMessageQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message

    fun obtainMessageQuick(clientTag: String, what: Int, data: Any?): Message
    fun obtainMessageQuick(clientTag: String, what: Int, data: Any?, data2: Any?): Message
    fun obtainMessageQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?
    ): Message

    fun obtainMessageQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message

    fun obtainMessageQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message
}