package com.gyf.foundation.cs.common.face

import android.os.Bundle
import android.os.Message

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/2 15:03
 */
interface IGet {
    /**
     * 获取服务端的消息，指定其what字段
     * @param what 指定的what字段
     * @return Message 服务端的消息
     */
    fun get(what: Int): Message?

    /**
     * 获取服务端的消息，指定其what字段和clientTag
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @return Message 服务端的消息
     */
    fun get(clientTag: String, what: Int): Message?

    /**
     * 获取服务端的消息，指定其数据
     * @param bundle 指定的数据
     * @return Message 服务端的消息
     */
    fun get(bundle: Bundle): Message?

    /**
     * 获取服务端的消息，指定其what字段和数据
     * @param what 指定的what字段
     * @param bundle 指定的数据
     * @return Message 服务端的消息
     */
    fun get(what: Int, bundle: Bundle): Message?

    /**
     * 获取服务端的消息，指定其what字段、clientTag和数据
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @param bundle 指定的数据
     * @return Message 服务端的消息
     */
    fun get(clientTag: String, what: Int, bundle: Bundle): Message?

    /**
     * 获取服务端的消息，指定其数据
     * @param pair 指定的数据
     * @return Message 服务端的消息
     */
    fun get(pair: Pair<String, Any>): Message?

    /**
     * 获取服务端的消息，指定其what字段和数据
     * @param what 指定的what字段
     * @param pair 指定的数据
     * @return Message 服务端的消息
     */
    fun get(what: Int, pair: Pair<String, Any>): Message?

    /**
     * 获取服务端的消息，指定其what字��、clientTag和数据
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @param pair 指定的数据
     * @return Message 服务端的消息
     */
    fun get(clientTag: String, what: Int, pair: Pair<String, Any>): Message?

    /**
     * 获取服务端的消息，指定其数据
     *
     * @param message Message 旧的Message对象
     * @return Message 服务端的消息
     */
    fun get(message: Message): Message?

    /**
     * 获取服务端的消息，指定其数据
     *
     * @param clientTag String 客户端标签
     * @param message Message 旧的Message对象
     * @return Message 服务端的消息
     */
    fun get(clientTag: String, message: Message): Message?
}