package com.gyf.foundation.cs.common.service.face

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 9:49
 */
interface IServiceBound {
    /**
     * 当客户端绑定成功时调用
     *
     * @param clientTag 客户端标签
     */
    fun onBound(clientTag: String)

    /**
     * 当客户端解绑成功时调用
     *
     * @param clientTag 客户端标签
     */
    fun onUnbound(clientTag: String)
}