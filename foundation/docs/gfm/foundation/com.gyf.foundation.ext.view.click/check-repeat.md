//[foundation](../../index.md)/[com.gyf.foundation.ext.view.click](index.md)/[checkRepeat](check-repeat.md)

# checkRepeat

[androidJvm]\
fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[checkRepeat](check-repeat.md)(interval: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = repeatClickInterval): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

判断是否可以点击

#### Receiver

View 当前的视图对象

#### Return

Boolean 如果当前时间与上次点击时间的差值大于或等于间隔时间，则返回true，否则返回false。

#### Parameters

androidJvm

| | |
|---|---|
| interval | Long 两次点击之间的最小间隔时间，以毫秒为单位。默认值为repeatClickInterval。 |

[androidJvm]\
fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[checkRepeat](check-repeat.md)(interval: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = repeatClickInterval, method: ([View](https://developer.android.com/reference/kotlin/android/view/View.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

判断可以点击后做xxx

#### Receiver

View 当前的视图对象

#### Parameters

androidJvm

| | |
|---|---|
| interval | Long 两次点击之间的最小间隔时间，以毫秒为单位。默认值为repeatClickInterval。 |
| method | Function1<View, Unit> 如果可以点击，则执行此函数。 |