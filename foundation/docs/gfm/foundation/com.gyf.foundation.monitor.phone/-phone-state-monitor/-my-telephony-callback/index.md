//[foundation](../../../../index.md)/[com.gyf.foundation.monitor.phone](../../index.md)/[PhoneStateMonitor](../index.md)/[MyTelephonyCallback](index.md)

# MyTelephonyCallback

[androidJvm]\
@[RequiresApi](https://developer.android.com/reference/kotlin/androidx/annotation/RequiresApi.html)(value = 31)

inner class [MyTelephonyCallback](index.md) : [TelephonyCallback](https://developer.android.com/reference/kotlin/android/telephony/TelephonyCallback.html), [TelephonyCallback.CallStateListener](https://developer.android.com/reference/kotlin/android/telephony/TelephonyCallback.CallStateListener.html)

自定义电话回调类，用于处理电话状态的变化 Custom telephony callback class, used to handle changes in phone state

## Constructors

| | |
|---|---|
| [MyTelephonyCallback](-my-telephony-callback.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [onCallStateChanged](on-call-state-changed.md) | [androidJvm]<br>open override fun [onCallStateChanged](on-call-state-changed.md)(state: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |