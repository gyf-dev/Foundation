//[foundation](../../../index.md)/[com.gyf.foundation.monitor.app](../index.md)/[ApplicationsMonitor](index.md)

# ApplicationsMonitor

[androidJvm]\
class [ApplicationsMonitor](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AbsMonitor](../../com.gyf.foundation.monitor/-abs-monitor/index.md)&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Applications](../-applications/index.md)&gt;&gt; 

ApplicationsMonitor类，用于监控应用的变化 ApplicationsMonitor class, used to monitor changes in applications

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [ApplicationsMonitor](-applications-monitor.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [blackEnabled](black-enabled.md) | [androidJvm]<br>var [blackEnabled](black-enabled.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>黑名单是否启用 Whether the blacklist is enabled |

## Functions

| Name | Summary |
|---|---|
| [getIconDrawable](get-icon-drawable.md) | [androidJvm]<br>fun [getIconDrawable](get-icon-drawable.md)(pkg: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Drawable](https://developer.android.com/reference/kotlin/android/graphics/drawable/Drawable.html)?<br>获取应用图标 Get application icon |
| [obtainApplications](obtain-applications.md) | [androidJvm]<br>fun [obtainApplications](obtain-applications.md)(): Job<br>获取应用信息 Get application information |
| [setPackages](set-packages.md) | [androidJvm]<br>fun [setPackages](set-packages.md)(packages: [Packages](../-packages/index.md)): [ApplicationsMonitor](index.md)<br>设置黑白名单 |
| [toggleBlack](toggle-black.md) | [androidJvm]<br>fun [toggleBlack](toggle-black.md)()<br>切换黑名单 Toggle blacklist |