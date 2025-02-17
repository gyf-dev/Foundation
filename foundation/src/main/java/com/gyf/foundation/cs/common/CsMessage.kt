package com.gyf.foundation.cs.common

import android.os.Bundle
import android.os.Message
import android.os.Messenger
import com.gyf.foundation.cs.common.face.IMessage
import com.gyf.foundation.ext.bundle.Bundle
import com.gyf.foundation.ext.bundle.get
import com.gyf.foundation.ext.bundle.put
import java.util.UUID

/**
 * 默认的IMessage实现类
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/26 10:40
 */
class CsMessage : IMessage {

    /**
     * 消息标签
     */
    override var _clientTag: String = CsConst.MSG_EXTRA_CLIENT_TAG_DEFAULT_VALUE


    /**
     * 创建一个新的Message对象，指定其what字段
     * @param what 指定的what字段
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(what: Int): Message = obtainMessage(_clientTag, what, Bundle())

    /**
     * 创建一个新的Message对象，指定其what字段和clientTag
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(clientTag: String, what: Int): Message =
        obtainMessage(clientTag, what, Bundle())

    /**
     * 创建一个新的Message对象，指定其数据
     * @param bundle 指定的数据
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(bundle: Bundle): Message = obtainMessage(_clientTag, 0, bundle)

    /**
     * 创建一个新的Message对象，指定其what字段和数据
     * @param what 指定的what字段
     * @param bundle 指定的数据
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(what: Int, bundle: Bundle): Message =
        obtainMessage(_clientTag, what, bundle)

    /**
     * 创建一个新的Message对象，指定其what字段、clientTag和数据
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @param bundle 指定的数据
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(clientTag: String, what: Int, bundle: Bundle): Message {
        val msg = Message()
        msg.what = what
        msg.data = Bundle().apply {
            putAll(bundle)
            put(CsConst.MSG_EXTRA_CLIENT_TAG to clientTag)
        }
        return msg
    }

    /**
     * 创建一个新的Message对象，指定其数据
     * @param pair 指定的数据
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(pair: Pair<String, Any>): Message =
        obtainMessage(_clientTag, 0, Bundle(pair))

    /**
     * 创建一个新的Message对象，指定其what字段和数据
     * @param what 指定的what字段
     * @param pair 指定的数据
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(what: Int, pair: Pair<String, Any>): Message =
        obtainMessage(_clientTag, what, Bundle(pair))

    /**
     * 创建一个新的Message对象，指定其what字段、clientTag和数据
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @param pair 指定的数据
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(clientTag: String, what: Int, pair: Pair<String, Any>): Message =
        obtainMessage(clientTag, what, Bundle(pair))

    /**
     * 创建一个新的Message对象，指定其数据
     *
     * @param message Message 旧的Message对象
     * @return Message 新创建的Message对象
     */
    override fun obtainMessage(message: Message): Message {
        return obtainMessage(_clientTag, message)
    }

    override fun obtainMessage(clientTag: String, message: Message): Message {
        return Message.obtain(message).apply {
            data.put(CsConst.MSG_EXTRA_CLIENT_TAG to clientTag)
        }
    }

    /**
     * 获取消息的客户端标签
     */
    override fun Message.replyTo(messenger: Messenger?): Message {
        replyTo = messenger
        return this
    }

    /**
     * 获取消息的客户端标签
     */
    override fun Message.getClientTag(): String {
        return data.get<String>(CsConst.MSG_EXTRA_CLIENT_TAG) ?: ""
    }

    override fun Message.putClientTagIf(clientTag: String): Message {
        return this.apply {
            if (!hasClientTag()) {
                data.put(CsConst.MSG_EXTRA_CLIENT_TAG to clientTag)
            }
        }
    }

    /**
     * 是否有ClientTag字段
     *
     * @receiver Message
     * @return Boolean true 有 false 没有
     */
    override fun Message.hasClientTag(): Boolean {
        return getClientTag().isNotBlank()
    }

    override fun Message.getCookie(): String {
        return data.get<String>(CsConst.MSG_EXTRA_CLIENT_COOKIES) ?: ""
    }

    override fun Message.putCookieIf(): Message {
        return this.apply {
            if (!hasCookie()) {
                data.put(CsConst.MSG_EXTRA_CLIENT_COOKIES to UUID.randomUUID().toString())
            }
        }
    }

    override fun Message.hasCookie(): Boolean {
        return getCookie().isNotBlank()
    }

    override fun Message.replyTo(oldMessage: Message): Message {
        return this.apply {

            what = oldMessage.what

            val cookie = oldMessage.getCookie()
            if (getCookie() != cookie) {
                data.put(CsConst.MSG_EXTRA_CLIENT_COOKIES to cookie)
            }

            val clientTag = oldMessage.getClientTag()
            if (getClientTag() != clientTag) {
                data.put(CsConst.MSG_EXTRA_CLIENT_TAG to clientTag)
            }
        }
    }

    override fun Message.isSame(otherMessage: Message): Boolean {
        return hasCookie() && otherMessage.hasCookie() && getCookie() == otherMessage.getCookie()
    }
}