//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[FragmentNativeActivity](index.md)/[FragmentNativeActivity](-fragment-native-activity.md)

# FragmentNativeActivity

[androidJvm]\
constructor()

Default constructor for FragmentGameActivity. All Activities must have a default constructor for API 27 and lower devices or when using the default [android.app.AppComponentFactory](https://developer.android.com/reference/kotlin/android/app/AppComponentFactory.html).

[androidJvm]\
constructor(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)contentLayoutId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))

Alternate constructor that can be used to provide a default layout that will be inflated as part of `super.onCreate(savedInstanceState)`. 

This should generally be called from your constructor that takes no parameters, as is required for API 27 and lower or when using the default [android.app.AppComponentFactory](https://developer.android.com/reference/kotlin/android/app/AppComponentFactory.html).

#### See also

| |
|---|
| [FragmentNativeActivity()](-fragment-native-activity.md) |