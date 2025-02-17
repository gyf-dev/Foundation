package com.gyf.foundation.sample.page

import com.gyf.foundation.cs.common.client.AbsClient
import com.gyf.foundation.cs.common.client.callback.ClientCallback2
import com.gyf.foundation.cs.common.client.ext.connectAidlService
import com.gyf.foundation.cs.common.client.ext.connectMessengerService
import com.gyf.foundation.ext.message.MessageExt.toStringExt
import com.gyf.foundation.ext.toast.toast
import com.gyf.foundation.sample.CommonFragment
import com.gyf.foundation.sample.cs.aidl.MyAidlService
import com.gyf.foundation.sample.cs.messenger.MyMessengerService
import com.gyf.foundation.sample.replaceFragment

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/28 14:14
 */

private var aidlClient: AbsClient? = null

private var messengerClient: AbsClient? = null

private val aidlClientCallback = object : ClientCallback2 {

    override fun onConnected(client: AbsClient, clientTag: String) {
        "onConnected clientTag: $clientTag".toast

        if (aidlClient?.clientTag == clientTag) {
            client.apply {
                getQuick(100, "你好Aidl服务端，我是客户端，同步100").also {
                    "get result: ${it.toStringExt()}".log
                }
                postQuick(200, "你好Aidl服务端，我是客户端，异步200")
                postQuick(400, "你好Aidl服务端，我是客户端，异步400") {
                    "post result: ${it.toStringExt()}".log
                }
            }
        }

        if (messengerClient?.clientTag == clientTag) {
            client.postQuick(300, "你好Messenger服务端，我是客户端，异步300")
        }
    }
}

fun CommonFragment.cs() {
    replaceFragment(listOf("Aidl-Bind", "Aidl-Unbind", "Messenger-Bind", "Messenger-Unbind")) {
        when (it) {
            0 -> {
                aidlClient =
                    requireContext().connectAidlService<MyAidlService>(MyAidlService::class.java.name) {
                        addClientCallback(aidlClientCallback)
                    }
            }

            1 -> aidlClient?.disconnect()

            2 -> {
                messengerClient =
                    requireContext().connectMessengerService<MyMessengerService>(MyMessengerService::class.java.name) {
                        addClientCallback(aidlClientCallback)
                    }
            }

            3 -> messengerClient?.disconnect()
        }
    }
}