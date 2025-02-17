package com.gyf.foundation.ext.context

import android.content.Context

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/21 16:21
 */

/**
 * 从Assets文件夹中读取文件内容的扩展函数。
 *
 * @param filename 要读取的文件名。
 * @return 文件的内容，以字符串形式返回。
 */
fun Context.readAssetsString(filename: String): String {
    val stringBuilder = StringBuilder()
    assets.open(filename).use { inputStream ->
        inputStream.bufferedReader().useLines { lines ->
            lines.forEach {
                stringBuilder.append(it)
                stringBuilder.append('\n')
            }
        }
    }
    return stringBuilder.toString()
}