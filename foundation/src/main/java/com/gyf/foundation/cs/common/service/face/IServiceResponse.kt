package com.gyf.foundation.cs.common.service.face

import android.os.Message

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 10:00
 */
interface IServiceResponse {

    /**
     * 给客户端发消息
     *
     * @param clientTag String 客户端标签
     * @param newMessage Message 消息
     */
    fun response(clientTag: String, newMessage: Message)

    /**
     * 给所有客户端发消息
     *
     * @param newMessage Message 消息
     */
    fun response(newMessage: Message)
}