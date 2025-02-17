//[foundation](../../../index.md)/[com.gyf.foundation.monitor.net.iml](../index.md)/[NNetworkIml](index.md)

# NNetworkIml

[androidJvm]\
@[RequiresApi](https://developer.android.com/reference/kotlin/androidx/annotation/RequiresApi.html)(value = 24)

class [NNetworkIml](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), callback: ([NetworkFormatType](../../com.gyf.foundation.monitor.net/-network-format-type/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) : [INetwork](../-i-network/index.md)

N及其以上网络实现类 Network implementation class

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [NNetworkIml](-n-network-iml.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), callback: ([NetworkFormatType](../../com.gyf.foundation.monitor.net/-network-format-type/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [start](start.md) | [androidJvm]<br>open override fun [start](start.md)()<br>启动网络监听 Start network monitoring |
| [stop](stop.md) | [androidJvm]<br>open override fun [stop](stop.md)()<br>停止网络监听 Stop network monitoring |