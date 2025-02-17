package com.gyf.foundation.cs.common.client.face

import android.os.Message

/**
 * IClientRequest接口
 * @Author  Ifan.Ge
 * @Date    2024/6/25 10:53
 */
interface IClientRequest {

    /**
     * 执行方法，用于处理客户端的请求，并返回处理后的消息���客户端
     * Execute method, used to handle client requests and return the processed message to the client
     *
     * @param message 客户端发来的消息
     *                The message sent by the client
     * @return Message? 返回处理后的消息给到客户端
     *                  Return the processed message to the client
     */
    fun execute(message: Message): Message?

    /**
     * 入队方法，用于处理客户端的请求，但不返回任何消息给客户端
     * Enqueue method, used to handle client requests, but does not return any messages to the client
     *
     * @param message 客户端发来的消息
     *                The message sent by the client
     */
    fun enqueue(message: Message)
}