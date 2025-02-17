//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[supportRequestWindowFeature](support-request-window-feature.md)

# supportRequestWindowFeature

[androidJvm]\
open fun [supportRequestWindowFeature](support-request-window-feature.md)(featureId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Enable extended support library window features. 

 This is a convenience for calling [getWindow().requestFeature()](https://developer.android.com/reference/kotlin/android/view/Window.html#requestfeature). 

#### Return

Returns true if the requested feature is supported and now enabled.

#### Parameters

androidJvm

| | |
|---|---|
| featureId | The desired feature as defined in [Window](https://developer.android.com/reference/kotlin/android/view/Window.html) or [androidx.core.view.WindowCompat](https://developer.android.com/reference/kotlin/androidx/core/view/WindowCompat.html). |

#### See also

| |
|---|
| [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html#requestwindowfeature) |
| [Window](https://developer.android.com/reference/kotlin/android/view/Window.html#requestfeature) |