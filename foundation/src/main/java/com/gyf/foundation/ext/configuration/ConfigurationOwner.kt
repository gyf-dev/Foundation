package com.gyf.foundation.ext.configuration

import android.content.res.Configuration
import java.util.Locale

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/27 9:10
 */
interface ConfigurationOwner {

    fun onConfigChanged(configuration: Configuration) {

    }

    fun onLocaleChanged(locale: Locale)

    fun onNightModeChanged(nightMode: Boolean)

    fun onOrientationChanged(orientation: Int) {

    }
}