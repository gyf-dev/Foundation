package com.gyf.foundation.cs.common.client.callback

import android.os.Message
import com.gyf.foundation.cs.common.client.AbsClient

/**
 * IAidlClient接口
 * @Author  Ifan.Ge
 * @Date    2024/6/21 19:05
 */
interface ClientCallback2 {

    /**
     * 当创建时调用
     *
     * @param clientTag 客户端标签
     */
    fun onCreate(client: AbsClient, clientTag: String) {}


    /**
     * 当销毁时调用
     *
     * @param clientTag 客户端标签
     */
    fun onDestroy(client: AbsClient, clientTag: String) {}

    /**
     * 当连接成功时调用
     *
     * @param clientTag 客户端标签
     */
    fun onConnected(client: AbsClient, clientTag: String) {}

    /**
     * 当连接断开时调用
     *
     * @param clientTag 客户端标签
     */
    fun onDisconnected(client: AbsClient, clientTag: String) {}

    /**
     * 当接收到消息时调用
     *
     * @param clientTag 客户端标签
     * @param message 消息
     */
    fun onResponse(client: AbsClient, clientTag: String, message: Message) {}
}