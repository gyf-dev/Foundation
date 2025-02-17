//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[ComponentNativeActivity](index.md)/[onRequestPermissionsResult](on-request-permissions-result.md)

# onRequestPermissionsResult

[androidJvm]\

@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)

open fun [~~onRequestPermissionsResult~~](on-request-permissions-result.md)(requestCode: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), @[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)permissions: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;, @[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)grantResults: [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)&gt;)

---

### Deprecated

This method has been deprecated in favor of using the Activity Result API which brings increased type safety via an [ActivityResultContract](https://developer.android.com/reference/kotlin/androidx/activity/result/contract/ActivityResultContract.html) and the prebuilt contracts for common intents available in [ActivityResultContracts](https://developer.android.com/reference/kotlin/androidx/activity/result/contract/ActivityResultContracts.html), provides hooks for testing, and allow receiving results in separate, testable classes independent from your activity. Use [registerForActivityResult](register-for-activity-result.md) passing in a [ActivityResultContracts.RequestMultiplePermissions](https://developer.android.com/reference/kotlin/androidx/activity/result/contract/ActivityResultContracts.RequestMultiplePermissions.html) object for the [ActivityResultContract](https://developer.android.com/reference/kotlin/androidx/activity/result/contract/ActivityResultContract.html) and handling the result in the [callback](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultCallback.html#onactivityresult).

---