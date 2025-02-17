//[foundation](../../../index.md)/[com.gyf.foundation.monitor.net.iml](../index.md)/[NetworkCallback](index.md)

# NetworkCallback

[androidJvm]\
@[RequiresApi](https://developer.android.com/reference/kotlin/androidx/annotation/RequiresApi.html)(value = 21)

class [NetworkCallback](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), callback: ([NetworkFormatType](../../com.gyf.foundation.monitor.net/-network-format-type/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) : [ConnectivityManager.NetworkCallback](https://developer.android.com/reference/kotlin/android/net/ConnectivityManager.NetworkCallback.html)

网络回调类 Network callback class

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [NetworkCallback](-network-callback.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), callback: ([NetworkFormatType](../../com.gyf.foundation.monitor.net/-network-format-type/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [onAvailable](on-available.md) | [androidJvm]<br>open override fun [onAvailable](on-available.md)(network: [Network](https://developer.android.com/reference/kotlin/android/net/Network.html))<br>当网络可用时调用 Called when the network is available |
| [onCapabilitiesChanged](on-capabilities-changed.md) | [androidJvm]<br>open override fun [onCapabilitiesChanged](on-capabilities-changed.md)(network: [Network](https://developer.android.com/reference/kotlin/android/net/Network.html), networkCapabilities: [NetworkCapabilities](https://developer.android.com/reference/kotlin/android/net/NetworkCapabilities.html))<br>当网络能力发生变化时调用 Called when network capabilities change |
| [onLost](on-lost.md) | [androidJvm]<br>open override fun [onLost](on-lost.md)(network: [Network](https://developer.android.com/reference/kotlin/android/net/Network.html))<br>当网络丢失时调用 Called when the network is lost |