package com.gyf.foundation.ext.toast

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import com.gyf.foundation.Foundation

/**
 * Toast扩展函数类
 * Class containing extension functions for Toast
 * @Author  Ifan.Ge
 * @Date    2024/6/28 14:15
 */

/**
 * 短时间显示Toast消息
 * Show a short duration Toast message
 *
 * @param msg CharSequence 要显示的消息
 *            CharSequence message to be displayed
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
fun Context.toast(msg: CharSequence): Toast =
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).apply { show() }

/**
 * 短时间显示Toast消息（通过资源ID）
 * Show a short duration Toast message (using resource ID)
 *
 * @param resId Int 要显示的消息资源ID
 *             Int resource ID of the message to be displayed
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
fun Context.toast(@StringRes resId: Int): Toast = toast(getString(resId))

/**
 * 短时间显示Toast消息（使用全局上下文）
 * Show a short duration Toast message (using global context)
 *
 * @param msg CharSequence 要显示的消息
 *            CharSequence message to be displayed
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
fun toast(msg: CharSequence): Toast = Foundation.context.toast(msg)

/**
 * 短时间显示Toast消息（通过资源ID，使用全局上下文）
 * Show a short duration Toast message (using resource ID and global context)
 *
 * @param resId Int 要显示的消息资源ID
 *             Int resource ID of the message to be displayed
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
fun toast(@StringRes resId: Int): Toast = Foundation.context.toast(resId)

/**
 * 短时间显示Toast消息的属性扩展
 * Property extension to show a short duration Toast message
 *
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
val CharSequence.toast: Toast get() = toast(this)

/**
 * 短时间显示Toast消息的属性扩展（通过资源ID）
 * Property extension to show a short duration Toast message (using resource ID)
 *
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
val Int.toast: Toast get() = toast(this)

/**
 * 长时间显示Toast消息
 * Show a long duration Toast message
 *
 * @param msg CharSequence 要显示的消息
 *            CharSequence message to be displayed
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
fun Context.toastLong(msg: CharSequence): Toast =
    Toast.makeText(this, msg, Toast.LENGTH_LONG).apply { show() }

/**
 * 长时间显示Toast消息（通过资源ID）
 * Show a long duration Toast message (using resource ID)
 *
 * @param resId Int 要显示的消息资源ID
 *             Int resource ID of the message to be displayed
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
fun Context.toastLong(@StringRes resId: Int): Toast = toastLong(getString(resId))

/**
 * 长时间显示Toast消息（使用全局上下文）
 * Show a long duration Toast message (using global context)
 *
 * @param msg CharSequence 要显示的消息
 *            CharSequence message to be displayed
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
fun toastLong(msg: CharSequence): Toast = Foundation.context.toastLong(msg)

/**
 * 长时间显示Toast消息（通过资源ID，使用全局上下文）
 * Show a long duration Toast message (using resource ID and global context)
 *
 * @param resId Int 要显示的消息资源ID
 *             Int resource ID of the message to be displayed
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
fun toastLong(@StringRes resId: Int): Toast = Foundation.context.toastLong(resId)

/**
 * 长时间显示Toast消息的属性扩展
 * Property extension to show a long duration Toast message
 *
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
val CharSequence.toastLong: Toast get() = toastLong(this)

/**
 * 长时间显示Toast消息的属性扩展（通过资源ID）
 * Property extension to show a long duration Toast message (using resource ID)
 *
 * @return Toast 返回显示的Toast对象
 *         Returns the displayed Toast object
 */
val Int.toastLong: Toast get() = toastLong(this)
