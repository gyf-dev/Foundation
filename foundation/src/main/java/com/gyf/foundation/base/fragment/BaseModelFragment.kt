package com.gyf.foundation.base.fragment

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.gyf.foundation.ext.viewmodle.viewModelByClassGenerics

/**
 * 基础模型活动类，提供ViewModel和ViewBinding的集成。
 * Base model activity class providing integration of ViewModel and ViewBinding.
 *
 * 这个类是一个泛型类，允许指定ViewBinding和ViewModel的类型，从而实现对应的视图和业务逻辑的绑定。
 * This class is a generic class that allows specifying the types for ViewBinding and ViewModel, thus facilitating the binding of corresponding views and business logic.
 *
 * @param VB [ViewBinding]的类型参数，用于指定绑定的视图布局。
 *           Type parameter for ViewBinding, used to specify the bound view layout.
 * @param VM [ViewModel]的类型参数，用于指定绑定的业务逻辑模型。
 *           Type parameter for ViewModel, used to specify the bound business logic model.
 *
 * @Author Ifan.Ge
 * @Date 2024/7/8 13:54
 */
open class BaseModelFragment<VB : ViewBinding, VM : ViewModel> : BaseBindingFragment<VB>() {

    // 通过懒加载获取ViewModel实例，使用泛型自动获取对应的ViewModel类型。
    // Lazily obtains the ViewModel instance, using generics to automatically acquire the corresponding ViewModel type.
    val viewModel by lazy { viewModelByClassGenerics<VM>() }
}