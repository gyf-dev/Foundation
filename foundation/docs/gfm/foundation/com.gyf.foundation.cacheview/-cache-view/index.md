//[foundation](../../../index.md)/[com.gyf.foundation.cacheview](../index.md)/[CacheView](index.md)

# CacheView

[androidJvm]\
class [CacheView](index.md)

#### Author

geyifeng

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getDefaultContext](get-default-context.md) | [androidJvm]<br>fun [getDefaultContext](get-default-context.md)(): [ContextViewWrapper](../../com.gyf.foundation.cacheview.view/-context-view-wrapper/index.md)<br>获得ContextViewWrapper |
| [getViewCache](get-view-cache.md) | [androidJvm]<br>fun &lt;[T](get-view-cache.md), [R](get-view-cache.md)&gt; [getViewCache](get-view-cache.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), owner: [T](get-view-cache.md)): [ViewCache](../../com.gyf.foundation.cacheview.view/-view-cache/index.md)&lt;[R](get-view-cache.md)&gt;? |
| [preViewCache](pre-view-cache.md) | [androidJvm]<br>fun &lt;[T](pre-view-cache.md), [R](pre-view-cache.md)&gt; [preViewCache](pre-view-cache.md)(target: [T](pre-view-cache.md), onViewCacheFinishListener: [OnViewCacheFinishListener](../../com.gyf.foundation.cacheview.callback/-on-view-cache-finish-listener/index.md)&lt;[R](pre-view-cache.md)&gt;): [CacheView](index.md)<br>@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun &lt;[T](pre-view-cache.md), [R](pre-view-cache.md)&gt; [preViewCache](pre-view-cache.md)(target: [T](pre-view-cache.md), layoutParams: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)? = null, onViewCacheFinishListener: [OnViewCacheFinishListener](../../com.gyf.foundation.cacheview.callback/-on-view-cache-finish-listener/index.md)&lt;[R](pre-view-cache.md)&gt;? = null): [CacheView](index.md) |
| [setDebug](set-debug.md) | [androidJvm]<br>fun [setDebug](set-debug.md)(debug: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [CacheView](index.md)<br>是否debug模式 |