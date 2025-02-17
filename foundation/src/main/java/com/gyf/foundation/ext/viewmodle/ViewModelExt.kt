package com.gyf.foundation.ext.viewmodle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.gyf.foundation.ext.clazz.findSuperclass

/**
 * 通过类泛型自动获取ViewModel实例的扩展函数。
 * An extension function for automatically obtaining ViewModel instances through class generics.
 *
 * 此函数利用泛型参数自动寻找继承自ViewModel的类，并通过ViewModelProvider获取其实例。
 * 这样可以避免在使用ViewModel时需要手动指定其类类型，简化了ViewModel的获取过程。
 * This function uses generic parameters to automatically find classes inherited from ViewModel and obtains their instances through ViewModelProvider.
 * This avoids the need to manually specify the class type when using ViewModel, simplifying the process of obtaining ViewModel.
 *
 * @param VM 泛型参数，继承自ViewModel的类。Generic parameter, a class inherited from ViewModel.
 * @receiver ViewModelStoreOwner 实现了ViewModelStore的对象，通常是Activity或Fragment。An object that implements ViewModelStore, usually an Activity or Fragment.
 * @return VM 实例，泛型参数指定的ViewModel类型的实例。An instance of VM, the ViewModel type specified by the generic parameter.
 */
fun <VM : ViewModel> ViewModelStoreOwner.viewModelByClassGenerics(): VM {
    val aClass = findSuperclass<VM>(ViewModel::class.java)
    return ViewModelProvider(this)[aClass]
}