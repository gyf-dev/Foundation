package com.gyf.foundation.sample.window

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.gyf.foundation.ext.view.click.onClick
import com.gyf.foundation.sample.databinding.WindowMainComponentBinding
import com.gyf.foundation.window.ComponentWindow

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/27 18:45
 */
class MainComponentWindow : ComponentWindow() {

    private val binding by lazy { WindowMainComponentBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when (event) {
                    Lifecycle.Event.ON_CREATE -> {
                        "ON_CREATE".log
                    }

                    Lifecycle.Event.ON_START -> {
                        "ON_START".log
                    }

                    Lifecycle.Event.ON_RESUME -> {
                        "ON_RESUME".log
                    }

                    Lifecycle.Event.ON_PAUSE -> {
                        "ON_PAUSE".log
                    }

                    Lifecycle.Event.ON_STOP -> {
                        "ON_STOP".log
                    }

                    Lifecycle.Event.ON_DESTROY -> {
                        "ON_DESTROY".log
                    }

                    Lifecycle.Event.ON_ANY -> "ON_ANY".log
                }
            }
        })

        binding.btnFinish.onClick {
            finish()
        }
    }
}