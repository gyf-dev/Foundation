package com.gyf.foundation.window.delegate

import com.gyf.foundation.window.view.DecorView

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/26 19:29
 */
interface IViewThreeRegistry {
    fun initializeViewTreeOwners(decorView: DecorView) {}
}