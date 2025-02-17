//[foundation](../../../index.md)/[com.gyf.foundation.cacheview.async](../index.md)/[CacheViewSetting](index.md)

# CacheViewSetting

[androidJvm]\
object [CacheViewSetting](index.md)

#### Author

geyifeng

## Properties

| Name | Summary |
|---|---|
| [asyncViewCritical](async-view-critical.md) | [androidJvm]<br>var [asyncViewCritical](async-view-critical.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>缓存view临界点，当小于这个临界点的时候会自动缓存view到最大值 |
| [asyncViewEnabled](async-view-enabled.md) | [androidJvm]<br>var [asyncViewEnabled](async-view-enabled.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否可以使用缓存view |
| [asyncViewMax](async-view-max.md) | [androidJvm]<br>var [asyncViewMax](async-view-max.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>缓存view最大值 |
| [asyncViewMaxAll](async-view-max-all.md) | [androidJvm]<br>var [asyncViewMaxAll](async-view-max-all.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>所有缓存view最大值 |
| [executor](executor.md) | [androidJvm]<br>var [executor](executor.md): [ThreadPoolExecutor](https://developer.android.com/reference/kotlin/java/util/concurrent/ThreadPoolExecutor.html)<br>线程池 |