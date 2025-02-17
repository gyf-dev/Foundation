package com.gyf.foundation.helper

import android.os.Handler
import android.os.Looper
import com.gyf.foundation.ext.coroutine.ICoroutine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * 打字机效果类，用于实现文本的逐字显示动画效果。
 * Typewriter effect class for implementing character-by-character text animation.
 */
class TypewriterEffectHelper(
    /**
     * 打字延迟时间，控制动画速度。
     * Typing delay time in milliseconds, controls the speed of the animation.
     * @param typingDelay Long 打字延迟时间
     */
    var typingDelay: Long = 30L,

    /**
     * 文本更新时的回调函数。
     * Callback function for text updates.
     * @param onUpdateText ((CharSequence) -> Unit)? 文本更新回调
     */
    var onUpdateText: ((CharSequence) -> Unit)? = null,

    /**
     * 动画完成时的回调函数。
     * Callback function when the animation is complete.
     * @param onComplete (() -> Unit)? 动画完成回调
     */
    var onComplete: (() -> Unit)? = null,

    /**
     * 新行开始时的回调函数。
     * Callback function when a new line starts.
     * @param onNewLine (() -> Unit)? 新行开始回调
     */
    var onNewLine: (() -> Unit)? = null
) : ICoroutine {

    /**
     * 主线程的Handler，用于调度字符添加任务。
     * Handler for the main thread to schedule character addition tasks.
     */
    private val handler: Handler = Handler(Looper.getMainLooper())

    /**
     * 要显示的文本。
     * The text to be displayed.
     */
    private var text: CharSequence = ""

    /**
     * 当前显示到的文本索引。
     * The current index of the text being displayed.
     */
    private var index: Int = 0

    /**
     * 是否正在打字��状态流。
     * State flow for whether typing is in progress.
     */
    private val _isTyping = MutableStateFlow(false)
    val isTyping = _isTyping.asStateFlow()

    /**
     * 字符添加任务。
     * Task for adding characters.
     */
    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            val textToShow = text.subSequence(0, index++) // 获取当前应显示的文本
            onUpdateText?.invoke("$textToShow●") // 在末尾添加圆点
            if (index <= text.length) {
                handler.postDelayed(this, typingDelay)
            } else {
                onUpdateText?.invoke(textToShow) // 动画完成后移除圆点
                onComplete?.invoke()
                _isTyping.value = false // 动画完成
            }
        }
    }

    /**
     * 文本高度的状态流。
     * State flow for the text height.
     */
    private val _textHeight = MutableStateFlow(0)

    /**
     * 文本高度，新行开始时可能会改变。
     * Text height, may change when a new line starts.
     * @param textHeight Int 文本高度
     */
    var textHeight = 0
        set(value) {
            _textHeight.value = value
            field = value
        }

    init {
        _textHeight.collectQuick {
            if (it > 0) {
                onNewLine?.invoke()
            }
        }
    }

    /**
     * 开始文本动画。
     * Starts the text animation.
     * @param txt CharSequence 要动画显示的文本
     */
    fun animateText(txt: CharSequence) {
        text = txt
        index = 0
        _isTyping.value = true // 开始动画
        onUpdateText?.invoke("")
        handler.removeCallbacks(characterAdder)
        handler.postDelayed(characterAdder, typingDelay)
    }
}