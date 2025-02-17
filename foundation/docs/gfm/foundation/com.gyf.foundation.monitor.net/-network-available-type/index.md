//[foundation](../../../index.md)/[com.gyf.foundation.monitor.net](../index.md)/[NetworkAvailableType](index.md)

# NetworkAvailableType

[androidJvm]\
enum [NetworkAvailableType](index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[NetworkAvailableType](index.md)&gt; 

网络可用类型枚举类 Network available type enumeration class

#### Author

Ifan.Ge

## Entries

| | |
|---|---|
| [NONE](-n-o-n-e/index.md) | [androidJvm]<br>[NONE](-n-o-n-e/index.md)<br>表示没有连接网络 Indicates no network connection |
| [UNAVAILABLE](-u-n-a-v-a-i-l-a-b-l-e/index.md) | [androidJvm]<br>[UNAVAILABLE](-u-n-a-v-a-i-l-a-b-l-e/index.md)<br>表示已连接网络，但网络不可用 Indicates network is connected, but not available |
| [AVAILABLE](-a-v-a-i-l-a-b-l-e/index.md) | [androidJvm]<br>[AVAILABLE](-a-v-a-i-l-a-b-l-e/index.md)<br>表示已连接网络，并且网络可用 Indicates network is connected and available |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [androidJvm]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.enums/-enum-entries/index.html)&lt;[NetworkAvailableType](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [androidJvm]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [NetworkAvailableType](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [androidJvm]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[NetworkAvailableType](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |