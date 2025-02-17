@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.gyf.foundation.ext.view

import android.view.View

/**
 * @Author  Ifan.Ge
 * @Date    2024/9/11 9:37
 */

inline fun <reified T> View.getTag(key: Int, default: () -> T): T {
    return getTag<T>(key) ?: run {
        val value = default()
        setTag(key, value)
        value
    }
}

inline fun <reified T> View.getTag(key: Int): T? = getTag(key) as? T