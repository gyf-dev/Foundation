//[foundation](../../../index.md)/[com.gyf.foundation.blur](../index.md)/[BlurRecyclerView](index.md)

# BlurRecyclerView

[androidJvm]\
class [BlurRecyclerView](index.md)@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null) : [RecyclerView](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.html)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [BlurRecyclerView](-blur-recycler-view.md) | [androidJvm]<br>@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [blur](blur.md) | [androidJvm]<br>val [blur](blur.md): [Blur](../-blur/index.md) |
| [radius](radius.md) | [androidJvm]<br>var [radius](radius.md): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |

## Functions

| Name | Summary |
|---|---|
| [canBlur](can-blur.md) | [androidJvm]<br>fun [canBlur](can-blur.md)(block: ([RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html)) -&gt; [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [BlurRecyclerView](index.md) |
| [drawChild](draw-child.md) | [androidJvm]<br>open override fun [drawChild](draw-child.md)(canvas: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html), child: [View](https://developer.android.com/reference/kotlin/android/view/View.html), drawingTime: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |