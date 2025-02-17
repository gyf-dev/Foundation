package com.gyf.foundation.cs.common.face

import android.os.Bundle
import android.os.Message

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/2 15:03
 */
interface IReplyPost {

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其数据
     *
     * @receiver clientMessage Message 旧的Message对象
     * @param bundle 指定的数据
     */
    fun Message.replyPost(bundle: Bundle)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其数据
     *
     * @receiver clientMessage Message 旧的Message对象
     * @param pair 指定的数据
     */
    fun Message.replyPost(pair: Pair<String, Any>)

    /**
     * 对于客户端异步获取服务端消息，消息将通过onResponse接口返回
     * 对于服务端，消息通过response发送给客户端，指定其数据
     *
     * @receiver clientMessage Message 旧的Message对象
     * @param message Message 旧的Message对象
     */
    fun Message.replyPost(message: Message)
}