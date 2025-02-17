package com.gyf.foundation.cs.common.client

import android.os.Bundle
import android.os.Message
import com.gyf.foundation.cs.common.client.callback.ClientCallback
import com.gyf.foundation.cs.common.client.face.IClientPost2

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/3 10:56
 */
class ClientPost2 : IClientPost2 {

    override var _postAbsClient: AbsClient? = null

    private fun request(result: (Message) -> Unit, message: AbsClient.() -> Message) {
        val client = _postAbsClient ?: return
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

    override fun post(what: Int, result: (Message) -> Unit) {
        request(result) { obtainMessage(what) }
    }

    override fun post(clientTag: String, what: Int, result: (Message) -> Unit) {
        request(result) { obtainMessage(clientTag, what) }
    }

    override fun post(bundle: Bundle, result: (Message) -> Unit) {
        request(result) { obtainMessage(bundle) }
    }

    override fun post(what: Int, bundle: Bundle, result: (Message) -> Unit) {
        request(result) { obtainMessage(what, bundle) }
    }

    override fun post(clientTag: String, what: Int, bundle: Bundle, result: (Message) -> Unit) {
        request(result) { obtainMessage(clientTag, what, bundle) }
    }

    override fun post(pair: Pair<String, Any>, result: (Message) -> Unit) {
        request(result) { obtainMessage(pair) }
    }

    override fun post(what: Int, pair: Pair<String, Any>, result: (Message) -> Unit) {
        request(result) { obtainMessage(what, pair) }
    }

    override fun post(
        clientTag: String,
        what: Int,
        pair: Pair<String, Any>,
        result: (Message) -> Unit
    ) {
        request(result) { obtainMessage(clientTag, what, pair) }
    }

    override fun post(message: Message, result: (Message) -> Unit) {
        request(result) { obtainMessage(message) }
    }

    override fun post(clientTag: String, message: Message, result: (Message) -> Unit) {
        request(result) { obtainMessage(clientTag, message) }
    }


}