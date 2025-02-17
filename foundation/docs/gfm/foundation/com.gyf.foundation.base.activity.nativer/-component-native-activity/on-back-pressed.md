//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[ComponentNativeActivity](index.md)/[onBackPressed](on-back-pressed.md)

# onBackPressed

[androidJvm]\

@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)

@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)

open fun [~~onBackPressed~~](on-back-pressed.md)()

---

### Deprecated

This method has been deprecated in favor of using the [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html) via [getOnBackPressedDispatcher](get-on-back-pressed-dispatcher.md). The OnBackPressedDispatcher controls how back button events are dispatched to one or more [OnBackPressedCallback](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedCallback.html) objects.

---

Called when the activity has detected the user's press of the back key. The [OnBackPressedDispatcher](get-on-back-pressed-dispatcher.md) will be given a chance to handle the back button before the default behavior of [onBackPressed](https://developer.android.com/reference/kotlin/android/app/Activity.html#onbackpressed) is invoked.

#### See also

| |
|---|
| [getOnBackPressedDispatcher()](get-on-back-pressed-dispatcher.md) |