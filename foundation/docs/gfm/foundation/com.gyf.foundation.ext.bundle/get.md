//[foundation](../../index.md)/[com.gyf.foundation.ext.bundle](index.md)/[get](get.md)

# get

[androidJvm]\
fun &lt;[D](get.md)&gt; [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?.[get](get.md)(cla: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[D](get.md)&gt;, key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), defaultValue: [D](get.md)? = null): [D](get.md)?

获取Bundle中的数据

#### Receiver

Bundle? Bundle对象，如果为null，则返回null

#### Return

D? 返回一个实际的对象，可以为null

#### Parameters

androidJvm

| | |
|---|---|
| cla | Class<D> 对象类型 |
| key | String 键 |
| defaultValue | D? 默认值 |

[androidJvm]\
inline fun &lt;[D](get.md)&gt; [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?.[get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), defaultValue: [D](get.md)? = null): [D](get.md)?

获取Bundle中的数据

#### Receiver

Bundle? Bundle对象，如果为null，则返回null

#### Return

D? 返回一个实际的对象，可以为null

#### Parameters

androidJvm

| | |
|---|---|
| key | String 键 |
| defaultValue | D? 默认值 |

[androidJvm]\
inline fun &lt;[D](get.md)&gt; [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?.[get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), defaultValue: [D](get.md)? = null, block: [D](get.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [D](get.md)?