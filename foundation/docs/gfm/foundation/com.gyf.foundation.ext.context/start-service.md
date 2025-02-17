//[foundation](../../index.md)/[com.gyf.foundation.ext.context](index.md)/[startService](start-service.md)

# startService

[androidJvm]\
inline fun &lt;[T](start-service.md)&gt; [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[startService](start-service.md)(): [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)

启动指定服务的扩展函数。

#### Return

启动的服务的Intent。

[androidJvm]\
fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[startService](start-service.md)(action: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)?

通过action启动服务的扩展函数。

#### Return

启动的服务的Intent，如果无法创建显式Intent，则返回null。

#### Parameters

androidJvm

| | |
|---|---|
| action | 服务的action。 |

[androidJvm]\
fun [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).[startService](start-service.md)(vararg actions: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))

启动多个action对应的服务的扩展函数。

#### Parameters

androidJvm

| | |
|---|---|
| actions | 服务的action数组。 |