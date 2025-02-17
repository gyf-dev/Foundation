package com.gyf.foundation.ext.intent

import android.content.ComponentName
import android.content.Context
import android.content.Intent

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/21 16:24
 */

/**
 * 创建显式Intent的扩展函数。
 *
 * @param context 上下文对象。
 * @return 显式Intent，如果无法创建显式Intent，则返回null。
 */
fun Intent.createExplicitIntent(context: Context): Intent? {
    // 查询可以匹配给定Intent的所有服务
    val pm = context.packageManager
    val resolveInfo = pm.queryIntentServices(this, 0)

    // 确保只找到一个匹配项
    if (resolveInfo.size != 1) {
        return null
    }

    // 获取组件信息并创建ComponentName
    val serviceInfo = resolveInfo[0] //得到对应的Intent，因为只有一个所以索引为0
    val packageName = serviceInfo.serviceInfo.packageName //得到其包名
    val className = serviceInfo.serviceInfo.name //得到其类名
    val component = ComponentName(packageName, className)

    // 创建一个新的Intent。使用旧的Intent进行额外的复用
    val explicitIntent = Intent(this) //使用原Intent创建

    // 设置组件以明确
    explicitIntent.setComponent(component) //设置component,创建明确的Intent

    return explicitIntent
}