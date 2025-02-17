//[foundation](../../index.md)/[com.gyf.foundation.ext.view.click](index.md)/[onClick](on-click.md)

# onClick

[androidJvm]\
fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[onClick](on-click.md)(listener: [View.OnClickListener](https://developer.android.com/reference/kotlin/android/view/View.OnClickListener.html))

点击事件的扩展函数

#### Receiver

View 当前的视图对象

#### Parameters

androidJvm

| | |
|---|---|
| listener | View.OnClickListener 点击事件的监听器 |

[androidJvm]\
fun [View](https://developer.android.com/reference/kotlin/android/view/View.html).[onClick](on-click.md)(interval: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = repeatClickInterval, method: ([View](https://developer.android.com/reference/kotlin/android/view/View.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

点击事件的扩展函数

#### Receiver

View 当前的视图对象

#### Parameters

androidJvm

| | |
|---|---|
| interval | Long 两次点击之间的最小间隔时间，以毫秒为单位。默认值为repeatClickInterval。 |
| method | Function1<View, Unit> 如果可以点击，则执行此函数。 |