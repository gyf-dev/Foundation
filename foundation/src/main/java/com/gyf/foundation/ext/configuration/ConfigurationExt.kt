@file:Suppress("DEPRECATION")

package com.gyf.foundation.ext.configuration

import android.content.res.Configuration
import android.os.Build
import java.util.Locale

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/27 8:58
 */

/**
 * 获取当前的Locale
 * Get the current Locale
 */
val Configuration.currentLocale: Locale
    get() {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locales[0]
        } else {
            locale
        }
    }

/**
 * 获取当前的夜间模式
 * Get the current night mode
 */
val Configuration.currentNightMode: Boolean
    get() {
        return uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

val Configuration.currentOrientation: Int
    get() {
        return orientation
    }