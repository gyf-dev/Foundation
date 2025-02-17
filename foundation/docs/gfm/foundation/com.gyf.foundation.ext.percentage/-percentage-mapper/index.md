//[foundation](../../../index.md)/[com.gyf.foundation.ext.percentage](../index.md)/[PercentageMapper](index.md)

# PercentageMapper

[androidJvm]\
object [PercentageMapper](index.md)

百分比映射器 Percentage Mapper

这个类提供了两个主要的功能：

1. 
   将一个值映射为百分比
2. 
   根据百分比计算对应的值

This class provides two main functions:

1. 
   Maps a value to a percentage
2. 
   Calculates the corresponding value based on the percentage

#### Author

Ifan.Ge

## Functions

| Name | Summary |
|---|---|
| [from](from.md) | [androidJvm]<br>fun [from](from.md)(minValue: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html), maxValue: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html), percentage: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)): [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)<br>根据百分比计算对应的值 Calculates the corresponding value based on the percentage<br>[androidJvm]<br>fun [from](from.md)(minValue: [Number](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-number/index.html), maxValue: [Number](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-number/index.html), percentage: [Number](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-number/index.html)): [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)<br>根据百分比计算对应的值，接受Number类型的参数 Calculates the corresponding value based on the percentage, accepts parameters of Number type |
| [to](to.md) | [androidJvm]<br>fun [to](to.md)(minValue: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html), maxValue: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html), currentValue: [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)): [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)<br>fun [to](to.md)(minValue: [Number](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-number/index.html), maxValue: [Number](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-number/index.html), currentValue: [Number](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-number/index.html)): [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html)<br>将当前值映射为百分比 Maps the current value to a percentage |