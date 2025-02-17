package com.gyf.foundation.sample

import ConfigurationMonitor
import android.app.Application
import com.gyf.foundation.ext.log.ITag

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/27 13:19
 */
class App : Application(), ITag {

    override fun onCreate() {
        super.onCreate()
        ConfigurationMonitor.instance
            .addOnConfigurationChangedListener { "onConfigurationChanged:$it".log }
            .addOnLocaleChangedListener { "onLocaleChanged:$it".log }
            .addOnNightModeChangedListener { "onNightModeChanged:$it".log }
            .start()
    }
}