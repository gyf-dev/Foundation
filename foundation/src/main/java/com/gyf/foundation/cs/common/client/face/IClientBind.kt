package com.gyf.foundation.cs.common.client.face

import android.content.Context

/**
 * IClientBind接口，定义了一系列与客户端绑定相关的方法
 * @Author  Ifan.Ge
 * @Date    2024/6/25 15:21
 */
interface IClientBind {

    /**
     * 是否已连接
     */
    val isConnected: Boolean

    /**
     * 创建客户端
     * @param context 上下文对象，通常为Activity或Application的实例
     */
    fun create(context: Context)

    /**
     * 销毁客户端
     * @param context 上下文对象，通常为Activity或Application的实例
     */
    fun destroy(context: Context)

    /**
     * 绑定客户端
     * @param context 上下文对象，通常为Activity或Application的实例
     * @param flags 绑定选项，用于控制绑定的行为
     */
    fun connect(context: Context, flags: Int)

    /**
     * 解绑客户端
     * @param context 上下文对象，通常为Activity或Application的实例
     */
    fun disconnect(context: Context)
}