package com.gyf.foundation.base.activity.nativer

import android.view.View
import androidx.viewbinding.ViewBinding
import com.gyf.foundation.ext.viewbinding.viewBindingByClassGenerics

/**
 * 这是一个基础绑定活动类，扩展了[BaseNativeActivity]并使用了[ViewBinding]。
 * This is a base binding activity class that extends [BaseNativeActivity] and uses [ViewBinding].
 *
 * @param VB ViewBinding的类型参数，表示视图绑定的类型。
 *        Type parameter of ViewBinding, indicating the type of view binding.‘
 *
 * @Author  Ifan.Ge
 * @Date    2024/7/1 13:57
 */
open class BaseBindingNativeActivity<VB : ViewBinding> : BaseNativeActivity() {

    /**
     * 这是一个懒加载的绑定属性，它使用了viewBindingByClassGenerics函数来获取VB类型的实例。
     * This is a lazily initialized binding property, it uses the viewBindingByClassGenerics function to get an instance of type VB.
     */
    val binding by lazy { viewBindingByClassGenerics<VB>() }

    /**
     * 这是一个重写的injectContentView方法，它返回一个View类型的值。
     * This is an overridden injectContentView method, it returns a value of type View.
     *
     * @return 返回一个View类型的值，它是绑定的根视图。
     *         Returns a value of type View, it is the root view of the binding.
     */
    override fun injectContentView(): View {
        return binding.root
    }
}