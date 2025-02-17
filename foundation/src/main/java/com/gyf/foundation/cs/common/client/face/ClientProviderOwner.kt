package com.gyf.foundation.cs.common.client.face

import android.content.Intent
import com.gyf.foundation.cs.common.client.callback.ClientCallback

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/3 10:49
 */
interface ClientProviderOwner {

    val provider: IClientProvider

    /**
     * 获取客户端提供者
     * @param clientTag 客户端标签
     * @param intent 意图
     * @param client 客户端回调
     */
    fun getProvider(
        clientTag: String,
        intent: Intent,
        client: ClientCallback
    ): IClientProvider
}