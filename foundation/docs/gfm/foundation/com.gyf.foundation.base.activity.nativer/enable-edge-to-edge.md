//[foundation](../../index.md)/[com.gyf.foundation.base.activity.nativer](index.md)/[enableEdgeToEdge](enable-edge-to-edge.md)

# enableEdgeToEdge

[androidJvm]\

@[JvmName](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-name/index.html)(name = &quot;enable&quot;)

@[JvmOverloads](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun [ComponentNativeActivity](-component-native-activity/index.md).[enableEdgeToEdge](enable-edge-to-edge.md)(statusBarStyle: [SystemBarStyle](-system-bar-style/index.md) = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT), navigationBarStyle: [SystemBarStyle](-system-bar-style/index.md) = SystemBarStyle.auto(DefaultLightScrim, DefaultDarkScrim))

Enables the edge-to-edge display for this [ComponentNativeActivity](-component-native-activity/index.md).

To set it up with the default style, call this method in your Activity's onCreate method:

```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        ...
    }
```

The default style configures the system bars with a transparent background when contrast can be enforced by the system (API 29 or above). On older platforms (which only have 3-button/2-button navigation modes), an equivalent scrim is applied to ensure contrast with the system bars.

See [SystemBarStyle](-system-bar-style/index.md) for more customization options.

#### Parameters

androidJvm

| | |
|---|---|
| statusBarStyle | The [SystemBarStyle](-system-bar-style/index.md) for the status bar. |
| navigationBarStyle | The [SystemBarStyle](-system-bar-style/index.md) for the navigation bar. |