package com.gyf.foundation.cs.aidl.client

import android.content.Intent
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import com.gyf.foundation.ICS
import com.gyf.foundation.ICSCallback
import com.gyf.foundation.cs.common.client.AbsClientProvider
import com.gyf.foundation.cs.common.client.callback.ClientCallback

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 16:23
 */
class AidlClientProvider(
    clientTag: String,
    intent: Intent,
    clientCallback: ClientCallback,
) : AbsClientProvider<ICS>(clientTag, intent, clientCallback) {

    override val clientMessenger: Messenger? = null

    /**
     * ICS回调接口实现
     */
    private val callback: ICSCallback = object : ICSCallback.Stub() {

        override fun onResponse(clientTag: String, message: Message) {
            client.onResponse(clientTag, message)
        }
    }

    override fun connect(iBinder: IBinder?): ICS {
        val ics = ICS.Stub.asInterface(iBinder)
        ics.registerCallback(clientTag, callback)
        return ics
    }

    override fun disconnect() {
        service?.removeAllCallbacks(clientTag)
    }

    override fun executeMessage(message: Message): Message? {
        return service?.execute(clientTag, message)
    }

    override fun enqueueMessage(message: Message) {
        service?.enqueue(clientTag, message)
    }
}