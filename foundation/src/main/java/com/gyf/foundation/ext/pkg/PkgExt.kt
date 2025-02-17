@file:Suppress("DEPRECATION")

package com.gyf.foundation.ext.pkg

import android.content.Context
import dalvik.system.DexFile

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/4 11:28
 */

fun Context.getClassesInPackage(packageName: String): List<Class<*>> {
    val classes = mutableListOf<Class<*>>()
    try {
        val packageCodePath = packageCodePath
        val dexFile = DexFile(packageCodePath)
        val entries = dexFile.entries()

        while (entries.hasMoreElements()) {
            val className = entries.nextElement()
            if (className.startsWith(packageName) && !className.contains('$')) {
                try {
                    val clazz = Class.forName(className)
                    classes.add(clazz)
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return classes
}