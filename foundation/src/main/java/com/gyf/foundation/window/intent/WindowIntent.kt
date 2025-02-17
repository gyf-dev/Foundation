/*
 *
 *  * Copyright @ 2021 - 2022 Human Horizons (Shanghai) Cloud Computing Technology Co., Ltd.
 *  * All Rights Reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are NOT permitted except as agreed by
 *  * Human Horizons (Shanghai) Cloud Computing Technology Co., Ltd.
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */
@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.window.intent

import android.content.Context
import android.view.WindowManager
import androidx.annotation.IntDef

/**
 * @author: Ifan Ge
 * @date: 2022-10-12  16:07
 * @Version: design3.0
 */
class WindowIntent {

    @IntDef(STANDARD, SINGLE_TOP, SINGLE_TASK, SINGLE_INSTANCE, NO_STACK)
    annotation class Mode

    var context: Context? = null
        private set
    var pkg: String? = null
        private set

    val clazz: String
    var type: Int = 0
    var flags: Int = 0
    var width: Int = WindowManager.LayoutParams.MATCH_PARENT
    var height: Int = WindowManager.LayoutParams.MATCH_PARENT
    var show: Boolean = true

    @Mode
    var mode: Int = NO_STACK

    @JvmField
    var mNeedShowPrevWindow: Boolean = true

    var gravity: Int = 0

    constructor(cls: Class<*>) {
        clazz = cls.name
    }

    constructor(ctx: Context, cls: Class<*>) {
        context = ctx
        pkg = ctx.packageName
        clazz = cls.name
    }

    fun addFlags(flags: Int): WindowIntent {
        this.flags = this.flags or flags
        return this
    }

    fun isSame(o: Any?): Boolean {
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as WindowIntent
        return type == that.type && flags == that.flags && width == that.width && height == that.height && gravity == that.gravity
    }

    companion object {
        const val STANDARD: Int = 0
        const val SINGLE_TOP: Int = 1
        const val SINGLE_TASK: Int = 2
        const val SINGLE_INSTANCE: Int = 3
        const val NO_STACK: Int = 4
    }
}
