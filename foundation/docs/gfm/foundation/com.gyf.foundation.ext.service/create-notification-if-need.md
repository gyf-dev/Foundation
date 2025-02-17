//[foundation](../../index.md)/[com.gyf.foundation.ext.service](index.md)/[createNotificationIfNeed](create-notification-if-need.md)

# createNotificationIfNeed

[androidJvm]\
fun [Service](https://developer.android.com/reference/kotlin/android/app/Service.html).[createNotificationIfNeed](create-notification-if-need.md)(@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)icon: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), id: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = Random.nextInt(1, Int.MAX_VALUE), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = this::class.java.simpleName, text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = this::class.java.simpleName, channelId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = this::class.java.simpleName, channelName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = this::class.java.simpleName)

如果需要，创建通知的扩展函数。

#### Parameters

androidJvm

| | |
|---|---|
| icon | 通知的图标。 |
| id | 通知的ID，默认为1到Int.MAX_VALUE的随机数。 |
| title | 通知的标题，默认为调用此函数的类的简单名称。 |
| text | 通知的文本内容，默认为调用此函数的类的简单名称。 |
| channelId | 通知频道的ID，默认为调用此函数的类的简单名称。 |
| channelName | 通知频道的名称，默认为调用此函数的类的简单名称。 |