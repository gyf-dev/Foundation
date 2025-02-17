//[foundation](../../index.md)/[com.gyf.foundation.ext.json](index.md)/[toTarget](to-target.md)

# toTarget

[androidJvm]\
fun &lt;[T](to-target.md), [D](to-target.md)&gt; [T](to-target.md).[toTarget](to-target.md)(original: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](to-target.md)&gt;, target: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[D](to-target.md)&gt;, defaultIfNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, serializeNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [D](to-target.md)?

类型转换

#### Receiver

T 原始对象

#### Return

D? 目标对象

#### Parameters

androidJvm

| | |
|---|---|
| original | Class<T> 原始对象的类型 |
| target | Class<D> 目标对象的类型 |
| defaultIfNulls | Boolean 如果json字段的值为null，将使用默认值 |
| serializeNulls | Boolean 是否序列化字段为null的值 |

[androidJvm]\
inline fun &lt;[T](to-target.md), [D](to-target.md)&gt; [T](to-target.md).[toTarget](to-target.md)(defaultIfNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, serializeNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [D](to-target.md)?

类型转换

#### Receiver

T 原始对象

#### Return

D?

#### Parameters

androidJvm

| | |
|---|---|
| defaultIfNulls | Boolean 如果json字段的值为null，将使用默认值 |
| serializeNulls | Boolean 是否序列化字段为null的值 |

[androidJvm]\
inline fun &lt;[T](to-target.md), [D](to-target.md)&gt; [T](to-target.md).[toTarget](to-target.md)(original: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](to-target.md)&gt;, defaultIfNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, serializeNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [D](to-target.md)?

类型转换

#### Receiver

T 原始对象

#### Return

D?

#### Parameters

androidJvm

| | |
|---|---|
| original | Class<T> 原始对象的类型 |
| defaultIfNulls | Boolean 如果json字段的值为null，将使用默认值 |
| serializeNulls | Boolean 是否序列化字段为null的值 |