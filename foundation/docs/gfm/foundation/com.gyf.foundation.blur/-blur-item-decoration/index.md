//[foundation](../../../index.md)/[com.gyf.foundation.blur](../index.md)/[BlurItemDecoration](index.md)

# BlurItemDecoration

[androidJvm]\
class [BlurItemDecoration](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), radius: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) : [RecyclerView.ItemDecoration](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ItemDecoration.html), [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [BlurItemDecoration](-blur-item-decoration.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), radius: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [blur](blur.md) | [androidJvm]<br>val [blur](blur.md): [Blur](../-blur/index.md) |

## Functions

| Name | Summary |
|---|---|
| [canBlur](can-blur.md) | [androidJvm]<br>fun [canBlur](can-blur.md)(block: ([RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html)) -&gt; [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [BlurItemDecoration](index.md) |
| [onDraw](on-draw.md) | [androidJvm]<br>open override fun [onDraw](on-draw.md)(c: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html), parent: [RecyclerView](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.html), state: [RecyclerView.State](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.State.html)) |