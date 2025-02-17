//[foundation](../../../index.md)/[com.gyf.foundation.base.adapter](../index.md)/[BaseQuickMultiBindingAdapter](index.md)/[addItem](add-item.md)

# addItem

[androidJvm]\
inline fun &lt;[T](add-item.md), [VB](add-item.md) : ViewBinding&gt; [addItem](add-item.md)(listener: [OnBindingAdapter](../-on-binding-adapter/index.md)&lt;[T](add-item.md), [VB](add-item.md)&gt;)

inline fun &lt;[T](add-item.md), [VB](add-item.md) : ViewBinding&gt; [addItem](add-item.md)(crossinline convert: (holder: [BaseBindingViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-binding-view-holder/index.md)&lt;[VB](add-item.md)&gt;, position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](add-item.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [BaseQuickMultiBindingAdapter](index.md)