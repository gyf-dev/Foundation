//[foundation](../../../index.md)/[com.gyf.foundation.base.window](../index.md)/[BaseModelWindow](index.md)

# BaseModelWindow

open class [BaseModelWindow](index.md)&lt;[VB](index.md) : ViewBinding, [VM](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)&gt; : [BaseBindingWindow](../-base-binding-window/index.md)&lt;[VB](index.md)&gt; 

基础模型活动类，提供ViewModel和ViewBinding的集成。 Base model activity class providing integration of ViewModel and ViewBinding.

这个类是一个泛型类，允许指定ViewBinding和ViewModel的类型，从而实现对应的视图和业务逻辑的绑定。 This class is a generic class that allows specifying the types for ViewBinding and ViewModel, thus facilitating the binding of corresponding views and business logic.

#### Author

Ifan.Ge

#### Parameters

androidJvm

| | |
|---|---|
| VB | ViewBinding的类型参数，用于指定绑定的视图布局。     Type parameter for ViewBinding, used to specify the bound view layout. |
| VM | [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)的类型参数，用于指定绑定的业务逻辑模型。     Type parameter for ViewModel, used to specify the bound business logic model. |

## Constructors

| | |
|---|---|
| [BaseModelWindow](-base-model-window.md) | [androidJvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [viewModel](view-model.md) | [androidJvm]<br>val [viewModel](view-model.md): [VM](index.md) |