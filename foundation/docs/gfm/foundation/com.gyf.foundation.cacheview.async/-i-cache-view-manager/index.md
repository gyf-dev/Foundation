//[foundation](../../../index.md)/[com.gyf.foundation.cacheview.async](../index.md)/[ICacheViewManager](index.md)

# ICacheViewManager

interface [ICacheViewManager](index.md)&lt;[T](index.md), [R](index.md)&gt;

#### Author

geyifeng

#### Inheritors

| |
|---|
| [CacheViewManager](../-cache-view-manager/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getViewCache](get-view-cache.md) | [androidJvm]<br>abstract fun [getViewCache](get-view-cache.md)(realContext: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), target: [T](index.md)): [ViewCache](../../com.gyf.foundation.cacheview.view/-view-cache/index.md)&lt;[R](index.md)&gt;? |
| [preViewCache](pre-view-cache.md) | [androidJvm]<br>abstract fun [preViewCache](pre-view-cache.md)(target: [T](index.md), layoutParams: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?, onViewCacheFinishListener: [OnViewCacheFinishListener](../../com.gyf.foundation.cacheview.callback/-on-view-cache-finish-listener/index.md)&lt;[R](index.md)&gt;?) |