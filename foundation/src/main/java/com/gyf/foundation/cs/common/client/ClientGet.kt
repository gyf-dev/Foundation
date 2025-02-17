package com.gyf.foundation.cs.common.client

import android.os.Bundle
import android.os.Message
import com.gyf.foundation.cs.common.client.face.IClientGet
import com.gyf.foundation.cs.common.client.face.IClientProvider

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/3 10:56
 */
class ClientGet : IClientGet {

    override var _getClientProvider: IClientProvider? = null

    override fun get(what: Int) =
        _getClientProvider?.run { execute(obtainMessage(what).putCookieIf()) }

    override fun get(clientTag: String, what: Int) =
        _getClientProvider?.run { execute(obtainMessage(clientTag, what).putCookieIf()) }

    override fun get(bundle: Bundle) =
        _getClientProvider?.run { execute(obtainMessage(bundle).putCookieIf()) }

    override fun get(what: Int, bundle: Bundle) =
        _getClientProvider?.run { execute(obtainMessage(what, bundle).putCookieIf()) }

    override fun get(clientTag: String, what: Int, bundle: Bundle) =
        _getClientProvider?.run { execute(obtainMessage(clientTag, what, bundle).putCookieIf()) }

    override fun get(pair: Pair<String, Any>) =
        _getClientProvider?.run { execute(obtainMessage(pair).putCookieIf()) }

    override fun get(what: Int, pair: Pair<String, Any>) =
        _getClientProvider?.run { execute(obtainMessage(what, pair).putCookieIf()) }

    override fun get(clientTag: String, what: Int, pair: Pair<String, Any>) =
        _getClientProvider?.run { execute(obtainMessage(clientTag, what, pair).putCookieIf()) }

    override fun get(message: Message) =
        _getClientProvider?.run { execute(obtainMessage(message).putCookieIf()) }

    override fun get(clientTag: String, message: Message) =
        _getClientProvider?.run { execute(obtainMessage(clientTag, message).putCookieIf()) }
}