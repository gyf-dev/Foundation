//[foundation](../../../index.md)/[com.gyf.foundation.window.delegate](../index.md)/[IComponentRegistry](index.md)

# IComponentRegistry

interface [IComponentRegistry](index.md)

#### Author

Ifan.Ge

#### Inheritors

| |
|---|
| [IComponent](../-i-component/index.md) |

## Functions

| Name | Summary |
|---|---|
| [configurationChanged](configuration-changed.md) | [androidJvm]<br>open fun [configurationChanged](configuration-changed.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), newConfig: [Configuration](https://developer.android.com/reference/kotlin/android/content/res/Configuration.html)) |
| [create](create.md) | [androidJvm]<br>open fun [create](create.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), savedInstanceState: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?) |
| [destroy](destroy.md) | [androidJvm]<br>open fun [destroy](destroy.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [newIntent](new-intent.md) | [androidJvm]<br>open fun [newIntent](new-intent.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), intent: [WindowIntent](../../com.gyf.foundation.window.intent/-window-intent/index.md)) |
| [pause](pause.md) | [androidJvm]<br>open fun [pause](pause.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [resume](resume.md) | [androidJvm]<br>open fun [resume](resume.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [saveInstanceState](save-instance-state.md) | [androidJvm]<br>open fun [saveInstanceState](save-instance-state.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), outState: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)) |
| [start](start.md) | [androidJvm]<br>open fun [start](start.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [stop](stop.md) | [androidJvm]<br>open fun [stop](stop.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [trimMemory](trim-memory.md) | [androidJvm]<br>open fun [trimMemory](trim-memory.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), level: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |