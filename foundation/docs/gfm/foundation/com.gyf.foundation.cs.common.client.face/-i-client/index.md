//[foundation](../../../index.md)/[com.gyf.foundation.cs.common.client.face](../index.md)/[IClient](index.md)

# IClient

interface [IClient](index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [AbsClient](../../com.gyf.foundation.cs.common.client/-abs-client/index.md) |

## Properties

| Name | Summary |
|---|---|
| [isConnected](is-connected.md) | [androidJvm]<br>abstract val [isConnected](is-connected.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>是否已连接 |

## Functions

| Name | Summary |
|---|---|
| [connect](connect.md) | [androidJvm]<br>abstract fun [connect](connect.md)(flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>绑定客户端 |
| [create](create.md) | [androidJvm]<br>abstract fun [create](create.md)()<br>创建客户端 |
| [destroy](destroy.md) | [androidJvm]<br>abstract fun [destroy](destroy.md)()<br>销毁客户端 |
| [disconnect](disconnect.md) | [androidJvm]<br>abstract fun [disconnect](disconnect.md)()<br>解绑客户端 |