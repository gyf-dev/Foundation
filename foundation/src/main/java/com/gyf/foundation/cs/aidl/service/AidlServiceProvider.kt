@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.aidl.service

import android.os.IBinder
import android.os.Message
import com.gyf.foundation.ICS
import com.gyf.foundation.ICSCallback
import com.gyf.foundation.cs.common.service.face.IService

/**
 * AidlServiceProvider类，实现了ICoroutine接口
 * @Author  Ifan.Ge
 * @Date    2024/6/21 18:13
 */
class AidlServiceProvider(iService: IService) : AbsAidlServiceProvider<ICSCallback>(iService) {
    /**
     * 绑定器
     */
    override val binder: IBinder = object : ICS.Stub() {

        override fun execute(clientTag: String?, message: Message?): Message? {
            if (clientTag.isNullOrBlank() || message == null) return null
            return serviceProcess.onExecute(clientTag, message)
        }

        override fun enqueue(clientTag: String?, message: Message?) {
            if (clientTag.isNullOrBlank() || message == null) return
            serviceProcess.onEnqueue(clientTag, message)
        }

        override fun registerCallback(clientTag: String?, callback: ICSCallback?) {
            if (clientTag.isNullOrBlank() || callback == null) return
            getCallbackList(clientTag).register(callback)
        }

        override fun unregisterCallback(clientTag: String?, callback: ICSCallback?) {
            if (clientTag.isNullOrBlank() || callback == null) return
            getCallbackList(clientTag).unregister(callback)
        }

        override fun removeAllCallbacks(clientTag: String?) {
            if (clientTag.isNullOrBlank()) return
            callbackMap[clientTag]?.kill()
            callbackMap.remove(clientTag)
        }
    }

    override fun responseOn(item: ICSCallback, clientTag: String, newMessage: Message) {
        item.onResponse(clientTag, newMessage)
    }
}