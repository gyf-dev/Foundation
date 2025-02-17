//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client.face](../index.md)/[ClientProviderOwner](index.md)

# ClientProviderOwner

interface [ClientProviderOwner](index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AbsClient](../../com.gyf.foundation.cs.common.client/-abs-client/index.md) |

## Properties

| Name | Summary |
|---|---|
| [provider](provider.md) | [androidJvm]<br>abstract val [provider](provider.md): [IClientProvider](../-i-client-provider/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getProvider](get-provider.md) | [androidJvm]<br>abstract fun [getProvider](get-provider.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), client: [ClientCallback](../../com.gyf.foundation.cs.common.client.callback/-client-callback/index.md)): [IClientProvider](../-i-client-provider/index.md)<br>获取客户端提供者 |