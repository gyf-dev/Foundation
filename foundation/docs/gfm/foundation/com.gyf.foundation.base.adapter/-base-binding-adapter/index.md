//[foundation](../../../index.md)/[com.gyf.foundation.base.adapter](../index.md)/[BaseBindingAdapter](index.md)

# BaseBindingAdapter

[androidJvm]\
abstract class [BaseBindingAdapter](index.md)&lt;[VB](index.md) : ViewBinding, [T](index.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;(items: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](index.md)&gt; = emptyList()) : BaseQuickAdapter&lt;[T](index.md), [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;&gt; , [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [BaseBindingAdapter](-base-binding-adapter.md) | [androidJvm]<br>constructor(items: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](index.md)&gt; = emptyList()) |

## Functions

| Name | Summary |
|---|---|
| [convert](convert.md) | [androidJvm]<br>abstract fun [convert](convert.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;, position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](index.md))<br>open fun [convert](convert.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;, position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](index.md), payloads: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;) |
| [onViewAttachedToWindow](on-view-attached-to-window.md) | [androidJvm]<br>open fun [onViewAttachedToWindow](on-view-attached-to-window.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;) |
| [onViewDetachedFromWindow](on-view-detached-from-window.md) | [androidJvm]<br>open fun [onViewDetachedFromWindow](on-view-detached-from-window.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;) |