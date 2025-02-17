package com.gyf.foundation.cs.messenger.client

import android.content.Intent
import com.gyf.foundation.cs.common.client.AbsClient
import com.gyf.foundation.cs.common.client.callback.ClientCallback
import com.gyf.foundation.cs.common.client.face.IClientProvider

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 11:26
 */
open class MessengerClient : AbsClient() {

    override fun getProvider(
        clientTag: String,
        intent: Intent,
        client: ClientCallback
    ): IClientProvider = MessengerClientProvider(clientTag, intent, client)
}