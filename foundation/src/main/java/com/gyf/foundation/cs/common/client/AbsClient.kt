@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.common.client

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.os.Message
import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.gyf.foundation.Foundation
import com.gyf.foundation.cs.aidl.client.AidlClient
import com.gyf.foundation.cs.common.CsMessage
import com.gyf.foundation.cs.common.CsMessageQuick
import com.gyf.foundation.cs.common.client.callback.ClientCallback
import com.gyf.foundation.cs.common.client.callback.ClientCallback2
import com.gyf.foundation.cs.common.client.face.ClientProviderOwner
import com.gyf.foundation.cs.common.client.face.IClient
import com.gyf.foundation.cs.common.client.face.IClientGet
import com.gyf.foundation.cs.common.client.face.IClientGetQuick
import com.gyf.foundation.cs.common.client.face.IClientPost
import com.gyf.foundation.cs.common.client.face.IClientPost2
import com.gyf.foundation.cs.common.client.face.IClientPostQuick
import com.gyf.foundation.cs.common.client.face.IClientProvider
import com.gyf.foundation.cs.common.client.face.IClientRequest
import com.gyf.foundation.cs.common.face.IMessage
import com.gyf.foundation.cs.common.face.IMessageQuick
import com.gyf.foundation.cs.messenger.client.MessengerClient
import com.gyf.foundation.ext.clazz.isClassOf
import com.gyf.foundation.ext.coroutine.ICoroutine
import com.gyf.foundation.ext.intent.createExplicitIntent
import com.gyf.foundation.ext.log.log
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Messenger绑定客户端类。
 * 提供了一系列与Messenger通信的方法。
 *
 * @Author  Ifan.Ge
 * @Date    2024/5/10 14:16
 */
