//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[ComponentNativeActivity](index.md)/[onRetainNonConfigurationInstance](on-retain-non-configuration-instance.md)

# onRetainNonConfigurationInstance

[androidJvm]\

@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)

fun [onRetainNonConfigurationInstance](on-retain-non-configuration-instance.md)(): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)

Retain all appropriate non-config state. You can NOT override this yourself! Use a [androidx.lifecycle.ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) if you want to retain your own non config state.