//[foundation](../../index.md)/[com.gyf.foundation.window.compose](index.md)/[setContent](set-content.md)

# setContent

[androidJvm]\
fun [ComponentWindow](../com.gyf.foundation.window/-component-window/index.md).[setContent](set-content.md)(parent: [CompositionContext](https://developer.android.com/reference/kotlin/androidx/compose/runtime/CompositionContext.html)? = null, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Composes the given composable into the given window. The [content](set-content.md) will become the root view of the given window.

This is roughly equivalent to calling [ComponentWindow.setContentView](../com.gyf.foundation.window/-component-window/set-content-view.md) with a [ComposeView](https://developer.android.com/reference/kotlin/androidx/compose/ui/platform/ComposeView.html) i.e.:

```kotlin
setContentView(
  ComposeView(this).apply {
    setContent {
      MyComposableContent()
    }
  }
)
```

#### Parameters

androidJvm

| | |
|---|---|
| parent | The parent composition reference to coordinate scheduling of composition updates |
| content | A `@Composable` function declaring the UI contents |