abstract class AbsClient : ContextWrapper(null),
    ClientProviderOwner,
    ClientCallback,
    IClientRequest,
    IClient,
    IMessage by CsMessage(),
    IMessageQuick by CsMessageQuick(),
    IClientPost by ClientPost(),
    IClientGet by ClientGet(),
    IClientPostQuick by ClientPostQuick(),
    IClientGetQuick by ClientGetQuick(),
    IClientPost2 by ClientPost2(),
    ICoroutine {


    /**
     * Client tag
     */
    var clientTag: String = ""
        private set

    private val clientCallbacks = CopyOnWriteArrayList<ClientCallback>()


    private val clientCallback2s = CopyOnWriteArrayList<ClientCallback2>()

    /**
     * 提供者
     */
    override lateinit var provider: IClientProvider

    /**
     * 是否已初始化
     */
    private val isProviderInitialized: Boolean
        get() = ::provider.isInitialized

    /**
     * 是否已连接服务
     */
    override val isConnected: Boolean
        get() = if (isProviderInitialized) provider.isConnected else false

    /**
     * 额外数据
     * Extra
     */
    var extra: Bundle? = null

    /**
     * 初始化
     *
     * @param intent Intent对象
     * @param clientTag 客户端标签
     */
    fun init(intent: Intent, clientTag: String = this::class.java.name) = apply {
        validateClientTag(clientTag)
        this.clientTag = clientTag
        _clientTag = clientTag
        provider = getProvider(clientTag, intent, this)
        _postClientProvider = provider
        _getClientProvider = provider
        _postAbsClient = this
        _postQuickAbsClient = this
        _getQuickAbsClient = this
    }

    /**
     * 验证客户端标签
     *
     * @param clientTag String 客户端标签
     */
    private fun validateClientTag(clientTag: String) {
        if (clientTag.isBlank()) {
            throw IllegalArgumentException("clientTag can not be blank")
        }
        if (clientTag in Foundation.invalidClientTagS) {
            throw IllegalArgumentException("clientTag[$clientTag] is invalid, please specify another clientTag")
        }
    }

    /**
     * 添加客户端回调
     *
     * @param callback ClientCallback
     */
    fun addClientCallback(callback: ClientCallback) = apply {
        clientCallbacks += callback
    }

    /**
     * 移除客户端回调
     *
     * @param callback ClientCallback
     */
    fun removeClientCallback(callback: ClientCallback) = apply {
        clientCallbacks -= callback
    }

    /**
     * 添加客户端回调
     *
     * @param callback ClientCallback2
     */
    fun addClientCallback(callback: ClientCallback2) = apply {
        clientCallback2s += callback
    }

    /**
     * 移除客户端回调
     *
     * @param callback ClientCallback2
     */
    fun removeClientCallback(callback: ClientCallback2) = apply {
        clientCallback2s -= callback
    }

    /**
     * 创建
     *
     * Create
     */
    final override fun create() {
        checkProvider()
        provider.create(applicationContext)
    }

    /**
     * 绑定服务
     *
     * @param flags 绑定标志
     */
    final override fun connect(flags: Int) {
        checkProvider()
        provider.connect(applicationContext, flags)
    }

    /**
     * 解绑服务
     *
     * Unbind
     *
     */
    final override fun disconnect() {
        checkProvider()
        provider.disconnect(applicationContext)
    }

    /**
     * 销毁
     *
     * Destroy
     */
    final override fun destroy() {
        checkProvider()
        provider.destroy(applicationContext)
    }


    /**
     * 聚合
     *
     * @param base Context 基础上下文
     * @param flags Int 绑定标志
     * @param clientTag String 客户端标签
     * @param intent Intent 意图
     * @param block AbsClient.() -> Unit 代码块
     */
    @JvmOverloads
    fun polymerization(
        base: Context,
        intent: Intent,
        clientTag: String = this::class.java.name,
        flags: Int = Context.BIND_AUTO_CREATE,
        block: (AbsClient.() -> Unit)? = null,
    ) = apply {
        attachBaseContext(base)
        init(intent, clientTag)
        create()
        block?.invoke(this)
        connect(flags)
    }

    /**
     * 检查提供者
     */
    private fun checkProvider() {
        if (!isProviderInitialized) throw IllegalStateException("Provider is not initialized")
    }

    @CallSuper
    public override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base.applicationContext)
        if (base is LifecycleOwner) {
            base.lifecycle.addObserver(this)
        }
    }

    /**
     * 声明周期
     *
     * @param source LifecycleOwner 生命周期所有者
     * @param event Event 生命周期事件
     */
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        super.onStateChanged(source, event)
        when (event) {
            Lifecycle.Event.ON_DESTROY -> destroy()
            else -> {
            }
        }
    }

    /**
     * 当创建时调用
     */
    @CallSuper
    override fun onCreate(clientTag: String) {
        for (callback in clientCallbacks) {
            callback.onCreate(clientTag)
        }
        for (callback in clientCallback2s) {
            callback.onCreate(this, clientTag)
        }
    }

    /**
     * 当销毁时调用
     */
    @CallSuper
    override fun onDestroy(clientTag: String) {
        for (callback in clientCallbacks) {
            callback.onDestroy(clientTag)
        }
        for (callback in clientCallback2s) {
            callback.onDestroy(this, clientTag)
        }
    }

    /**
     * 当连接成功时调用
     * @param clientTag 客户端标签
     */
    @CallSuper
    override fun onConnected(clientTag: String) {
        connectedClients[clientTag] = this
        for (callback in clientCallbacks) {
            callback.onConnected(clientTag)
        }
        for (callback in clientCallback2s) {
            callback.onConnected(this, clientTag)
        }
    }

    /**
     * 当连接断开时调用
     * @param clientTag 客户端标签
     */
    @CallSuper
    override fun onDisconnected(clientTag: String) {
        connectedClients.remove(clientTag)
        clients.remove(clientTag)
        for (callback in clientCallbacks) {
            callback.onDisconnected(clientTag)
        }
        for (callback in clientCallback2s) {
            callback.onDisconnected(this, clientTag)
        }
    }

    /**
     * 当接收到消息时调用
     * @param clientTag 客户端标签
     * @param message 消息
     */
    @CallSuper
    override fun onResponse(clientTag: String, message: Message) {
        for (callback in clientCallbacks) {
            callback.onResponse(clientTag, message)
        }
        for (callback in clientCallback2s) {
            callback.onResponse(this, clientTag, message)
        }
    }

    /**
     * 执行方法，用于处理客户端的请求，并返回处理后的消息���客户端
     * Execute method, used to handle client requests and return the processed message to the client
     *
     * @param message 客户端发来的消息
     *                The message sent by the client
     * @return Message? 返回处理后的消息给到客户端
     *                  Return the processed message to the client
     */
    override fun execute(message: Message): Message? {
        return provider.execute(message)
    }

    /**
     * 入队方法，用于处理客户端的请求，但不返回任何消息给客户端
     * Enqueue method, used to handle client requests, but does not return any messages to the client
     *
     * @param message 客户端发来的消息
     *                The message sent by the client
     */
    override fun enqueue(message: Message) {
        provider.enqueue(message)
    }

    companion object {

        /**
         * 已经绑定的所有集合
         *
         * Bounds
         */
        val connectedClients = ConcurrentHashMap<String, AbsClient>()


        val clients = ConcurrentHashMap<String, AbsClient>()

        /**
         * 绑定服务
         *
         * @param context 上下文
         * @param clientTag 客户端标签
         * @param action 动作
         * @param block AbsClient.() -> Unit 代码块
         */
        @JvmOverloads
        inline fun <reified C : AbsClient> connectService(
            context: Context,
            action: String,
            clientTag: String = C::class.java.name,
            flags: Int = Context.BIND_AUTO_CREATE,
            noinline block: (AbsClient.() -> Unit)? = null,
        ): C = connectService<C>(
            context,
            Intent(action).createExplicitIntent(context)
                ?: throw IllegalArgumentException("action is invalid"),
            clientTag,
            flags,
            block
        )

        /**
         * 绑定服务
         *
         * @param context 上下文
         * @param intent Intent对象
         * @param clientTag 客户端标签
         * @param block AbsClient.() -> Unit 代码块
         */
        inline fun <reified C : AbsClient> connectService(
            context: Context,
            intent: Intent,
            clientTag: String = C::class.java.name,
            flags: Int = Context.BIND_AUTO_CREATE,
            noinline block: (AbsClient.() -> Unit)? = null,
        ): C {
            val isAidl =
                C::class.java.isClassOf(AidlClient::class.java)
            val isMessenger =
                C::class.java.isClassOf(MessengerClient::class.java)
            if (isAidl || isMessenger) {
                return if (connectedClients.containsKey(clientTag)) {
                    "The client clientTag:[$clientTag] has been connected".log("AbsClient")
                    connectedClients[clientTag] as C
                } else {
                    val appContext = context.applicationContext
                    (C::class.java.getDeclaredConstructor().newInstance()
                        .polymerization(appContext, intent, clientTag, flags, block) as C).also {
                        clients[clientTag] = it
                    }
                }
            } else {
                throw IllegalArgumentException("The service type does not match the client type")
            }
        }
    }
}