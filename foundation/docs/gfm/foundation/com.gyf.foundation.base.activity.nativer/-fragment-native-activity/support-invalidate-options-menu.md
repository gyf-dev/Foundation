//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[supportInvalidateOptionsMenu](support-invalidate-options-menu.md)

# supportInvalidateOptionsMenu

[androidJvm]\
open fun [~~supportInvalidateOptionsMenu~~](support-invalidate-options-menu.md)()

---

### Deprecated

Call [invalidateOptionsMenu](https://developer.android.com/reference/kotlin/android/app/Activity.html#invalidateoptionsmenu) directly.

---

Support library version of [invalidateOptionsMenu](https://developer.android.com/reference/kotlin/android/app/Activity.html#invalidateoptionsmenu). 

Invalidate the activity's options menu. This will cause relevant presentations of the menu to fully update via calls to onCreateOptionsMenu and onPrepareOptionsMenu the next time the menu is requested.