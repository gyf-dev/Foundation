//[foundation](../../../index.md)/[com.gyf.foundation.cs.aidl.client](../index.md)/[AidlClient](index.md)

# AidlClient

[androidJvm]\
open class [AidlClient](index.md) : [AbsClient](../../com.gyf.foundation.cs.common.client/-abs-client/index.md)

AidlClient类，继承自ContextWrapper，实现了IAidlClient和ICoroutine接口

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [AidlClient](-aidl-client.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [getProvider](get-provider.md) | [androidJvm]<br>open override fun [getProvider](get-provider.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), client: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)): [IClientProvider](../../com.gyf.foundation.cs.common.client.face/-i-client-provider/index.md)<br>获取客户端提供者 |