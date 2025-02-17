package com.gyf.foundation.cs.common.face

import android.os.Message

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 18:09
 */
interface IPostQuick2 {

    fun postQuick(what: Int, data: Any?, result: (Message) -> Unit)
    fun postQuick(what: Int, data: Any?, data2: Any?, result: (Message) -> Unit)
    fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?, result: (Message) -> Unit)
    fun postQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        result: (Message) -> Unit
    )

    fun postQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?,
        result: (Message) -> Unit
    )

    fun postQuick(clientTag: String, what: Int, data: Any?, result: (Message) -> Unit)
    fun postQuick(clientTag: String, what: Int, data: Any?, data2: Any?, result: (Message) -> Unit)
    fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        result: (Message) -> Unit
    )

    fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        result: (Message) -> Unit
    )

    fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?,
        result: (Message) -> Unit
    )
}