//[foundation](../../../index.md)/[com.gyf.foundation.monitor.net.iml](../index.md)/[LollipopNetworkIml](index.md)

# LollipopNetworkIml

[androidJvm]\
@[RequiresApi](https://developer.android.com/reference/kotlin/androidx/annotation/RequiresApi.html)(value = 21)

class [LollipopNetworkIml](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), callback: ([NetworkFormatType](../../com.gyf.foundation.monitor.net/-network-format-type/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) : [INetwork](../-i-network/index.md)

Lollipop及以上版本的网络实现类 Network implementation class for Lollipop and above

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [LollipopNetworkIml](-lollipop-network-iml.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), callback: ([NetworkFormatType](../../com.gyf.foundation.monitor.net/-network-format-type/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [start](start.md) | [androidJvm]<br>open override fun [start](start.md)()<br>启动网络监听 Start network monitoring |
| [stop](stop.md) | [androidJvm]<br>open override fun [stop](stop.md)()<br>停止网络监听 Stop network monitoring |