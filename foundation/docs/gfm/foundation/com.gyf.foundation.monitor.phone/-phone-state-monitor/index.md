//[foundation](../../../index.md)/[com.gyf.foundation.monitor.phone](../index.md)/[PhoneStateMonitor](index.md)

# PhoneStateMonitor

[androidJvm]\
class [PhoneStateMonitor](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AbsMonitor](../../com.gyf.foundation.monitor/-abs-monitor/index.md)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt; 

PhoneStateMonitor类，用于监控电话状态的变化 PhoneStateMonitor class, used to monitor changes in phone state

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [PhoneStateMonitor](-phone-state-monitor.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
| [MyPhoneStateListener](-my-phone-state-listener/index.md) | [androidJvm]<br>inner class [MyPhoneStateListener](-my-phone-state-listener/index.md) : [PhoneStateListener](https://developer.android.com/reference/kotlin/android/telephony/PhoneStateListener.html)<br>自定义电话状态监听器类，用于处理电话状态的变化 Custom phone state listener class, used to handle changes in phone state |
| [MyTelephonyCallback](-my-telephony-callback/index.md) | [androidJvm]<br>@[RequiresApi](https://developer.android.com/reference/kotlin/androidx/annotation/RequiresApi.html)(value = 31)<br>inner class [MyTelephonyCallback](-my-telephony-callback/index.md) : [TelephonyCallback](https://developer.android.com/reference/kotlin/android/telephony/TelephonyCallback.html), [TelephonyCallback.CallStateListener](https://developer.android.com/reference/kotlin/android/telephony/TelephonyCallback.CallStateListener.html)<br>自定义电话回调类，用于处理电话状态的变化 Custom telephony callback class, used to handle changes in phone state |