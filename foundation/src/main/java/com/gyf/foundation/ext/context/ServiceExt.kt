package com.gyf.foundation.ext.context

import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.core.content.ContextCompat

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/21 16:22
 */

/**
 * 启动指定服务的扩展函数。
 *
 * @return 启动的服务的Intent。
 */
inline fun <reified T> Context.startService(): Intent {
    val intent = Intent(this, T::class.java)
    startServiceCheckSystem(intent)
    return intent
}

/**
 * 通过action启动服务的扩展函数。
 *
 * @param action 服务的action。
 * @return 启动的服务的Intent，如果无法创建显式Intent，则返回null。
 */
fun Context.startService(action: String): Intent? {
    val intent = createExplicitIntent(Intent(action)) ?: return null
    startServiceCheckSystem(intent)
    return intent
}

/**
 * 检查系统并启动服务的扩展函数。
 *
 * @param intent 要启动的服务的Intent。
 */
fun Context.startServiceCheckSystem(intent: Intent) {
    if (isSystemApp) {
        startService(intent)
    } else {
        ContextCompat.startForegroundService(this, intent)
    }
}

/**
 * 启动多个action对应的服务的扩展函数。
 *
 * @param actions 服务的action数组。
 */
fun Context.startService(vararg actions: String) {
    actions.forEach { startService(it) }
}

/**
 * 绑定服务的扩展函数。
 *
 * @param action 服务的action。
 * @param connection 服务连接对象。
 * @return 如果成功启动并绑定服务，则返回true，否则返回false。
 */
fun Context.bindService(action: String, connection: ServiceConnection): Boolean {
    val intent = startService(action) ?: return false
    return bindService(intent, connection, Context.BIND_AUTO_CREATE)
}