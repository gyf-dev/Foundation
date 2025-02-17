//[foundation](../../../index.md)/[com.gyf.foundation.blur](../index.md)/[Blur](index.md)

# Blur

[androidJvm]\
class [Blur](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), var radius: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) : [ITag](../../com.gyf.foundation.ext.log/-i-tag/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [Blur](-blur.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), radius: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [dayNightString](day-night-string.md) | [androidJvm]<br>val [dayNightString](day-night-string.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [isPreBlurEnabled](is-pre-blur-enabled.md) | [androidJvm]<br>var [isPreBlurEnabled](is-pre-blur-enabled.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [isPreBlurLowerSEnabled](is-pre-blur-lower-s-enabled.md) | [androidJvm]<br>var [isPreBlurLowerSEnabled](is-pre-blur-lower-s-enabled.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [orientationString](orientation-string.md) | [androidJvm]<br>val [orientationString](orientation-string.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [radius](radius.md) | [androidJvm]<br>var [radius](radius.md): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html) |

## Functions

| Name | Summary |
|---|---|
| [behind](behind.md) | [androidJvm]<br>fun [behind](behind.md)(bitmap: [Bitmap](https://developer.android.com/reference/kotlin/android/graphics/Bitmap.html), key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;)<br>fun [behind](behind.md)(surfaceView: [SurfaceView](https://developer.android.com/reference/kotlin/android/view/SurfaceView.html), after: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>fun [behind](behind.md)(@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)resId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot; &quot;)<br>fun [behind](behind.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, after: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |
| [drawBlur](draw-blur.md) | [androidJvm]<br>fun [drawBlur](draw-blur.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), c: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html))<br>fun [drawBlur](draw-blur.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), c: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html), rect: [Rect](https://developer.android.com/reference/kotlin/android/graphics/Rect.html))<br>fun [drawBlur](draw-blur.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), c: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html), dx: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), dy: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>fun [drawBlur](draw-blur.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), c: [Canvas](https://developer.android.com/reference/kotlin/android/graphics/Canvas.html), left: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), top: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), right: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), bottom: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |
| [getBlurRect](get-blur-rect.md) | [androidJvm]<br>fun [getBlurRect](get-blur-rect.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html), dx: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, dy: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0): [Rect](https://developer.android.com/reference/kotlin/android/graphics/Rect.html) |