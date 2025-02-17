package com.gyf.foundation.ext.context

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/21 16:36
 */

/**
 * 是否为系统应用的扩展属性。
 *
 * @return 如果当前应用是系统应用，则返回true，否则返回false。
 */
val Context.isSystemApp: Boolean
    get() {
        try {
            val packageInfo: PackageInfo = packageManager.getPackageInfo(
                packageName,
                PackageManager.GET_SHARED_LIBRARY_FILES
            )
            return "android.uid.system" == packageInfo.sharedUserId
        } catch (_: PackageManager.NameNotFoundException) {

        }
        return false
    }