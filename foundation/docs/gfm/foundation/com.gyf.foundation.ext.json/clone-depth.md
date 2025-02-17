//[foundation](../../index.md)/[com.gyf.foundation.ext.json](index.md)/[cloneDepth](clone-depth.md)

# cloneDepth

[androidJvm]\
fun &lt;[T](clone-depth.md)&gt; [T](clone-depth.md).[cloneDepth](clone-depth.md)(clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](clone-depth.md)&gt;, size: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), defaultIfNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, serializeNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](clone-depth.md)&gt;

深度克隆

#### Receiver

T 克隆对象

#### Return

List<T>

#### Parameters

androidJvm

| | |
|---|---|
| clazz | Class<T> 克隆对象的类型 |
| size | Int 克隆的个数 |
| defaultIfNulls | Boolean 如果json字段的值为null，将使用默认值 |
| serializeNulls | Boolean 是否序列化字段为null的值 |

[androidJvm]\
fun &lt;[T](clone-depth.md)&gt; [T](clone-depth.md).[cloneDepth](clone-depth.md)(clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](clone-depth.md)&gt;): [T](clone-depth.md)

深度克隆

#### Receiver

T 克隆对象

#### Return

T

#### Parameters

androidJvm

| | |
|---|---|
| clazz | Class<T> 克隆对象的类型 |

[androidJvm]\
inline fun &lt;[T](clone-depth.md)&gt; [T](clone-depth.md).[cloneDepth](clone-depth.md)(size: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), defaultIfNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, serializeNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](clone-depth.md)&gt;

深度克隆

#### Receiver

T 克隆对象

#### Return

List<T>

#### Parameters

androidJvm

| | |
|---|---|
| size | Int 克隆的个数 |
| defaultIfNulls | Boolean 如果json字段的值为null，将使用默认值 |
| serializeNulls | Boolean 是否序列化字段为null的值 |

[androidJvm]\
inline fun &lt;[T](clone-depth.md)&gt; [T](clone-depth.md).[cloneDepth](clone-depth.md)(defaultIfNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, serializeNulls: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [T](clone-depth.md)

深度克隆

#### Receiver

T

#### Return

T

#### Parameters

androidJvm

| | |
|---|---|
| defaultIfNulls | Boolean 如果json字段的值为null，将使用默认值 |
| serializeNulls | Boolean 是否序列化字段为null的值 |