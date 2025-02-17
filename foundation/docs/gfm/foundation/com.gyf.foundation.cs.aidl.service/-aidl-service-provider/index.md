//[foundation](../../../index.md)/[com.gyf.foundation.cs.aidl.service](../index.md)/[AidlServiceProvider](index.md)

# AidlServiceProvider

[androidJvm]\
class [AidlServiceProvider](index.md)(iService: [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) : [AbsAidlServiceProvider](../-abs-aidl-service-provider/index.md)&lt;&lt;Error class: unknown class&gt;&gt; 

AidlServiceProvider类，实现了ICoroutine接口

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [AidlServiceProvider](-aidl-service-provider.md) | [androidJvm]<br>constructor(iService: [IService](../../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [binder](binder.md) | [androidJvm]<br>open override val [binder](binder.md): [IBinder](https://developer.android.com/reference/kotlin/android/os/IBinder.html)<br>绑定器 |

## Functions

| Name | Summary |
|---|---|
| [responseOn](response-on.md) | [androidJvm]<br>open override fun [responseOn](response-on.md)(item: &lt;Error class: unknown class&gt;, clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), newMessage: [Message](https://developer.android.com/reference/kotlin/android/os/Message.html)) |