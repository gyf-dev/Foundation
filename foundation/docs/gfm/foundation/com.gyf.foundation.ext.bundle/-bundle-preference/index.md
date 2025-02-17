//[foundation](../../../index.md)/[com.gyf.foundation.ext.bundle](../index.md)/[BundlePreference](index.md)

# BundlePreference

class [BundlePreference](index.md)&lt;[T](index.md)&gt;(clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md)&gt;, bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?, key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, defaultValue: [T](index.md)? = null) : [ReadWriteProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.properties/-read-write-property/index.html)&lt;[Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, [T](index.md)&gt; 

Bundle委托类

#### Parameters

androidJvm

| | |
|---|---|
| T | 类型 |

## Constructors

| | |
|---|---|
| [BundlePreference](-bundle-preference.md) | [androidJvm]<br>constructor(clazz: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](index.md)&gt;, bundle: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?, key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, defaultValue: [T](index.md)? = null)<br>创建一个BundlePreference对象 |

## Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | [androidJvm]<br>open operator override fun [getValue](get-value.md)(thisRef: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md)<br>获取Bundle中的数据 |
| [setValue](set-value.md) | [androidJvm]<br>open operator override fun [setValue](set-value.md)(thisRef: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;, value: [T](index.md))<br>设置Bundle中的数据 |