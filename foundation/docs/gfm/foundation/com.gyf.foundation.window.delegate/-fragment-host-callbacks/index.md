//[foundation](../../../index.md)/[com.gyf.foundation.window.delegate](../index.md)/[FragmentHostCallbacks](index.md)

# FragmentHostCallbacks

[androidJvm]\
open class [FragmentHostCallbacks](index.md)&lt;[E](index.md) : [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), [IComponent](../-i-component/index.md)&gt;(owner: [E](index.md), windowAnimations: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0) : [FragmentHostCallback](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentHostCallback.html)&lt;[E](index.md)&gt; , [IComponent](../-i-component/index.md)

#### Author

Ifan.Ge

## Constructors

| | |
|---|---|
| [FragmentHostCallbacks](-fragment-host-callbacks.md) | [androidJvm]<br>constructor(owner: [E](index.md), windowAnimations: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0) |

## Functions

| Name | Summary |
|---|---|
| [onGetHost](on-get-host.md) | [androidJvm]<br>open override fun [onGetHost](on-get-host.md)(): [E](index.md) |