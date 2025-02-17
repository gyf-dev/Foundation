@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.aidl.client

import android.content.Intent
import com.gyf.foundation.cs.common.client.AbsClient
import com.gyf.foundation.cs.common.client.callback.ClientCallback
import com.gyf.foundation.cs.common.client.face.IClientProvider

/**
 * AidlClient类，继承自ContextWrapper，实现了IAidlClient和ICoroutine接口
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/24 11:40
 */
open class AidlClient : AbsClient() {

    override fun getProvider(
        clientTag: String,
        intent: Intent,
        client: ClientCallback
    ): IClientProvider {
        return AidlClientProvider(clientTag, intent, client)
    }
}