package com.gyf.foundation.window.compose

import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.platform.ComposeView
import com.gyf.foundation.R
import com.gyf.foundation.window.ComponentWindow

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/1 10:20
 */
/**
 * Composes the given composable into the given window. The [content] will become the root view
 * of the given window.
 *
 * This is roughly equivalent to calling [ComponentWindow.setContentView] with a [ComposeView]
 * i.e.:
 *
 * ```
 * setContentView(
 *   ComposeView(this).apply {
 *     setContent {
 *       MyComposableContent()
 *     }
 *   }
 * )
 * ```
 *
 * @param parent The parent composition reference to coordinate scheduling of composition updates
 * @param content A `@Composable` function declaring the UI contents
 */
fun ComponentWindow.setContent(
    parent: CompositionContext? = null,
    content: @Composable () -> Unit
) {
    val existingComposeView = decorView
        .findViewById<ViewGroup>(R.id.window_decor_view)
        .getChildAt(0) as? ComposeView

    if (existingComposeView != null) with(existingComposeView) {
        setParentCompositionContext(parent)
        setContent(content)
    } else ComposeView(this).apply {
        // Set content and parent **before** setContentView
        // to have ComposeView create the composition on attach
        setParentCompositionContext(parent)
        setContent(content)
        setContentView(this, DefaultWindowContentLayoutParams)
    }
}

private val DefaultWindowContentLayoutParams = ViewGroup.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT,
    ViewGroup.LayoutParams.WRAP_CONTENT
)