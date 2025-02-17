package com.gyf.foundation.cs.common.service.face

import android.os.Message

/**
 * IAidlRequestService接口
 * @Author  Ifan.Ge
 * @Date    2024/6/21 19:05
 */
interface IServiceProcess {

    /**
     * 用于处理客户端调用execute方法后，服务端收到的请求回调
     *
     * @param clientTag 客户端标签
     * @param message 客户端发来的消息
     * @return 返回处理后的消息给到客户端
     */
    fun onExecute(clientTag: String, message: Message): Message?

    /**
     * 异步方法，用于处理客户端的请求，服务端处理完成后选择是否调用response方法，把消息返回给客户端
     *
     * @param clientTag 客户端标签
     * @param message 客户端发来的消息
     */
    fun onEnqueue(clientTag: String, message: Message)
}