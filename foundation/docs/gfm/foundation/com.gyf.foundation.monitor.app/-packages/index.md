//[foundation](../../../index.md)/[com.gyf.foundation.monitor.app](../index.md)/[Packages](index.md)

# Packages

[androidJvm]\
data class [Packages](index.md)(val blacklist: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Packages.PackageInfo](-package-info/index.md)&gt; = listOf(), val whitelist: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Packages.PackageInfo](-package-info/index.md)&gt; = listOf(), val sortListByName: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; = listOf(), val sortListByClassName: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; = listOf())

包数据类 Packages data class

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [Packages](-packages.md) | [androidJvm]<br>constructor(blacklist: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Packages.PackageInfo](-package-info/index.md)&gt; = listOf(), whitelist: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Packages.PackageInfo](-package-info/index.md)&gt; = listOf(), sortListByName: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; = listOf(), sortListByClassName: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; = listOf()) |

## Types

| Name | Summary |
|---|---|
| [PackageInfo](-package-info/index.md) | [androidJvm]<br>data class [PackageInfo](-package-info/index.md)(val pkgName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, val clsName: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; = emptyList()) |

## Properties

| Name | Summary |
|---|---|
| [blacklist](blacklist.md) | [androidJvm]<br>val [blacklist](blacklist.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Packages.PackageInfo](-package-info/index.md)&gt; |
| [sortListByClassName](sort-list-by-class-name.md) | [androidJvm]<br>val [sortListByClassName](sort-list-by-class-name.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; |
| [sortListByName](sort-list-by-name.md) | [androidJvm]<br>val [sortListByName](sort-list-by-name.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; |
| [whitelist](whitelist.md) | [androidJvm]<br>val [whitelist](whitelist.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Packages.PackageInfo](-package-info/index.md)&gt; |