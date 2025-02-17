//[foundation](../../../index.md)/[com.gyf.foundation.base.adapter](../index.md)/[BaseMultiBindingAdapter](index.md)/[addItem](add-item.md)

# addItem

[androidJvm]\
inline fun &lt;[VB](add-item.md) : ViewBinding&gt; [addItem](add-item.md)(itemViewType: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), listener: [OnBindingAdapter](../-on-binding-adapter/index.md)&lt;[T](index.md), [VB](add-item.md)&gt;)

inline fun &lt;[VB](add-item.md) : ViewBinding&gt; [addItem](add-item.md)(itemViewType: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), crossinline convert: (holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](add-item.md)&gt;, position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [BaseMultiBindingAdapter](index.md)&lt;[T](index.md)&gt;