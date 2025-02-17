package com.gyf.foundation.ext.context

import android.app.ActivityManager
import android.content.Context
import android.os.Process

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/21 16:26
 */

/**
 * 当前进程名称的扩展属性。
 *
 * @return 当前进程的名称。
 */
val Context.currentProcessName: String
    get() {
        val pid = Process.myPid()
        var processName = ""
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (process in activityManager.runningAppProcesses) {
            if (process.pid == pid) {
                processName = process.processName
            }
        }
        return processName
    }

/**
 * 是否为主进程的扩展属性。
 *
 * @return 如果当前进程是主进程，则返回true，否则返回false。
 */
val Context.isMainProcess: Boolean get() = currentProcessName == packageName