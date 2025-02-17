package com.gyf.foundation.ext.markdown

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.Layout
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.LeadingMarginSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.Px
import com.bumptech.glide.Glide
import com.gyf.foundation.R
import com.gyf.foundation.ext.dp.dp
import com.gyf.foundation.ext.resources.drawableRes
import com.gyf.foundation.ext.view.getTag
import io.noties.markwon.AbstractMarkwonPlugin
import io.noties.markwon.Markwon
import io.noties.markwon.MarkwonSpansFactory
import io.noties.markwon.ext.latex.JLatexMathPlugin
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin
import io.noties.markwon.ext.tables.TablePlugin
import io.noties.markwon.ext.tasklist.TaskListPlugin
import io.noties.markwon.html.HtmlPlugin
import io.noties.markwon.image.ImagesPlugin
import io.noties.markwon.image.glide.GlideImagesPlugin
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin
import io.noties.markwon.linkify.LinkifyPlugin
import io.noties.markwon.movement.MovementMethodPlugin
import io.noties.markwon.syntax.Prism4jThemeDarkula
import io.noties.markwon.syntax.SyntaxHighlightPlugin
import io.noties.markwon.utils.LeadingMarginUtils
import io.noties.prism4j.Prism4j
import io.noties.prism4j.annotations.PrismBundle
import org.commonmark.node.FencedCodeBlock

/**
 * @Author  Ifan.Ge
 * @Date    2024/9/11 9:14
 */

var TextView.markdown: CharSequence
    get() = markwon.toMarkdown(text.toString())
    set(value) = setMarkdown(value)

fun TextView.setMarkdown(text: CharSequence, calibrateLatex: Boolean = true) {
    val charSequence = if (calibrateLatex) text.convertSingleToDoubleDollars() else text
    markwon.setMarkdown(this, charSequence.toString())
}

val TextView.markwon: Markwon get() = obtainMarkdown().markwon

fun TextView.obtainMarkdown(latexSize: Float = textSize, codeCopy: (String) -> Unit = {}) =
    getTag<Markdown>(R.id.so_markdown) { Markdown(context, latexSize) }
        .also { it.codeCopy = codeCopy }

private fun CharSequence.convertSingleToDoubleDollars(): CharSequence {
    // 匹配成对的 $，确保它们前后不包含其他 $
    try {
        val regex = """(?<!\$)\$(?!\$)(.+?)(?<!\$)\$(?!\$)""".toRegex()
        return regex.replace(this) { matchResult ->
            // 将匹配到的内容用双 $ 包裹
            val matchedText = matchResult.groupValues[1]
            "\$\$${matchedText}\$\$"
        }
    } catch (e: Exception) {
        return this
    }
}

@PrismBundle(includeAll = true)
class Markdown(context: Context, @Px latexSize: Float) {
    private val prism4j = Prism4j(GrammarLocatorDef())
    private val prism4jTheme = Prism4jThemeDarkula.create()
    var codeCopy: (String) -> Unit = {}
    val markwon = Markwon.builder(context)
        .usePlugin(StrikethroughPlugin.create())
        .usePlugin(TablePlugin.create(context))
        .usePlugin(TaskListPlugin.create(context))
        .usePlugin(HtmlPlugin.create())
        .usePlugin(MovementMethodPlugin.link())
        .usePlugin(LinkifyPlugin.create())
        .usePlugin(SyntaxHighlightPlugin.create(prism4j, prism4jTheme))
        .usePlugin(ImagesPlugin.create())
        .usePlugin(GlideImagesPlugin.create(Glide.with(context)))
        .usePlugin(MarkwonInlineParserPlugin.create())
        .usePlugin(JLatexMathPlugin.create(latexSize) { builder ->
            builder.inlinesEnabled(true)
        })
        .usePlugin(object : AbstractMarkwonPlugin() {
            override fun configureSpansFactory(builder: MarkwonSpansFactory.Builder) {
                builder
                    .appendFactory(FencedCodeBlock::class.java) { _, _ ->
                        CopyContentsSpan(codeCopy)
                    }
                    .appendFactory(FencedCodeBlock::class.java) { _, _ ->
                        CopyIconSpan(R.drawable.ic_copy.drawableRes)
                    }
            }
        })
        .build()

    inner class CopyContentsSpan(private val codeCopy: (String) -> Unit) : ClickableSpan() {

        override fun onClick(widget: View) {
            val spanned = (widget as? TextView)?.text as? Spanned ?: return
            val start = spanned.getSpanStart(this)
            val end = spanned.getSpanEnd(this)
            // by default code blocks have new lines before and after content
            val contents = spanned.subSequence(start, end).toString().trim()
            codeCopy(contents)
        }

        override fun updateDrawState(ds: TextPaint) {
            // do not apply link styling
        }
    }

    inner class CopyIconSpan(private val icon: Drawable) : LeadingMarginSpan {

        init {
            if (icon.bounds.isEmpty) {
                icon.setBounds(0, 0, icon.intrinsicWidth, icon.intrinsicHeight)
            }
        }

        override fun getLeadingMargin(first: Boolean): Int = 0

        override fun drawLeadingMargin(
            c: Canvas,
            p: Paint,
            x: Int,
            dir: Int,
            top: Int,
            baseline: Int,
            bottom: Int,
            text: CharSequence,
            start: Int,
            end: Int,
            first: Boolean,
            layout: Layout
        ) {

            // called for each line of text, we are interested only in first one
            if (!LeadingMarginUtils.selfStart(start, text, this)) return

            val save = c.save()
            try {
                // horizontal position for icon
                val w = icon.bounds.width().toFloat()
                // minus quarter width as padding
                val left = layout.width - w - 6.dp
                c.translate(left, top.toFloat() + 6.dp)
                icon.draw(c)
            } finally {
                c.restoreToCount(save)
            }
        }
    }
}