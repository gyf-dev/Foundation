package com.gyf.foundation.cs.common.face

import android.os.Bundle
import android.os.Message

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/2 15:03
 */
interface IPost2 {
    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其what字段
     * @param what 指定的what字段
     */
    fun post(what: Int, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其what字段和clientTag
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     */
    fun post(clientTag: String, what: Int, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其数据
     * @param bundle 指定的数据
     */
    fun post(bundle: Bundle, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其what字段和数据
     * @param what 指定的what字段
     * @param bundle 指定的数据
     */
    fun post(what: Int, bundle: Bundle, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其what字段、clientTag和数据
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @param bundle 指定的数据
     */
    fun post(clientTag: String, what: Int, bundle: Bundle, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其数据
     * @param pair 指定的数据
     */
    fun post(pair: Pair<String, Any>, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其what字段和数据
     * @param what 指定的what字段
     * @param pair 指定的数据
     */
    fun post(what: Int, pair: Pair<String, Any>, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其what字��、clientTag和数据
     * @param clientTag 客户端标签
     * @param what 指定的what字段
     * @param pair 指定的数据
     */
    fun post(clientTag: String, what: Int, pair: Pair<String, Any>, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其数据
     *
     * @param message Message 旧的Message对象
     */
    fun post(message: Message, result: (Message) -> Unit)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其数据
     *
     * @param clientTag String 客户端标签
     * @param message Message 旧的Message对象
     */
    fun post(clientTag: String, message: Message, result: (Message) -> Unit)
}