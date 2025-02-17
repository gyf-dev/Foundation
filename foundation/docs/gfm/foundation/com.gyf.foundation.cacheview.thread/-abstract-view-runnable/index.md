//[foundation](../../../index.md)/[com.gyf.foundation.cacheview.thread](../index.md)/[AbstractViewRunnable](index.md)

# AbstractViewRunnable

[androidJvm]\
abstract class [AbstractViewRunnable](index.md)&lt;[T](index.md), [R](index.md)&gt;(target: [T](index.md), layoutParams: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?, onViewCacheFinishListener: [OnViewCacheFinishListener](../../com.gyf.foundation.cacheview.callback/-on-view-cache-finish-listener/index.md)&lt;[R](index.md)&gt;?, iCacheViewManager: [ICacheViewManager](../../com.gyf.foundation.cacheview.async/-i-cache-view-manager/index.md)&lt;[T](index.md), [R](index.md)&gt;) : [Runnable](https://developer.android.com/reference/kotlin/java/lang/Runnable.html)

## Constructors

| | |
|---|---|
| [AbstractViewRunnable](-abstract-view-runnable.md) | [androidJvm]<br>constructor(target: [T](index.md), layoutParams: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?, onViewCacheFinishListener: [OnViewCacheFinishListener](../../com.gyf.foundation.cacheview.callback/-on-view-cache-finish-listener/index.md)&lt;[R](index.md)&gt;?, iCacheViewManager: [ICacheViewManager](../../com.gyf.foundation.cacheview.async/-i-cache-view-manager/index.md)&lt;[T](index.md), [R](index.md)&gt;) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [generateViewCache](generate-view-cache.md) | [androidJvm]<br>abstract fun [generateViewCache](generate-view-cache.md)(target: [T](index.md), layoutParams: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?): [ViewCache](../../com.gyf.foundation.cacheview.view/-view-cache/index.md)&lt;[R](index.md)&gt; |
| [run](run.md) | [androidJvm]<br>@[Synchronized](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-synchronized/index.html)<br>override fun [run](run.md)() |