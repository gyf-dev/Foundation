@file:Suppress("PropertyName")

package com.gyf.foundation.cs.common.face

import android.os.Bundle
import android.os.Message
import android.os.Messenger

/**
 * IMessage接口，定义了一系列与消息相关的方法
 * @Author  Ifan.Ge
 * @Date    2024/6/26 10:34
 */
interface IMessage {

    /**
     * 消息标签
     */
    var _clientTag: String

    /**
     * 创建一个新的Message对象，指定其what字段
     * @param what 指定的what字段
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(what: Int): Message

    /**
     * 创建一个新的Message对象，指定其what字段和clientTag
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(clientTag: String, what: Int): Message

    /**
     * 创建一个新的Message对象，指定其数据
     * @param bundle 指定的数据
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(bundle: Bundle): Message

    /**
     * 创建一个新的Message对象，指定其what字段和数据
     * @param what 指定的what字段
     * @param bundle 指定的数据
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(what: Int, bundle: Bundle): Message

    /**
     * 创建一个新的Message对象，指定其what字段、clientTag和数据
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @param bundle 指定的数据
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(clientTag: String, what: Int, bundle: Bundle): Message

    /**
     * 创建一个新的Message对象，指定其数据
     * @param pair 指定的数据
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(pair: Pair<String, Any>): Message

    /**
     * 创建一个新的Message对象，指定其what字段和数据
     * @param what 指定的what字段
     * @param pair 指定的数据
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(what: Int, pair: Pair<String, Any>): Message

    /**
     * 创建一个新的Message对象，指定其what字��、clientTag和数据
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @param pair 指定的数据
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(clientTag: String, what: Int, pair: Pair<String, Any>): Message

    /**
     * 创建一个新的Message对象，指定其数据
     *
     * @param message Message 旧的Message对象
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(message: Message): Message

    /**
     * 创建一个新的Message对象，指定其数据
     *
     * @param clientTag String 客户端标签
     * @param message Message 旧的Message对象
     * @return Message 新创建的Message对象
     */
    fun obtainMessage(clientTag: String, message: Message): Message

    /**
     * 设置Message的回复Messenger
     *
     * @param messenger 指定的Messenger
     * @return Message 设置了回复Messenger的Message对象
     */
    fun Message.replyTo(messenger: Messenger?): Message

    /**
     * 获取Message的clientTag
     * @return String Message的clientTag
     */
    fun Message.getClientTag(): String

    /**
     * 设置Message的clientTag
     *
     * @receiver Message
     * @return Message
     */
    fun Message.putClientTagIf(clientTag: String): Message

    /**
     * 是否有ClientTag字段
     *
     * @receiver Message
     * @return Boolean true 有 false 没有
     */
    fun Message.hasClientTag(): Boolean

    /**
     * 获取Message的cookies
     *
     * @return String Message的cookies
     */
    fun Message.getCookie(): String

    /**
     * 设置Message的cookies
     *
     * @receiver Message
     * @return Message
     */
    fun Message.putCookieIf(): Message


    /**
     * 是否有cookies字段
     *
     * @receiver Message
     * @return Boolean true 有 false 没有
     */
    fun Message.hasCookie(): Boolean

    /**
     *  将新的Message携带旧的Message部分信息发送给客户端
     *
     * @receiver Message
     * @param oldMessage Message
     * @return Message
     */
    fun Message.replyTo(oldMessage: Message): Message

    /**
     * 是否是同一条请求
     *
     * @receiver Message
     * @param otherMessage Message
     * @return Boolean
     */
    fun Message.isSame(otherMessage: Message): Boolean
}