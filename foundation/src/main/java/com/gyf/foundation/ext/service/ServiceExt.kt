package com.gyf.foundation.ext.service

import android.app.Service
import android.content.pm.ServiceInfo
import android.os.Build
import androidx.annotation.DrawableRes
import com.gyf.foundation.ext.context.createNotification
import com.gyf.foundation.ext.context.isSystemApp
import kotlin.random.Random

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/21 16:31
 */

/**
 * 如果需要，创建通知的扩展函数。
 *
 * @param icon 通知的图标。
 * @param id 通知的ID，默认为1到Int.MAX_VALUE的随机数。
 * @param title 通知的标题，默认为调用此函数的类的简单名称。
 * @param text 通知的文本内容，默认为调用此函数的类的简单名称。
 * @param channelId 通知频道的ID，默认为调用此函数的类的简单名称。
 * @param channelName 通知频道的名称，默认为调用此函数的类的简单名称。
 */
fun Service.createNotificationIfNeed(
    @DrawableRes icon: Int,
    id: Int = Random.nextInt(1, Int.MAX_VALUE),
    title: String = this::class.java.simpleName,
    text: String = this::class.java.simpleName,
    channelId: String = this::class.java.simpleName,
    channelName: String = this::class.java.simpleName
) {
    if (isSystemApp) {
        return
    }
    val createNotification = createNotification(icon, id, title, text, channelId, channelName)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        startForeground(
            id, createNotification,
            ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
        )
    } else {
        startForeground(id, createNotification)
    }
}