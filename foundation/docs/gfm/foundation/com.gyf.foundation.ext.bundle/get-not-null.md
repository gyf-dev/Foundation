//[foundation](../../index.md)/[com.gyf.foundation.ext.bundle](index.md)/[getNotNull](get-not-null.md)

# getNotNull

[androidJvm]\
fun &lt;[D](get-not-null.md)&gt; [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html).[getNotNull](get-not-null.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), cla: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[D](get-not-null.md)&gt;, defaultValue: [D](get-not-null.md)): [D](get-not-null.md)

获取Bundle中的数据，结果不为null

#### Receiver

Bundle Bundle对象

#### Return

D 返回一个实际的对象

#### Parameters

androidJvm

| | |
|---|---|
| key | String 键 |
| cla | Class<D> 对象类型 |
| defaultValue | D 默认值 |

[androidJvm]\
inline fun &lt;[D](get-not-null.md)&gt; [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html).[getNotNull](get-not-null.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), defaultValue: [D](get-not-null.md)): [D](get-not-null.md)

获取Bundle中的数据，结果不为null

#### Receiver

Bundle Bundle对象

#### Return

D 返回一个实际的对象

#### Parameters

androidJvm

| | |
|---|---|
| key | String  键 |
| defaultValue | D 默认值 |