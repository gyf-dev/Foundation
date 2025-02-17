package com.gyf.foundation.cs.common.face

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 16:21
 */
interface IPostQuick {

    fun postQuick(data: Any?)
    fun postQuick(data: Any?, data2: Any?)
    fun postQuick(data: Any?, data2: Any?, data3: Any?)
    fun postQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?)
    fun postQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?)

    fun postQuick(clientTag: String, data: Any?)
    fun postQuick(clientTag: String, data: Any?, data2: Any?)
    fun postQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?)
    fun postQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?, data4: Any?)
    fun postQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    )

    fun postQuick(what: Int, data: Any?)
    fun postQuick(what: Int, data: Any?, data2: Any?)
    fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?)
    fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?)
    fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?)

    fun postQuick(clientTag: String, what: Int, data: Any?)
    fun postQuick(clientTag: String, what: Int, data: Any?, data2: Any?)
    fun postQuick(clientTag: String, what: Int, data: Any?, data2: Any?, data3: Any?)
    fun postQuick(clientTag: String, what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?)
    fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    )
}