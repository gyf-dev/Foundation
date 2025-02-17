//[foundation](../../../index.md)/[com.gyf.foundation.monitor.net.iml](../index.md)/[OtherNetwork](index.md)

# OtherNetwork

[androidJvm]\
class [OtherNetwork](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), callback: ([NetworkFormatType](../../com.gyf.foundation.monitor.net/-network-format-type/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) : [INetwork](../-i-network/index.md)

其他网络类 Other network class

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [OtherNetwork](-other-network.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), callback: ([NetworkFormatType](../../com.gyf.foundation.monitor.net/-network-format-type/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Types

| Name | Summary |
|---|---|
| [NetBroadcastReceiver](-net-broadcast-receiver/index.md) | [androidJvm]<br>inner class [NetBroadcastReceiver](-net-broadcast-receiver/index.md) : [BroadcastReceiver](https://developer.android.com/reference/kotlin/android/content/BroadcastReceiver.html)<br>网络广播接收器类 Network broadcast receiver class |

## Functions

| Name | Summary |
|---|---|
| [start](start.md) | [androidJvm]<br>open override fun [start](start.md)()<br>启动网络监听 Start network monitoring |
| [stop](stop.md) | [androidJvm]<br>open override fun [stop](stop.md)()<br>停止网络监听 Stop network monitoring |