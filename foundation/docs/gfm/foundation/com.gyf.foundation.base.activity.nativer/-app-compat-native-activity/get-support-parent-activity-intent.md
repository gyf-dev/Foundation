//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[getSupportParentActivityIntent](get-support-parent-activity-intent.md)

# getSupportParentActivityIntent

[androidJvm]\

@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)

open fun [getSupportParentActivityIntent](get-support-parent-activity-intent.md)(): [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)

Obtain an [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html) that will launch an explicit target activity specified by sourceActivity's [PARENT_ACTIVITY](https://developer.android.com/reference/kotlin/androidx/core/app/NavUtils.html#parent_activity)<meta-data> element in the application's manifest. If the device is running Jellybean or newer, the android:parentActivityName attribute will be preferred if it is present.

#### Return

a new Intent targeting the defined parent activity of sourceActivity