package com.gyf.foundation.cs.common.client

import android.os.Bundle
import android.os.Message
import com.gyf.foundation.cs.common.client.face.IClientPost
import com.gyf.foundation.cs.common.client.face.IClientProvider

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/3 10:56
 */
class ClientPost : IClientPost {

    override var _postClientProvider: IClientProvider? = null

    override fun post(what: Int) {
        _postClientProvider?.apply { enqueue(obtainMessage(what).putCookieIf()) }
    }

    override fun post(clientTag: String, what: Int) {
        _postClientProvider?.apply { enqueue(obtainMessage(clientTag, what).putCookieIf()) }
    }

    override fun post(bundle: Bundle) {
        _postClientProvider?.apply { enqueue(obtainMessage(bundle).putCookieIf()) }
    }

    override fun post(what: Int, bundle: Bundle) {
        _postClientProvider?.apply { enqueue(obtainMessage(what, bundle).putCookieIf()) }
    }

    override fun post(clientTag: String, what: Int, bundle: Bundle) {
        _postClientProvider?.apply { enqueue(obtainMessage(clientTag, what, bundle).putCookieIf()) }
    }

    override fun post(pair: Pair<String, Any>) {
        _postClientProvider?.apply { enqueue(obtainMessage(pair).putCookieIf()) }
    }

    override fun post(what: Int, pair: Pair<String, Any>) {
        _postClientProvider?.apply { enqueue(obtainMessage(what, pair).putCookieIf()) }
    }

    override fun post(clientTag: String, what: Int, pair: Pair<String, Any>) {
        _postClientProvider?.apply { enqueue(obtainMessage(clientTag, what, pair).putCookieIf()) }
    }

    override fun post(message: Message) {
        _postClientProvider?.apply { enqueue(obtainMessage(message).putCookieIf()) }
    }

    override fun post(clientTag: String, message: Message) {
        _postClientProvider?.apply { enqueue(obtainMessage(clientTag, message).putCookieIf()) }
    }
}