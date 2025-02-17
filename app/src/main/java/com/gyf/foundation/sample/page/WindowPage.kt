@file:Suppress("DEPRECATION")

package com.gyf.foundation.sample.page

import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import com.gyf.foundation.sample.CommonFragment
import com.gyf.foundation.sample.replaceFragment
import com.gyf.foundation.sample.window.MainComponentWindow
import com.gyf.foundation.sample.window.MainComposeWindow
import com.gyf.foundation.sample.window.MainFragmentWindow
import com.gyf.foundation.sample.window.MainWindow
import com.gyf.foundation.window.ext.startWindow
import com.gyf.foundation.window.ext.startWindowGet

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/28 14:10
 */

private var mainWindow: MainWindow? = null

private val data = listOf(
    "Window--Show",
    "Window--Hide",
    "ComponentWindow",
    "FragmentWindow",
    "ComposeWindow"
)

fun CommonFragment.window() {
    replaceFragment(data) {
        when (it) {
            0 -> {
                if (mainWindow != null) {
                    mainWindow?.show()
                } else {
                    mainWindow = requireContext().startWindowGet<MainWindow>() {
                        height = 1000
                        gravity = Gravity.BOTTOM
                        flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                                WindowManager.LayoutParams.FLAG_FULLSCREEN or
                                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                    }
                }
            }

            1 -> {
                val window = mainWindow
                if (window != null) {
                    if (window.isShow) {
                        window.hide()
                    } else {
                        Toast.makeText(requireContext(), "还没有显示Window", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "请先显示Window",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            2 -> {
                requireContext().startWindow<MainComponentWindow>()
            }

            3 -> {
                requireContext().startWindow<MainFragmentWindow> {
                    height = 1000
                    gravity = Gravity.TOP
                }
            }

            4 -> {
                requireContext().startWindow<MainComposeWindow>()
            }
        }
    }
}