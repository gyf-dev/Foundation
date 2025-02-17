//[foundation](../../../index.md)/[com.gyf.foundation.base.adapter](../index.md)/[BaseAdapter](index.md)

# BaseAdapter

[androidJvm]\
abstract class [BaseAdapter](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;(layoutResId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), items: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](index.md)&gt; = emptyList()) : BaseQuickAdapter&lt;[T](index.md), [BaseViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-view-holder/index.md)&gt; , [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [BaseAdapter](-base-adapter.md) | [androidJvm]<br>constructor(layoutResId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), items: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](index.md)&gt; = emptyList()) |

## Functions

| Name | Summary |
|---|---|
| [convert](convert.md) | [androidJvm]<br>abstract fun [convert](convert.md)(holder: [BaseViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-view-holder/index.md), position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](index.md))<br>open fun [convert](convert.md)(holder: [BaseViewHolder](../../com.gyf.foundation.base.adapter.viewholder/-base-view-holder/index.md), position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), item: [T](index.md), payloads: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;) |