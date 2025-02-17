package com.gyf.foundation.cs.aidl.service

import android.os.IInterface
import android.os.Message
import android.os.RemoteCallbackList
import android.os.RemoteException
import com.gyf.foundation.cs.common.service.AbsServiceProvider
import com.gyf.foundation.cs.common.service.face.IService
import java.util.concurrent.ConcurrentHashMap

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 19:04
 */
abstract class AbsAidlServiceProvider<C : IInterface>(iService: IService) :
    AbsServiceProvider(iService) {

    /**
     * 回调映射
     */
    protected val callbackMap = ConcurrentHashMap<String, RemoteCallbackList<C>>()

    /**
     * 获取回调列表
     */
    protected fun getCallbackList(clientTag: String): RemoteCallbackList<C> {
        return callbackMap.getOrPut(clientTag) { RemoteCallbackList<C>() }
    }

    override fun responseMessage(clientTag: String, newMessage: Message) {
        val callbackList = getCallbackList(clientTag)
        var i = callbackList.beginBroadcast()
        try {
            while (i > 0) {
                i--
                try {
                    val item = callbackList.getBroadcastItem(i)
                    responseOn(item, clientTag, newMessage.putClientTagIf(clientTag))
                } catch (_: RemoteException) {
                }
            }
        } finally {
            callbackList.finishBroadcast()
        }
    }

    override fun responseMessage(newMessage: Message) {
        callbackMap.forEach { (t, u) -> responseMessage(t, newMessage) }
    }


    abstract fun responseOn(item: C, clientTag: String, newMessage: Message)
}