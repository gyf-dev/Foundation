//[foundation](../../../index.md)/[com.gyf.foundation.base.adapter](../index.md)/[OnBindingAdapter](index.md)

# OnBindingAdapter

[androidJvm]\
abstract class [OnBindingAdapter](index.md)&lt;[T](index.md), [VB](index.md) : ViewBinding&gt; : [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [OnBindingAdapter](-on-binding-adapter.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [adapter](adapter.md) | [androidJvm]<br>lateinit var [adapter](adapter.md): BaseMultiItemAdapter&lt;*&gt; |
| [recyclerView](recycler-view.md) | [androidJvm]<br>val [recyclerView](recycler-view.md): [RecyclerView](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.html) |

## Functions

| Name | Summary |
|---|---|
| [isFullSpanItem](is-full-span-item.md) | [androidJvm]<br>open fun [isFullSpanItem](is-full-span-item.md)(itemType: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onBind](on-bind.md) | [androidJvm]<br>abstract fun [onBind](on-bind.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;, position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](index.md))<br>open fun [onBind](on-bind.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;, position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](index.md), payloads: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;) |
| [onFailedToRecycleView](on-failed-to-recycle-view.md) | [androidJvm]<br>open fun [onFailedToRecycleView](on-failed-to-recycle-view.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onViewAttachedToWindow](on-view-attached-to-window.md) | [androidJvm]<br>open fun [onViewAttachedToWindow](on-view-attached-to-window.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;) |
| [onViewDetachedFromWindow](on-view-detached-from-window.md) | [androidJvm]<br>open fun [onViewDetachedFromWindow](on-view-detached-from-window.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;) |
| [onViewRecycled](on-view-recycled.md) | [androidJvm]<br>open fun [onViewRecycled](on-view-recycled.md)(holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](index.md)&gt;) |