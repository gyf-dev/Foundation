//[foundation](../../index.md)/[com.gyf.foundation.cs.common.client.ext](index.md)/[connectAidlService](connect-aidl-service.md)

# connectAidlService

[androidJvm]\

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

inline fun &lt;[S](connect-aidl-service.md) : [AidlService](../com.gyf.foundation.cs.aidl.service/-aidl-service/index.md)&gt; [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[connectAidlService](connect-aidl-service.md)(clientTag: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), flags: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Context.BIND_AUTO_CREATE, noinline block: [AbsClient](../com.gyf.foundation.cs.common.client/-abs-client/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null): [AidlClient](../com.gyf.foundation.cs.aidl.client/-aidl-client/index.md)

绑定Aidl服务 Bind Aidl service

#### Return

AidlClient 返回绑定的Aidl服务     Return the bound Aidl service

#### Parameters

androidJvm

| | |
|---|---|
| clientTag | 客户端标签     Client tag |
| block | AbsClient.() -> Unit 代码块     Code block |