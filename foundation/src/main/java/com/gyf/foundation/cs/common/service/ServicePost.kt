package com.gyf.foundation.cs.common.service

import android.os.Bundle
import android.os.Message
import com.gyf.foundation.cs.common.service.face.IServicePost
import com.gyf.foundation.cs.common.service.face.IServiceProvider

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/2 15:31
 */
class ServicePost : IServicePost {

    override var _postServiceProvider: IServiceProvider? = null

    override fun post(what: Int) {
        _postServiceProvider?.apply { response(obtainMessage(what).putCookieIf()) }
    }

    override fun post(clientTag: String, what: Int) {
        _postServiceProvider?.apply { response(obtainMessage(clientTag, what).putCookieIf()) }
    }

    override fun post(bundle: Bundle) {
        _postServiceProvider?.apply { response(obtainMessage(bundle).putCookieIf()) }
    }

    override fun post(what: Int, bundle: Bundle) {
        _postServiceProvider?.apply { response(obtainMessage(what, bundle).putCookieIf()) }
    }

    override fun post(clientTag: String, what: Int, bundle: Bundle) {
        _postServiceProvider?.apply {
            response(
                obtainMessage(
                    clientTag,
                    what,
                    bundle
                ).putCookieIf()
            )
        }
    }

    override fun post(pair: Pair<String, Any>) {
        _postServiceProvider?.apply { response(obtainMessage(pair).putCookieIf()) }
    }

    override fun post(what: Int, pair: Pair<String, Any>) {
        _postServiceProvider?.apply { response(obtainMessage(what, pair).putCookieIf()) }
    }

    override fun post(clientTag: String, what: Int, pair: Pair<String, Any>) {
        _postServiceProvider?.apply { response(obtainMessage(clientTag, what, pair).putCookieIf()) }
    }

    override fun post(message: Message) {
        _postServiceProvider?.apply { response(obtainMessage(message).putCookieIf()) }
    }

    override fun post(clientTag: String, message: Message) {
        _postServiceProvider?.apply { response(obtainMessage(clientTag, message).putCookieIf()) }
    }

    override fun postQuick(data: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(data).putCookieIf()
            )
        }
    }

    override fun postQuick(data: Any?, data2: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(data, data2).putCookieIf()
            )
        }
    }

    override fun postQuick(data: Any?, data2: Any?, data3: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(data, data2, data3).putCookieIf()
            )
        }
    }

    override fun postQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(data, data2, data3, data4).putCookieIf()
            )
        }
    }

    override fun postQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?, data5: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(data, data2, data3, data4, data5).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, data: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, data).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, data: Any?, data2: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, data, data2).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, data, data2, data3).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?, data4: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, data, data2, data3, data4).putCookieIf()
            )
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
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, data, data2, data3, data4, data5).putCookieIf()
            )
        }
    }

    override fun postQuick(what: Int, data: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(what, data).putCookieIf()
            )
        }
    }

    override fun postQuick(what: Int, data: Any?, data2: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(what, data, data2).putCookieIf()
            )
        }
    }

    override fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(what, data, data2, data3).putCookieIf()
            )
        }
    }

    override fun postQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(what, data, data2, data3, data4).putCookieIf()
            )
        }
    }

    override fun postQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(what, data, data2, data3, data4, data5).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, what: Int, data: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, what, data).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, what: Int, data: Any?, data2: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, what, data, data2).putCookieIf()
            )
        }
    }

    override fun postQuick(clientTag: String, what: Int, data: Any?, data2: Any?, data3: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, what, data, data2, data3).putCookieIf()
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
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, what, data, data2, data3, data4).putCookieIf()
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
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(clientTag, what, data, data2, data3, data4, data5).putCookieIf()
            )
        }
    }

    override fun Message.replyPost(bundle: Bundle) {
        _postServiceProvider?.apply { response(obtainMessage(bundle).replyTo(this@replyPost)) }
    }

    override fun Message.replyPost(pair: Pair<String, Any>) {
        _postServiceProvider?.apply { response(obtainMessage(pair).replyTo(this@replyPost)) }
    }

    override fun Message.replyPost(message: Message) {
        _postServiceProvider?.apply { response(obtainMessage(message).replyTo(this@replyPost)) }
    }

    override fun Message.replyPostQuick(data: Any?) {
        _postServiceProvider?.apply { response(obtainMessageQuick(data).replyTo(this@replyPostQuick)) }
    }

    override fun Message.replyPostQuick(data: Any?, data2: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(
                    data,
                    data2
                ).replyTo(this@replyPostQuick)
            )
        }
    }

    override fun Message.replyPostQuick(data: Any?, data2: Any?, data3: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(
                    data,
                    data2,
                    data3
                ).replyTo(this@replyPostQuick)
            )
        }
    }

    override fun Message.replyPostQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(data, data2, data3, data4).replyTo(
                    this@replyPostQuick
                )
            )
        }
    }

    override fun Message.replyPostQuick(
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ) {
        _postServiceProvider?.apply {
            response(
                obtainMessageQuick(data, data2, data3, data4, data5).replyTo(
                    this@replyPostQuick
                )
            )
        }
    }
}