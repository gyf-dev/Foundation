package com.gyf.foundation.base.fragment

import android.view.View
import androidx.viewbinding.ViewBinding
import com.gyf.foundation.ext.viewbinding.viewBindingByClassGenerics

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/1 13:57
 */
open class BaseBindingFragment<VB : ViewBinding> : BaseFragment() {

    val binding by lazy { viewBindingByClassGenerics<VB>() }

    override fun injectContentView(): View {
        return binding.root
    }
}