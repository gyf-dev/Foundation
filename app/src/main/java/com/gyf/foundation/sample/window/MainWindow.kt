package com.gyf.foundation.sample.window

import android.os.Bundle
import com.gyf.foundation.ext.view.click.onClick
import com.gyf.foundation.sample.databinding.WindowMainBinding
import com.gyf.foundation.window.Window

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/27 20:14
 */
class MainWindow : Window() {

    private val binding by lazy { WindowMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnHide.onClick {
            hide()
        }
    }
}