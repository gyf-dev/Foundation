package com.gyf.foundation.cs.common.client.callback

import android.os.Message

/**
 * IAidlClient接口
 * @Author  Ifan.Ge
 * @Date    2024/6/21 19:05
 */
interface ClientCallback {

    /**
     * 当创建时调用
     *
     * @param clientTag 客户端标签
     */
    fun onCreate(clientTag: String) {}

    /**
     * 当销毁时调用
     *
     * @param clientTag 客户端标签
     */
    fun onDestroy(clientTag: String) {}

    /**
     * 当连接成功时调用
     *
     * @param clientTag 客户端标签
     */
    fun onConnected(clientTag: String) {}

    /**
     * 当连接断开时调用
     *
     * @param clientTag 客户端标签
     */
    fun onDisconnected(clientTag: String) {}

    /**
     * 当接收到消息时调用
     *
     * @param clientTag 客户端标签
     * @param message 消息
     */
    fun onResponse(clientTag: String, message: Message) {}
}