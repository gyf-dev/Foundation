package com.gyf.foundation.cs.common.service

import android.os.Bundle
import android.os.Message
import com.gyf.foundation.cs.common.service.face.IServiceGet
import com.gyf.foundation.cs.common.service.face.IServiceProvider

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/2 15:31
 */
class ServiceGet : IServiceGet {

    override var _getServiceProvider: IServiceProvider? = null

    override fun get(what: Int): Message? {
        return _getServiceProvider?.obtainMessage(what)
    }

    override fun get(clientTag: String, what: Int): Message? {
        return _getServiceProvider?.obtainMessage(clientTag, what)
    }

    override fun get(bundle: Bundle): Message? {
        return _getServiceProvider?.obtainMessage(bundle)
    }

    override fun get(what: Int, bundle: Bundle): Message? {
        return _getServiceProvider?.obtainMessage(what, bundle)
    }

    override fun get(clientTag: String, what: Int, bundle: Bundle): Message? {
        return _getServiceProvider?.obtainMessage(clientTag, what, bundle)
    }

    override fun get(pair: Pair<String, Any>): Message? {
        return _getServiceProvider?.obtainMessage(pair)
    }

    override fun get(what: Int, pair: Pair<String, Any>): Message? {
        return _getServiceProvider?.obtainMessage(what, pair)
    }

    override fun get(clientTag: String, what: Int, pair: Pair<String, Any>): Message? {
        return _getServiceProvider?.obtainMessage(clientTag, what, pair)
    }

    override fun get(message: Message): Message? {
        return _getServiceProvider?.obtainMessage(message)
    }

    override fun get(clientTag: String, message: Message): Message? {
        return _getServiceProvider?.obtainMessage(clientTag, message)
    }

    override fun getQuick(data: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(data)
    }

    override fun getQuick(data: Any?, data2: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(data, data2)
    }

    override fun getQuick(data: Any?, data2: Any?, data3: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(data, data2, data3)
    }

    override fun getQuick(data: Any?, data2: Any?, data3: Any?, data4: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(data, data2, data3, data4)
    }

    override fun getQuick(
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message? {
        return _getServiceProvider?.obtainMessageQuick(data, data2, data3, data4, data5)
    }

    override fun getQuick(clientTag: String, data: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, data)
    }

    override fun getQuick(clientTag: String, data: Any?, data2: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, data, data2)
    }

    override fun getQuick(clientTag: String, data: Any?, data2: Any?, data3: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, data, data2, data3)
    }

    override fun getQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, data, data2, data3, data4)
    }

    override fun getQuick(
        clientTag: String,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, data, data2, data3, data4, data5)
    }

    override fun getQuick(what: Int, data: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(what, data)
    }

    override fun getQuick(what: Int, data: Any?, data2: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(what, data, data2)
    }

    override fun getQuick(what: Int, data: Any?, data2: Any?, data3: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(what, data, data2, data3)
    }

    override fun getQuick(what: Int, data: Any?, data2: Any?, data3: Any?, data4: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(what, data, data2, data3, data4)
    }

    override fun getQuick(
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message? {
        return _getServiceProvider?.obtainMessageQuick(what, data, data2, data3, data4, data5)
    }

    override fun getQuick(clientTag: String, what: Int, data: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, what, data)
    }

    override fun getQuick(clientTag: String, what: Int, data: Any?, data2: Any?): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, what, data, data2)
    }

    override fun getQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?
    ): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, what, data, data2, data3)
    }

    override fun getQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message? {
        return _getServiceProvider?.obtainMessageQuick(clientTag, what, data, data2, data3, data4)
    }

    override fun getQuick(
        clientTag: String,
        what: Int,
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message? {
        return _getServiceProvider?.obtainMessageQuick(
            clientTag,
            what,
            data,
            data2,
            data3,
            data4,
            data5
        )
    }

    override fun Message.replyGet(bundle: Bundle): Message? {
        return _getServiceProvider?.run { obtainMessage(bundle).replyTo(this@replyGet) }
    }

    override fun Message.replyGet(pair: Pair<String, Any>): Message? {
        return _getServiceProvider?.run { obtainMessage(pair).replyTo(this@replyGet) }
    }

    override fun Message.replyGet(message: Message): Message? {
        return _getServiceProvider?.run { obtainMessage(message).replyTo(this@replyGet) }
    }

    override fun Message.replyGetQuick(data: Any?): Message? {
        return _getServiceProvider?.run {
            obtainMessageQuick(data).replyTo(this@replyGetQuick)
        }
    }

    override fun Message.replyGetQuick(data: Any?, data2: Any?): Message? {
        return _getServiceProvider?.run {
            obtainMessageQuick(data, data2).replyTo(this@replyGetQuick)
        }
    }

    override fun Message.replyGetQuick(data: Any?, data2: Any?, data3: Any?): Message? {
        return _getServiceProvider?.run {
            obtainMessageQuick(data, data2, data3).replyTo(this@replyGetQuick)
        }
    }

    override fun Message.replyGetQuick(
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?
    ): Message? {
        return _getServiceProvider?.run {
            obtainMessageQuick(data, data2, data3, data4).replyTo(this@replyGetQuick)
        }
    }

    override fun Message.replyGetQuick(
        data: Any?,
        data2: Any?,
        data3: Any?,
        data4: Any?,
        data5: Any?
    ): Message? {
        return _getServiceProvider?.run {
            obtainMessageQuick(data, data2, data3, data4, data5).replyTo(this@replyGetQuick)
        }
    }
}