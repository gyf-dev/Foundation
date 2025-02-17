package com.gyf.foundation.ext.keyboard

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import java.lang.reflect.Field


/**
 * 软键盘扩展函数
 * @author gyf
 * @date 2018/7/31 下午6:24
 */

/**
 * 显示软键盘
 *
 * @receiver View
 */
fun View.showSoftKeyBoard() {
    isFocusable = true
    isFocusableInTouchMode = true
    requestFocus()
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    inputMethodManager?.apply {
        showSoftInput(this@showSoftKeyBoard, 0)
//        toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}

/**
 * 显示软键盘
 * @receiver Activity
 */
fun Activity.showSoftKeyBoard() = currentFocus?.showSoftKeyBoard() ?: Unit

/**
 * 显示软键盘
 *
 * @receiver Fragment
 * @return Unit?
 */
fun Fragment.showSoftKeyBoard() = activity?.showSoftKeyBoard() ?: Unit

/**
 * 隐藏软键盘
 *
 * @receiver View
 */
fun View.hideSoftKeyBoard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    inputMethodManager?.apply {
        hideSoftInputFromWindow(windowToken, 0)
//        toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}

/**
 * 隐藏软键盘
 *
 * @receiver Activity
 * @return Unit?
 */
fun Activity.hideSoftKeyBoard() = currentFocus?.hideSoftKeyBoard() ?: Unit


/**
 * 隐藏软键盘
 *
 * @receiver Fragment
 * @return Unit?
 */
fun Fragment.hideSoftKeyBoard() = activity?.hideSoftKeyBoard() ?: Unit


/**
 * 软键盘是否打开
 * @receiver Activity
 * @return Boolean
 */
fun Activity.isSoftInputShow(): Boolean {
    val view = this.window.peekDecorView()
    if (view != null) {
        // 隐藏虚拟键盘
        val inputMethodManager =
            this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.isActive && this.window.currentFocus != null
    }
    return false
}

/**
 * 软键盘是否打开
 *
 * @receiver Fragment
 * @return Boolean
 */
fun Fragment.isSoftInputShow() = activity?.isSoftInputShow() ?: false

/**
 * 软键盘监听
 * @receiver Activity
 * @param block (keyBoardHeight: Int) -> Unit
 */
fun Activity.onKeyBoardListener(block: (keyBoardHeight: Int) -> Unit) {
    var currentHeight = 0
    this.window.decorView.viewTreeObserver.addOnGlobalLayoutListener {
        val decorView = this@onKeyBoardListener.window.decorView
        val content = decorView.findViewById<FrameLayout>(android.R.id.content)
        val r = Rect()
        decorView.getWindowVisibleDisplayFrame(r)
        val keyBoardHeight = content.height - r.bottom
        if (currentHeight != keyBoardHeight) {
            block(keyBoardHeight)
            currentHeight = keyBoardHeight
        }
    }
}


/**
 * 软键盘监听
 * @receiver Fragment
 * @param block (keyBoardHeight: Int) -> Unit
 */
fun Fragment.onKeyBoardListener(block: (keyBoardHeight: Int) -> Unit) =
    activity?.onKeyBoardListener(block)
        ?: Unit

/**
 * 解决InputMethodManager导致的内存泄漏
 * @receiver Context
 */
@Keep
fun Context.fixInputMethodManagerLeak() {
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
        return
    }
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val arr = arrayOf("mCurRootView", "mServedView", "mNextServedView")
    var field: Field?
    var objGet: Any?
    for (i in arr.indices) {
        val param = arr[i]
        try {
            field = imm.javaClass.getDeclaredField(param)
            if (!field.isAccessible) {
                field.isAccessible = true
            } // author: sodino mail:sodino@qq.com
            objGet = field.get(imm)
            if (objGet != null && objGet is View) {
                val view = objGet as View?
                if (view!!.context == this) { // 被InputMethodManager持有引用的context是想要目标销毁的
                    field.set(imm, null) // 置空，破坏掉path to gc节点
                } else {
                    // 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
                    break
                }
            }
        } catch (t: Throwable) {
        }
    }
}



