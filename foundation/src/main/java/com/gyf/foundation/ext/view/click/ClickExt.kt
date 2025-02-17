package com.gyf.foundation.ext.view.click

import android.view.View
import com.gyf.foundation.R

/**
 * 设置全局重复点击间隔时间的默认值，1000毫秒
 *
 * 这个常量定义了两次点击之间的最小间隔时间，以毫秒为单位。
 */
private const val repeatClickInterval = 1000L

/**
 * 判断是否可以点击
 *
 * @receiver View 当前的视图对象
 * @param interval Long 两次点击之间的最小间隔时间，以毫秒为单位。默认值为repeatClickInterval。
 * @return Boolean 如果当前时间与上次点击时间的差值大于或等于间隔时间，则返回true，否则返回false。
 */
fun View.checkRepeat(interval: Long = repeatClickInterval): Boolean {
    val curTime = System.currentTimeMillis()
    val lastTime = getTag(R.id.view_anti_repeat_click) as? Long ?: 0L
    return if (curTime - lastTime >= interval) {
        setTag(R.id.view_anti_repeat_click, curTime)
        true
    } else {
        false
    }
}

/**
 * 判断可以点击后做xxx
 *
 * @receiver View 当前的视图对象
 * @param interval Long 两次点击之间的最小间隔时间，以毫秒为单位。默认值为repeatClickInterval。
 * @param method Function1<View, Unit> 如果可以点击，则执行此函数。
 */
fun View.checkRepeat(interval: Long = repeatClickInterval, method: (View) -> Unit) {
    if (checkRepeat(interval)) method(this)
}

/**
 * 点击事件的扩展函数
 * @receiver View 当前的视图对象
 * @param listener View.OnClickListener 点击事件的监听器
 */
fun View.onClick(listener: View.OnClickListener) {
    setOnClickListener(listener)
}

/**
 * 点击事件的扩展函数
 *
 * @receiver View 当前的视图对象
 * @param interval Long 两次点击之间的最小间隔时间，以毫秒为单位。默认值为repeatClickInterval。
 * @param method Function1<View, Unit> 如果可以点击，则执行此函数。
 */
fun View.onClick(interval: Long = repeatClickInterval, method: (View) -> Unit) {
    setOnClickListener {
        checkRepeat(interval, method)
    }
}

/**
 * 长按点击事件的扩展函数
 * @receiver View 当前的视图对象
 * @param listener View.OnLongClickListener 长按事件的监听器
 */
fun View.onLongClick(listener: View.OnLongClickListener) {
    this.setOnLongClickListener(listener)
}

/**
 * 长按点击事件的扩展函数
 * @receiver View 当前的视图对象
 * @param method () -> Boolean 如果长按，则执行此函数。
 */
fun View.onLongClick(method: (View) -> Boolean) {
    this.setOnLongClickListener { method(this) }
}