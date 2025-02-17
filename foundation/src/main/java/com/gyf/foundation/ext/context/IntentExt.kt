package com.gyf.foundation.ext.context

import android.content.Context
import android.content.Intent
import com.gyf.foundation.ext.intent.createExplicitIntent

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/21 16:25
 */

/**
 * 创建显式Intent的扩展函数。
 *
 * @param intent 要转换为显式Intent的Intent对象。
 * @return 显式Intent。
 */
fun Context.createExplicitIntent(intent: Intent) = intent.createExplicitIntent(this)