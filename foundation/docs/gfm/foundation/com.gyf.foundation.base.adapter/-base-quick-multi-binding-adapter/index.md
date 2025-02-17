//[foundation](../../../index.md)/[com.gyf.foundation.base.adapter](../index.md)/[BaseQuickMultiBindingAdapter](index.md)

# BaseQuickMultiBindingAdapter

[androidJvm]\
open class [BaseQuickMultiBindingAdapter](index.md)(items: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; = emptyList()) : BaseMultiItemAdapter&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; , [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [BaseQuickMultiBindingAdapter](-base-quick-multi-binding-adapter.md) | [androidJvm]<br>constructor(items: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; = emptyList()) |

## Functions

| Name | Summary |
|---|---|
| [addItem](add-item.md) | [androidJvm]<br>inline fun &lt;[T](add-item.md), [VB](add-item.md) : ViewBinding&gt; [addItem](add-item.md)(listener: [OnBindingAdapter](../-on-binding-adapter/index.md)&lt;[T](add-item.md), [VB](add-item.md)&gt;)<br>inline fun &lt;[T](add-item.md), [VB](add-item.md) : ViewBinding&gt; [addItem](add-item.md)(crossinline convert: (holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](add-item.md)&gt;, position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](add-item.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [BaseQuickMultiBindingAdapter](index.md) |
| [getOrAssignInt](get-or-assign-int.md) | [androidJvm]<br>@[Synchronized](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-synchronized/index.html)<br>fun [getOrAssignInt](get-or-assign-int.md)(clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;*&gt;): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |