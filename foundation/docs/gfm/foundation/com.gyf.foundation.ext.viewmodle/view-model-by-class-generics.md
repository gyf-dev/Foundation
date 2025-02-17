//[foundation](../../index.md)/[com.gyf.foundation.ext.viewmodle](index.md)/[viewModelByClassGenerics](view-model-by-class-generics.md)

# viewModelByClassGenerics

[androidJvm]\
fun &lt;[VM](view-model-by-class-generics.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)&gt; [ViewModelStoreOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStoreOwner.html).[viewModelByClassGenerics](view-model-by-class-generics.md)(): [VM](view-model-by-class-generics.md)

通过类泛型自动获取ViewModel实例的扩展函数。 An extension function for automatically obtaining ViewModel instances through class generics.

此函数利用泛型参数自动寻找继承自ViewModel的类，并通过ViewModelProvider获取其实例。 这样可以避免在使用ViewModel时需要手动指定其类类型，简化了ViewModel的获取过程。 This function uses generic parameters to automatically find classes inherited from ViewModel and obtains their instances through ViewModelProvider. This avoids the need to manually specify the class type when using ViewModel, simplifying the process of obtaining ViewModel.

#### Receiver

ViewModelStoreOwner 实现了ViewModelStore的对象，通常是Activity或Fragment。An object that implements ViewModelStore, usually an Activity or Fragment.

#### Return

VM 实例，泛型参数指定的ViewModel类型的实例。An instance of VM, the ViewModel type specified by the generic parameter.

#### Parameters

androidJvm

| | |
|---|---|
| VM | 泛型参数，继承自ViewModel的类。Generic parameter, a class inherited from ViewModel. |