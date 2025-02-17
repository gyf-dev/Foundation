@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.messenger.client

import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import com.gyf.foundation.cs.common.client.AbsClientProvider
import com.gyf.foundation.cs.common.client.callback.ClientCallback

/**
 * @Author  Ifan.Ge
 * @Date    2024/5/23 14:36
 */

/**
 * Messenger客户端提供者类。
 *
 * 提供了一系列与Messenger通信的方法。
 */
open class MessengerClientProvider(
    clientTag: String,
    intent: Intent,
    clientCallback: ClientCallback,
) : AbsClientProvider<Messenger>(clientTag, intent, clientCallback) {

    override val clientMessenger: Messenger = Messenger(object : Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val tag = msg.getClientTag()
            if (tag.isBlank()) return
            client.onResponse(clientTag, msg)
        }

    })

    override fun connect(iBinder: IBinder?): Messenger {
        return Messenger(iBinder)
    }

    override fun disconnect() {

    }

    override fun executeMessage(message: Message): Message? {
        throw UnsupportedOperationException("Not supported,MessengerClient type does not support execute/get, please use enqueue/post)")
    }

    override fun enqueueMessage(message: Message) {
        message.sendTry()
    }

    private fun Message.sendTry() {
        try {
            service?.send(this)
        } catch (e: RemoteException) {
            "sendTry ${e.message}".log
        }
    }
}