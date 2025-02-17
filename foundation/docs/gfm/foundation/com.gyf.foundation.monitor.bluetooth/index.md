//[foundation](../../index.md)/[com.gyf.foundation.monitor.bluetooth](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [BluetoothMonitor](-bluetooth-monitor/index.md) | [androidJvm]<br>class [BluetoothMonitor](-bluetooth-monitor/index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), profileId: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt; = mutableListOf(11, 16, 17, 18)) : [AbsMonitor](../com.gyf.foundation.monitor/-abs-monitor/index.md)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt; <br>蓝牙监视器类 Bluetooth Monitor Class |

## Properties

| Name | Summary |
|---|---|
| [connectionStateExt](connection-state-ext.md) | [androidJvm]<br>val [BluetoothAdapter](https://developer.android.com/reference/kotlin/android/bluetooth/BluetoothAdapter.html)?.[connectionStateExt](connection-state-ext.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>获取蓝牙适配器的连接状态 Get the connection state of the Bluetooth adapter |
| [isConnectedExt](is-connected-ext.md) | [androidJvm]<br>val [BluetoothDevice](https://developer.android.com/reference/kotlin/android/bluetooth/BluetoothDevice.html)?.[isConnectedExt](is-connected-ext.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>判断蓝牙设备是否已连接 Determine whether the Bluetooth device is connected |

## Functions

| Name | Summary |
|---|---|
| [getConnectionState](get-connection-state.md) | [androidJvm]<br>@[RequiresPermission](https://developer.android.com/reference/kotlin/androidx/annotation/RequiresPermission.html)(value = &quot;android.permission.BLUETOOTH_CONNECT&quot;)<br>fun [BluetoothAdapter](https://developer.android.com/reference/kotlin/android/bluetooth/BluetoothAdapter.html)?.[getConnectionState](get-connection-state.md)(profile: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>获取蓝牙适配器的连接状态 Get the connection state of the Bluetooth adapter |