//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[AppCompatNativeActivity](index.md)/[setSupportActionBar](set-support-action-bar.md)

# setSupportActionBar

[androidJvm]\
open fun [setSupportActionBar](set-support-action-bar.md)(@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)toolbar: [Toolbar](https://developer.android.com/reference/kotlin/androidx/appcompat/widget/Toolbar.html))

Set a [Toolbar](https://developer.android.com/reference/kotlin/android/widget/Toolbar.html) to act as the [ActionBar](https://developer.android.com/reference/kotlin/androidx/appcompat/app/ActionBar.html) for this Activity window. 

When set to a non-null value the [getActionBar](https://developer.android.com/reference/kotlin/android/app/Activity.html#getactionbar) method will return an [ActionBar](https://developer.android.com/reference/kotlin/androidx/appcompat/app/ActionBar.html) object that can be used to control the given toolbar as if it were a traditional window decor action bar. The toolbar's menu will be populated with the Activity's options menu and the navigation button will be wired through the standard [home](https://developer.android.com/reference/kotlin/android/R.id.html#home) menu select action.

In order to use a Toolbar within the Activity's window content the application must not request the window feature [FEATURE_SUPPORT_ACTION_BAR](https://developer.android.com/reference/kotlin/android/view/Window.html#feature_action_bar).

#### Parameters

androidJvm

| | |
|---|---|
| toolbar | Toolbar to set as the Activity's action bar, or `null` to clear it |