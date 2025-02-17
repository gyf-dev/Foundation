package com.gyf.foundation.ext.typedarray

import android.content.Context
import android.util.AttributeSet
import android.util.SparseIntArray
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.CompoundButtonCompat
import androidx.core.widget.ImageViewCompat
import androidx.core.widget.TextViewCompat
import com.gyf.foundation.ext.resources.drawableRes

private val defaultAttrs = intArrayOf(
    android.R.attr.background,
    android.R.attr.backgroundTint,
    android.R.attr.button,
    android.R.attr.buttonTint,
    android.R.attr.tint,
    android.R.attr.drawableLeft,
    android.R.attr.drawableRight,
    android.R.attr.drawableTop,
    android.R.attr.drawableBottom,
    android.R.attr.textColor,
    android.R.attr.textColorHint,
)

fun View.getResourceIdS(
    attrs: IntArray = intArrayOf(),
    set: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) = context.getResourceIdS(attrs, set, defStyleAttr, defStyleRes)

fun Context.getResourceIdS(
    attrs: IntArray,
    set: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
): SparseIntArray {
    val a = (attrs + defaultAttrs).distinct().sorted().toIntArray()
    val result = SparseIntArray(a.size)
    return obtainStyledAttributes(set, a, defStyleAttr, defStyleRes).use { typedArray ->
        for (i in a.indices) {
            val resourceId = typedArray.getResourceId(i, 0)
            result.put(a[i], resourceId)
        }
        result
    }
}


fun SparseIntArray.getOr(key: Int, block: (Int) -> Unit) {
    val resourceId = get(key)
    if (resourceId != 0) {
        block(resourceId)
    }
}

fun View.applyAttrChanged(resourceIdS: SparseIntArray) {
    resourceIdS.getOr(android.R.attr.background) {
        background = it.drawableRes
    }
    resourceIdS.getOr(android.R.attr.backgroundTint) {
        val colorStateList = ContextCompat.getColorStateList(context, it)
        if (colorStateList != null) {
            ViewCompat.setBackgroundTintList(this, colorStateList)
        }
    }

    if (this is CompoundButton) {
        resourceIdS.getOr(android.R.attr.button) {
            buttonDrawable = it.drawableRes
        }
        resourceIdS.getOr(android.R.attr.buttonTint) {
            val colorStateList = ContextCompat.getColorStateList(context, it)
            if (colorStateList != null) {
                CompoundButtonCompat.setButtonTintList(this, colorStateList)
            }
        }
    }

    if (this is ImageView) {
        resourceIdS.getOr(android.R.attr.tint) {
            val colorStateList = ContextCompat.getColorStateList(context, it)
            if (colorStateList != null) {
                ImageViewCompat.setImageTintList(this, colorStateList)
            }
        }
    }

    if (this is TextView) {
        var leftDrawable = compoundDrawables[0]
        var topDrawable = compoundDrawables[1]
        var rightDrawable = compoundDrawables[2]
        var bottomDrawable = compoundDrawables[3]
        resourceIdS.getOr(android.R.attr.drawableLeft) {
            leftDrawable = it.drawableRes
        }
        resourceIdS.getOr(android.R.attr.drawableTop) {
            topDrawable = it.drawableRes
        }
        resourceIdS.getOr(android.R.attr.drawableRight) {
            rightDrawable = it.drawableRes
        }
        resourceIdS.getOr(android.R.attr.drawableBottom) {
            bottomDrawable = it.drawableRes
        }
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(
            this,
            leftDrawable,
            topDrawable,
            rightDrawable,
            bottomDrawable
        )
        resourceIdS.getOr(android.R.attr.textColor) {
            val colorStateList = ContextCompat.getColorStateList(context, it)
            if (colorStateList != null) {
                setTextColor(colorStateList)
            }
        }
        resourceIdS.getOr(android.R.attr.textColorHint) {
            val colorStateList = ContextCompat.getColorStateList(context, it)
            if (colorStateList != null) {
                setHintTextColor(colorStateList)
            }
        }
    }
}
