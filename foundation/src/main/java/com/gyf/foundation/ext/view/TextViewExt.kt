package com.gyf.foundation.ext.view

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/27 17:55
 */

fun TextView.setTextColorRes(@ColorRes colorRes: Int) = apply {
    setTextColor(ContextCompat.getColor(context, colorRes))
}