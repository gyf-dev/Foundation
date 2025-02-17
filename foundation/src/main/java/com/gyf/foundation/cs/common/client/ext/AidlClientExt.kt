package com.gyf.foundation.cs.common.client.ext

import android.content.Context
import android.content.Intent
import com.gyf.foundation.cs.aidl.client.AidlClient
import com.gyf.foundation.cs.aidl.service.AidlService
import com.gyf.foundation.cs.common.client.AbsClient
import com.gyf.foundation.cs.common.client.AbsClient.Companion.connectedClients
import com.gyf.foundation.cs.common.service.AbsService
import com.gyf.foundation.cs.messenger.client.MessengerClient
import com.gyf.foundation.cs.messenger.service.MessengerService

/**
 * 客户端扩展类
 * Client extension class
 */


/**
 * 绑定服务
 * Bind service
 *
 * @param clientTag 客户端标签
 *                  Client tag
 * @param action 动作
 *                Action
 * @param block AbsClient.() -> Unit 代码块
 *            Code block
 * @return C 返回绑定的服务
 *          Return the bound service
 */
@JvmOverloads
inline fun <reified C : AbsClient> Context.connectService(
    action: String,
    clientTag: String = C::class.java.name,
    flags: Int = Context.BIND_AUTO_CREATE,
    noinline block: (AbsClient.() -> Unit)? = null,
): C = AbsClient.connectService<C>(this, action, clientTag, flags, block)

/**
 * 绑定服务
 * Bind service
 *
 * @param clientTag 客户端标签
 *                  Client tag
 * @param intent 意图
 *               Intent
 * @param block AbsClient.() -> Unit 代码块
 *              Code block
 * @return C 返回绑定的服务
 *          Return the bound service
 */
@JvmOverloads
inline fun <reified C : AbsClient> Context.connectService(
    intent: Intent,
    clientTag: String = C::class.java.name,
    flags: Int = Context.BIND_AUTO_CREATE,
    noinline block: (AbsClient.() -> Unit)? = null,
): C = AbsClient.connectService<C>(this, intent, clientTag, flags, block)

/**
 * 绑定服务
 * Bind service
 *
 * @param clientTag 客户端标签
 *                  Client tag
 * @param block AbsClient.() -> Unit 代码块
 *              Code block
 * @return C 返回绑定的服务
 *          Return the bound service
 */
@JvmOverloads
inline fun <reified C : AbsClient, reified S : AbsService> Context.connectServiceByClass(
    clientTag: String = C::class.java.name,
    flags: Int = Context.BIND_AUTO_CREATE,
    noinline block: (AbsClient.() -> Unit)? = null,
): C = AbsClient.connectService<C>(
    this, Intent(this, S::class.java), clientTag, flags, block
)

/**
 * 绑定Aidl服务
 * Bind Aidl service
 *
 * @param clientTag 客户端标签
 *                  Client tag
 * @param block AbsClient.() -> Unit 代码块
 *              Code block
 * @return AidlClient 返回绑定的Aidl服务
 *                    Return the bound Aidl service
 */
@JvmOverloads
inline fun <reified S : AidlService> Context.connectAidlService(
    clientTag: String,
    flags: Int = Context.BIND_AUTO_CREATE,
    noinline block: (AbsClient.() -> Unit)? = null,
): AidlClient =
    AbsClient.connectService<AidlClient>(
        this,
        Intent(this, S::class.java),
        clientTag,
        flags,
        block
    )

/**
 * 绑定Messenger服务
 * Bind Messenger service
 *
 * @param clientTag 客户端标签
 *                  Client tag
 * @param block AbsClient.() -> Unit 代码块
 *              Code block
 * @return MessengerClient 返回绑定的Messenger服务
 *                         Return the bound Messenger service
 */
@JvmOverloads
inline fun <reified S : MessengerService> Context.connectMessengerService(
    clientTag: String,
    flags: Int = Context.BIND_AUTO_CREATE,
    noinline block: (AbsClient.() -> Unit)? = null,
): MessengerClient = AbsClient.connectService<MessengerClient>(
    this,
    Intent(this, S::class.java),
    clientTag,
    flags,
    block
)

/**
 * 解绑服务
 *
 * @param clientTag 客户端标签
 */
fun disconnectService(clientTag: String) {
    connectedClients[clientTag]?.disconnect()
}

/**
 * 销毁服务
 *
 * @param clientTag 客户端标签
 */
fun destroyService(clientTag: String) {
    connectedClients[clientTag]?.destroy()
}