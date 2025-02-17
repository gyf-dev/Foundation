package com.gyf.foundation.ext.context

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

/**
 * @Author  Ifan.Ge
 * @Date    2024/9/30 11:01
 */

inline fun <reified T : Activity> Context.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Fragment.startActivity() {
    context?.startActivity<T>()
}