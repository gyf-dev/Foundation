//[foundation](../../../index.md)/[com.gyf.foundation.monitor.bluetooth](../index.md)/[BluetoothMonitor](index.md)

# BluetoothMonitor

[androidJvm]\
class [BluetoothMonitor](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), profileId: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt; = mutableListOf(11, 16, 17, 18)) : [AbsMonitor](../../com.gyf.foundation.monitor/-abs-monitor/index.md)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt; 

蓝牙监视器类 Bluetooth Monitor Class

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [BluetoothMonitor](-bluetooth-monitor.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), profileId: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt; = mutableListOf(11, 16, 17, 18)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [bondedDevices](bonded-devices.md) | [androidJvm]<br>val [bondedDevices](bonded-devices.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[BluetoothDevice](https://developer.android.com/reference/kotlin/android/bluetooth/BluetoothDevice.html)&gt;<br>已配对的设备 Bonded devices |
| [connectionState](connection-state.md) | [androidJvm]<br>val [connectionState](connection-state.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>连接状态 Connection state |
| [hasConnected](has-connected.md) | [androidJvm]<br>val [hasConnected](has-connected.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否已连接 Has connected |