//[foundation](../../../index.md)/[com.gyf.foundation.cacheview.async](../index.md)/[CacheViewManager](index.md)

# CacheViewManager

[androidJvm]\
class [CacheViewManager](index.md)&lt;[T](index.md), [R](index.md)&gt; : [ICacheViewManager](../-i-cache-view-manager/index.md)&lt;[T](index.md), [R](index.md)&gt; 

#### Author

geyifeng

## Constructors

| | |
|---|---|
| [CacheViewManager](-cache-view-manager.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [getViewCache](get-view-cache.md) | [androidJvm]<br>open override fun [getViewCache](get-view-cache.md)(realContext: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), target: [T](index.md)): [ViewCache](../../com.gyf.foundation.cacheview.view/-view-cache/index.md)&lt;[R](index.md)&gt;? |
| [preViewCache](pre-view-cache.md) | [androidJvm]<br>open override fun [preViewCache](pre-view-cache.md)(target: [T](index.md), layoutParams: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?, onViewCacheFinishListener: [OnViewCacheFinishListener](../../com.gyf.foundation.cacheview.callback/-on-view-cache-finish-listener/index.md)&lt;[R](index.md)&gt;?) |