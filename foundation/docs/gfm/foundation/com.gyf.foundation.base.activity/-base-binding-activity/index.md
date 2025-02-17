//[foundation](../../../index.md)/[com.gyf.foundation.base.activity](../index.md)/[BaseBindingActivity](index.md)

# BaseBindingActivity

open class [BaseBindingActivity](index.md)&lt;[VB](index.md) : ViewBinding&gt; : [BaseActivity](../-base-activity/index.md)

这是一个基础绑定活动类，扩展了[BaseActivity](../-base-activity/index.md)并使用了ViewBinding。 This is a base binding activity class that extends [BaseActivity](../-base-activity/index.md) and uses ViewBinding.

#### Author

Ifan.Ge

#### Parameters

androidJvm

| | |
|---|---|
| VB | ViewBinding的类型参数，表示视图绑定的类型。     Type parameter of ViewBinding, indicating the type of view binding.‘ |

#### Inheritors

| |
|---|
| [BaseModelActivity](../-base-model-activity/index.md) |

## Constructors

| | |
|---|---|
| [BaseBindingActivity](-base-binding-activity.md) | [androidJvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | [androidJvm]<br>val [binding](binding.md): [VB](index.md)<br>这是一个懒加载的绑定属性，它使用了viewBindingByClassGenerics函数来获取VB类型的实例。 This is a lazily initialized binding property, it uses the viewBindingByClassGenerics function to get an instance of type VB. |