@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.common.service

import android.content.Intent
import android.os.IBinder
import android.os.Message
import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleService
import com.gyf.foundation.cs.common.CsMessage
import com.gyf.foundation.cs.common.CsMessageQuick
import com.gyf.foundation.cs.common.face.IMessage
import com.gyf.foundation.cs.common.face.IMessageQuick
import com.gyf.foundation.cs.common.service.face.IService
import com.gyf.foundation.cs.common.service.face.IServiceGet
import com.gyf.foundation.cs.common.service.face.IServicePost
import com.gyf.foundation.cs.common.service.face.IServiceResponse
import com.gyf.foundation.cs.common.service.face.ServiceProviderOwner
import com.gyf.foundation.ext.coroutine.ICoroutine
import com.gyf.foundation.ext.service.createNotificationIfNeed

/**
 * AidlService类，继承自LifecycleService，实现了ICoroutine和IService接口
 * @Author  Ifan.Ge
 * @Date    2024/6/21 18:04
 */
abstract class AbsService : LifecycleService(),
    ServiceProviderOwner,
    IService,
    IServiceResponse,
    IMessage by CsMessage(),
    IMessageQuick by CsMessageQuick(),
    IServicePost by ServicePost(),
    IServiceGet by ServiceGet(),
    ICoroutine {

    /**
     * onBind方法，绑定服务时调用
     *
     * @param intent Intent
     * @return IBinder
     */
    final override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)
        return provider.binder
    }

    /**
     * onCreate方法，当创建时调用
     */
    @CallSuper
    override fun onCreate() {
        super.onCreate()
        _postServiceProvider = provider
        _getServiceProvider = provider
        lifecycle.addObserver(provider)
        createNotificationIfNeed(android.R.drawable.ic_dialog_info)
        "onCreate".log
    }

    /**
     * 当客户端绑定成功时调用
     *
     * @param clientTag 客户端标签
     */
    override fun onBound(clientTag: String) {

    }

    /**
     * 当客户端解绑成功时调用
     *
     * @param clientTag 客户端标签
     */
    override fun onUnbound(clientTag: String) {

    }

    /**
     * 用于处理客户端调用execute方法后，服务端收到的请求回调
     *
     * @param clientTag 客户端标签
     * @param message 客户端发来的消息
     * @return 返回处理后的消息给到客户端
     */
    override fun onExecute(clientTag: String, message: Message): Message? {
        return null
    }

    /**
     * 异步方法，用于处理客户端的请求，服务端处理完成后选择是否调用response方法，把消息返回给客户端
     *
     * @param clientTag 客户端标签
     * @param message 客户端发来的消息
     */
    override fun onEnqueue(clientTag: String, message: Message) {

    }

    /**
     * 给客户端发消息
     *
     * @param clientTag String 客户端标签
     * @param newMessage Message 消息
     */
    override fun response(clientTag: String, newMessage: Message) {
        provider.response(clientTag, newMessage)
    }

    /**
     * 给所有客户端发消息
     *
     * @param newMessage Message 消息
     */
    override fun response(newMessage: Message) {
        provider.response(newMessage)
    }
}