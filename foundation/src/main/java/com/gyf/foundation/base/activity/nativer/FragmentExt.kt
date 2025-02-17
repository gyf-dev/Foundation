package com.gyf.foundation.base.activity.nativer

import androidx.fragment.app.Fragment

/**
 * @Author  Ifan.Ge
 * @Date    2024/9/30 10:39
 */

val Fragment.nativeActivity get() = context as? FragmentNativeActivity
fun Fragment.requireNativeActivity() =
    nativeActivity ?: error("Fragment is not attached to a FragmentNativeActivity")