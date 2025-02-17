package com.gyf.foundation.cs.common.client.face

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/3 9:35
 */
interface IClient {
    /**
     * 是否已连接
     */
    val isConnected: Boolean

    /**
     * 创建客户端
     */
    fun create()

    /**
     * 销毁客户端
     */
    fun destroy()

    /**
     * 绑定客户端
     * @param flags 绑定选项，用于控制绑定的行为
     */
    fun connect(flags: Int)

    /**
     * 解绑客户端
     */
    fun disconnect()
}