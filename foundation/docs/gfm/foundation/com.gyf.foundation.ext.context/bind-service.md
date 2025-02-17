//[foundation](../../index.md)/[com.gyf.foundation.ext.context](index.md)/[bindService](bind-service.md)

# bindService

[androidJvm]\
fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[bindService](bind-service.md)(action: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), connection: [ServiceConnection](https://developer.android.com/reference/kotlin/android/content/ServiceConnection.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

绑定服务的扩展函数。

#### Return

如果成功启动并绑定服务，则返回true，否则返回false。

#### Parameters

androidJvm

| | |
|---|---|
| action | 服务的action。 |
| connection | 服务连接对象。 |