//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client.face](../index.md)/[IClientBind](index.md)

# IClientBind

interface [IClientBind](index.md)

IClientBind接口，定义了一系列与客户端绑定相关的方法

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [IClientProvider](../-i-client-provider/index.md) |

## Properties

| Name | Summary |
|---|---|
| [isConnected](is-connected.md) | [androidJvm]<br>abstract val [isConnected](is-connected.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否已连接 |

## Functions

| Name | Summary |
|---|---|
| [connect](connect.md) | [androidJvm]<br>abstract fun [connect](connect.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>绑定客户端 |
| [create](create.md) | [androidJvm]<br>abstract fun [create](create.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>创建客户端 |
| [destroy](destroy.md) | [androidJvm]<br>abstract fun [destroy](destroy.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>销毁客户端 |
| [disconnect](disconnect.md) | [androidJvm]<br>abstract fun [disconnect](disconnect.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>解绑客户端 |