@file:Suppress("UNCHECKED_CAST")

package com.gyf.foundation.ext.viewbinding

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.gyf.foundation.ext.clazz.findSuperclass
import com.gyf.foundation.window.Window

/**
 * @Author Ifan.Ge
 * @Date 2024/7/1 14:06
 */
fun <VB : ViewBinding> Any.viewBindingByClassGenerics(
    layoutInflater: LayoutInflater? = null,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): VB {
    val inflater = layoutInflater
        ?: when (this) {
            is Activity -> this.layoutInflater
            is Fragment -> getLayoutInflater()
            is Window -> this.layoutInflater
            else -> throw IllegalArgumentException("Unsupported type,Please provide layoutInflater")
        }
    val aClass = findSuperclass<VB>(ViewBinding::class.java)
    return aClass.inflateBinding(inflater, parent, attachToParent)
}

inline fun <reified VB : ViewBinding> inflateBinding(
    layoutInflater: LayoutInflater,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): VB {
    return VB::class.java.inflateBinding(layoutInflater, parent, attachToParent)
}

fun <VB : ViewBinding> Class<VB>.inflateBinding(
    layoutInflater: LayoutInflater,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): VB {
    try {
        val viewBinding = getMethod(
            "inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java
        ).invoke(null, layoutInflater, parent, attachToParent) as VB?
        if (viewBinding == null) {
            throw RuntimeException("not found inflate method in ViewBinding class")
        } else {
            return viewBinding
        }
    } catch (e: Exception) {
        throw e
    }
}
