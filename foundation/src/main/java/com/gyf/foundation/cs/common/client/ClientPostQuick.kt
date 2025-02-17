package com.gyf.foundation.cs.common.client

import android.os.Message
import com.gyf.foundation.cs.common.client.callback.ClientCallback
import com.gyf.foundation.cs.common.client.face.IClientPostQuick

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 16:30
 */
class ClientPostQuick : IClientPostQuick {

    override var _postQuickAbsClient: AbsClient? = null

    override fun postQuick(data: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(data).putCookieIf())
        }
    }

    override fun postQuick(data: Any?, data2: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(data, data2).putCookieIf())
        }
    }

    override fun postQuick(data: Any?, data2: Any?, data3: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(data, data2, data3).putCookieIf())
        }
    }

    override fun postQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(data, data2, data3, data4).putCookieIf())
        }
    }

    override fun postQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(data, data2, data3, data4, data5).putCookieIf())
        }
    }

    override fun postQuick(clientTag: String, data: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(clientTag, data).putCookieIf())
        }
    }

    override fun postQuick(clientTag: String, data: Any?, data2: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(clientTag, data, data2).putCookieIf())
        }
    }

    override fun postQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(clientTag, data, data2, data3).putCookieIf())
        }
    }

    override fun postQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?, data4: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(clientTag, data, data2, data3, data4).putCookieIf())
        }
    }

    override fun postQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(clientTag, data, data2, data3, data4, data5).putCookieIf())
        }
    }

    override fun postQuick(what: Int, data: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(obtainMessageQuick(what, data).putCookieIf())
        }
    }

    override fun postQuick(what: Int, data: Any?, data2: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    what,
                    data,
                    data2
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    what,
                    data,
                    data2,
                    data3
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    what,
                    data,
                    data2,
                    data3,
                    data4
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    what,
                    data,
                    data2,
                    data3,
                    data4,
                    data5
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, what: Int, data: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    clientTag,
                    what,
                    data
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, what: Int, data: Any?, data2: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    clientTag,
                    what,
                    data,
                    data2
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, what: Int, data: Any?, data2: Any?, data3: Any?) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    clientTag,
                    what,
                    data,
                    data2,
                    data3
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    clientTag,
                    what,
                    data,
                    data2,
                    data3,
                    data4
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ) {
        _postQuickAbsClient?.apply {
            enqueue(
                obtainMessageQuick(
                    clientTag,
                    what,
                    data,
                    data2,
                    data3,
                    data4,
                    data5
                ).putCookieIf()
            )
        }
    }

    override fun postQuick(what: Int, data: Any?, result: (Message) -> Unit) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(what, data)
        }
    }

    override fun postQuick(what: Int, data: Any?, data2: Any?, result: (Message) -> Unit) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(what, data, data2)
        }
    }

    override fun postQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        result: (Message) -> Unit
    ) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(what, data, data2, data3)
        }
    }

    override fun postQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        result: (Message) -> Unit
    ) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(what, data, data2, data3, data4)
        }
    }

    override fun postQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?,
        result: (Message) -> Unit
    ) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(what, data, data2, data3, data4, data5)
        }
    }

    override fun postQuick(clientTag: String, what: Int, data: Any?, result: (Message) -> Unit) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(clientTag, what, data)
        }
    }

    override fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        result: (Message) -> Unit
    ) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(clientTag, what, data, data2)
        }
    }

    override fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        result: (Message) -> Unit
    ) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(clientTag, what, data, data2, data3)
        }
    }

    override fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        result: (Message) -> Unit
    ) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(clientTag, what, data, data2, data3, data4)
        }
    }

    override fun postQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?,
        result: (Message) -> Unit
    ) {
        _postQuickAbsClient.request(result) {
            obtainMessageQuick(clientTag, what, data, data2, data3, data4, data5)
        }
    }

    private fun AbsClient?.request(result: (Message) -> Unit, message: AbsClient.() -> Message) {
        val client = this ?: return
        client.apply {
            val originalMessage = message(client).putCookieIf()
            addClientCallback(object : ClientCallback {
                override fun onResponse(clientTag: String, message: Message) {
                    val same = originalMessage.isSame(message)
                    if (same) {
                        result(message)
                        removeClientCallback(this)
                    }
                }
            })
            enqueue(originalMessage)
        }
    }
}