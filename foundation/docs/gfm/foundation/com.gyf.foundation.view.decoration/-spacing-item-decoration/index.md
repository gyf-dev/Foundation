//[foundation](../../../index.md)/[com.gyf.foundation.view.decoration](../index.md)/[SpacingItemDecoration](index.md)

# SpacingItemDecoration

[androidJvm]\
class [SpacingItemDecoration](index.md)(leftSpacing: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, topSpacing: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, rightSpacing: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, bottomSpacing: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, offsetFirstItem: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, offsetLastItem: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, @[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)color: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Color.TRANSPARENT) : [RecyclerView.ItemDecoration](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ItemDecoration.html)

自定义RecyclerView的Item装饰类，用于添加间距和绘制分割线。 Custom RecyclerView ItemDecoration class for adding spacing and drawing dividers.

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [SpacingItemDecoration](-spacing-item-decoration.md) | [androidJvm]<br>constructor(leftSpacing: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, topSpacing: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, rightSpacing: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, bottomSpacing: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, offsetFirstItem: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, offsetLastItem: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, @[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)color: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Color.TRANSPARENT) |

## Functions

| Name | Summary |
|---|---|
| [getItemOffsets](get-item-offsets.md) | [androidJvm]<br>open override fun [getItemOffsets](get-item-offsets.md)(outRect: [Rect](https://developer.android.com/reference/kotlin/android/graphics/Rect.html), view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), parent: [RecyclerView](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.html), state: [RecyclerView.State](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.State.html)) |
| [onDraw](on-draw.md) | [androidJvm]<br>open override fun [onDraw](on-draw.md)(c: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html), parent: [RecyclerView](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.html), state: [RecyclerView.State](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.State.html)) |