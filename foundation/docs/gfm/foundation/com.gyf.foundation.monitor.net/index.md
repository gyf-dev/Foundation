//[foundation](../../index.md)/[com.gyf.foundation.monitor.net](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [NetworkAvailableType](-network-available-type/index.md) | [androidJvm]<br>enum [NetworkAvailableType](-network-available-type/index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[NetworkAvailableType](-network-available-type/index.md)&gt; <br>网络可用类型枚举类 Network available type enumeration class |
| [NetworkFormatMonitor](-network-format-monitor/index.md) | [androidJvm]<br>class [NetworkFormatMonitor](-network-format-monitor/index.md)(val context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AbsMonitor](../com.gyf.foundation.monitor/-abs-monitor/index.md)&lt;[NetworkFormatType](-network-format-type/index.md)&gt; |
| [NetworkFormatType](-network-format-type/index.md) | [androidJvm]<br>enum [NetworkFormatType](-network-format-type/index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[NetworkFormatType](-network-format-type/index.md)&gt; <br>网络格式类型枚举类 Network format type enumeration class |

## Properties

| Name | Summary |
|---|---|
| [networkFormatType](network-format-type.md) | [androidJvm]<br>val [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[networkFormatType](network-format-type.md): [NetworkFormatType](-network-format-type/index.md)<br>获取网络格式类型 Get network format type |

## Functions

| Name | Summary |
|---|---|
| [getNetworkAvailableType](get-network-available-type.md) | [androidJvm]<br>suspend fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[getNetworkAvailableType](get-network-available-type.md)(timeout: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 500): [NetworkAvailableType](-network-available-type/index.md)<br>获取网络可用类型 Get network available type |
| [isNetworkAvailable](is-network-available.md) | [androidJvm]<br>suspend fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[isNetworkAvailable](is-network-available.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [isNetworkAvailableUsingOkHttp](is-network-available-using-ok-http.md) | [androidJvm]<br>suspend fun [isNetworkAvailableUsingOkHttp](is-network-available-using-ok-http.md)(timeout: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 500): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>使用OkHttp检查网络是否可用 Check if the network is available using OkHttp |