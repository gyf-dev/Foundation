package com.gyf.foundation.monitor.app

import android.graphics.drawable.Drawable
import androidx.annotation.Keep

/**
 * 应用程序数据类
 * Application data class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/26 13:36
 */
@Keep
data class Applications(
    /**
     * 应用程序标题
     * Application title
     */
    val title: String,

    /**
     * 应用程序图标
     * Application icon
     */
    val iconDrawable: Drawable,

    /**
     * 应用程序包名
     * Application package name
     */
    val pkg: String,

    /**
     * 应用程序类名
     * Application class name
     */
    val cls: String
)

/**
 * 包数据类
 * Packages data class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/26 13:36
 */
@Keep
data class Packages(
    val blacklist: List<PackageInfo> = listOf(),
    val whitelist: List<PackageInfo> = listOf(),
    val sortListByName: List<String> = listOf(),
    val sortListByClassName: List<String> = listOf()
) {
    @Keep
    data class PackageInfo(
        val pkgName: String = "",
        val clsName: List<String> = emptyList()
    )
}