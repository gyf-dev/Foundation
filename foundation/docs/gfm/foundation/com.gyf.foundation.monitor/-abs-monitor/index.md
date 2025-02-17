//[foundation](../../../index.md)/[com.gyf.foundation.monitor](../index.md)/[AbsMonitor](index.md)

# AbsMonitor

abstract class [AbsMonitor](index.md)&lt;[T](index.md)&gt;(defaultValue: [T](index.md)) : [ICoroutine](../../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md)

抽象监视器类 Abstract monitor class

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [ApplicationsMonitor](../../com.gyf.foundation.monitor.app/-applications-monitor/index.md) |
| [BluetoothMonitor](../../com.gyf.foundation.monitor.bluetooth/-bluetooth-monitor/index.md) |
| [ConfigurationMonitor](../../[root]/-configuration-monitor/index.md) |
| [NetworkFormatMonitor](../../com.gyf.foundation.monitor.net/-network-format-monitor/index.md) |
| [PhoneStateMonitor](../../com.gyf.foundation.monitor.phone/-phone-state-monitor/index.md) |
| [TimeMonitor](../../com.gyf.foundation.monitor.time/-time-monitor/index.md) |

## Constructors

| | |
|---|---|
| [AbsMonitor](-abs-monitor.md) | [androidJvm]<br>constructor(defaultValue: [T](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [value](value.md) | [androidJvm]<br>val [value](value.md): [StateFlowWrapper](../../com.gyf.foundation.ext.flow/-state-flow-wrapper/index.md)&lt;[T](index.md)&gt;<br>值属性，通过stateFlow获取值 Value property, get the default value through stateFlow |

## Functions

| Name | Summary |
|---|---|
| [onStateChanged](on-state-changed.md) | [androidJvm]<br>open override fun [onStateChanged](on-state-changed.md)(source: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html), event: [Lifecycle.Event](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.Event.html))<br>声明周期 |
| [start](start.md) | [androidJvm]<br>fun [start](start.md)()<br>启动方法 Start method |
| [stop](stop.md) | [androidJvm]<br>fun [stop](stop.md)()<br>停止方法 Stop method |