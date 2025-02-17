//[foundation](../../../index.md)/[com.gyf.foundation.base.activity.nativer](../index.md)/[ComponentNativeActivity](index.md)/[getLifecycle](get-lifecycle.md)

# getLifecycle

[androidJvm]\

@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)

open fun [getLifecycle](get-lifecycle.md)(): [Lifecycle](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.html)

 Overriding this method is no longer supported and this method will be made `final` in a future version of If you do override this method, you `must`: 

1. Return an instance of [LifecycleRegistry](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleRegistry.html)
2. Lazily initialize your LifecycleRegistry object when this is first called. Note that this method will be called in the super classes' constructor, before any field initialization or object state creation is complete.