//[foundation](../../../index.md)/[com.gyf.foundation.base.adapter](../index.md)/[BaseMultiBindingAdapter](index.md)

# BaseMultiBindingAdapter

[androidJvm]\
open class [BaseMultiBindingAdapter](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;(items: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](index.md)&gt; = emptyList()) : BaseMultiItemAdapter&lt;[T](index.md)&gt; , [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [BaseMultiBindingAdapter](-base-multi-binding-adapter.md) | [androidJvm]<br>constructor(items: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](index.md)&gt; = emptyList()) |

## Functions

| Name | Summary |
|---|---|
| [addItem](add-item.md) | [androidJvm]<br>inline fun &lt;[VB](add-item.md) : ViewBinding&gt; [addItem](add-item.md)(itemViewType: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), listener: [OnBindingAdapter](../-on-binding-adapter/index.md)&lt;[T](index.md), [VB](add-item.md)&gt;)<br>inline fun &lt;[VB](add-item.md) : ViewBinding&gt; [addItem](add-item.md)(itemViewType: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), crossinline convert: (holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](add-item.md)&gt;, position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [BaseMultiBindingAdapter](index.md)&lt;[T](index.md)&gt; |