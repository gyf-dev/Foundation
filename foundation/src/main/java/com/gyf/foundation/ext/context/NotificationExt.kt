package com.gyf.foundation.ext.context

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/21 16:27
 */

/**
 * 创建通知的扩展函数。
 *
 * @param icon 通知的图标。
 * @param id 通知的ID，默认为1到Int.MAX_VALUE的随机数。
 * @param title 通知的标题，默认为调用此函数的类的简单名称。
 * @param text 通知的文本内容，默认为调用此函数的类的简单名称。
 * @param channelId 通知频道的ID，默认为调用此函数的类的简单名称。
 * @param channelName 通知频道的名称，默认为调用此函数的类的简单名称。
 * @return 创建的通知。
 */
fun Context.createNotification(
    @DrawableRes icon: Int,
    id: Int = Random.nextInt(1, Int.MAX_VALUE),
    title: String = this::class.java.simpleName,
    text: String = this::class.java.simpleName,
    channelId: String = this::class.java.simpleName,
    channelName: String = this::class.java.simpleName
): Notification {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val notificationManager = getSystemService(
            NotificationManager::class.java
        )
        notificationManager.createNotificationChannel(channel)
    }

    val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, channelId)
        .setSmallIcon(icon)
        .setContentTitle(title)
        .setContentText(text)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    val notification = builder.build()

    val notificationManager = NotificationManagerCompat.from(this)
    if (ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        notificationManager.notify(id, notification)
    }
    return notification
}