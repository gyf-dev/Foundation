package com.gyf.foundation.ext.configuration

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Consumer
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.gyf.foundation.ext.log.ITag
import com.gyf.foundation.ext.resources.currentLocale
import com.gyf.foundation.ext.resources.currentNightMode
import com.gyf.foundation.ext.resources.currentOrientation
import com.gyf.foundation.window.Window
import java.util.Locale
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @Author  Ifan.Ge
 * @Date    2024/8/27 9:09
 */
class ConfigurationRegister(val configurationOwner: ConfigurationOwner) : ITag {

    private lateinit var currentLocale: Locale

    private var currentNightMode: Boolean = false
    private var currentOrientation = Configuration.ORIENTATION_LANDSCAPE

    @SuppressLint("NotifyDataSetChanged")
    private val localeChangedListener: (Locale) -> Unit = {
        if (::currentLocale.isInitialized) {
            if (currentLocale != it) {
                currentLocale = it
                configurationOwner.onLocaleChanged(it)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private val nightModeChangedListener: (Boolean) -> Unit = {
        if (currentNightMode != it) {
            currentNightMode = it
            configurationOwner.onNightModeChanged(it)
        }
    }

    private val orientationChangedListener: (Int) -> Unit = {
        if (currentOrientation != it) {
            currentOrientation = it
            configurationOwner.onOrientationChanged(it)
        }
    }

    private val componentCallback by lazy {
        object : ComponentCallbacks {
            override fun onConfigurationChanged(newConfig: Configuration) {
                consumer.accept(newConfig)
            }

            override fun onLowMemory() {
            }
        }
    }
    private val consumer: Consumer<Configuration> = Consumer {
        configurationOwner.onConfigChanged(it)
        localeChangedListener(it.currentLocale)
        nightModeChangedListener(it.currentNightMode)
        orientationChangedListener(it.currentOrientation)
    }

    private var isAppCompatSameComponentEnabled: Boolean = true

    private var isRegister: AtomicBoolean = AtomicBoolean(false)

    fun setAppCompatSameComponentEnabled(enable: Boolean) = apply {
        isAppCompatSameComponentEnabled = enable
    }

    fun delegate(context: Context) = ConfigurationRegister(ContextWrapper(context))
    fun register() {
        if (isRegister.get()) return
        isRegister.set(true)
        when (configurationOwner) {
            is LifecycleOwner -> {
                configurationOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
                    override fun onCreate(owner: LifecycleOwner) {
                        "auto register by onCreate $configurationOwner".log
                        registerInternal()
                    }

                    override fun onDestroy(owner: LifecycleOwner) {
                        super.onDestroy(owner)
                        "auto unregister by onDestroy $configurationOwner".log
                        unregister()
                        configurationOwner.lifecycle.removeObserver(this)
                    }
                })
            }

            is ContextWrapper -> {
                when (val requireContext = configurationOwner.context) {
                    is LifecycleOwner -> {
                        requireContext.lifecycle.addObserver(object : DefaultLifecycleObserver {
                            override fun onCreate(owner: LifecycleOwner) {
                                "ContextWrapper auto register by onCreate $requireContext".log
                                registerInternal()
                            }

                            override fun onDestroy(owner: LifecycleOwner) {
                                super.onDestroy(owner)
                                "ContextWrapper auto unregister by onDestroy $requireContext".log
                                unregister()
                                requireContext.lifecycle.removeObserver(this)
                            }
                        })
                    }

                    else -> {
                        "ContextWrapper register".log
                        registerInternal()
                    }
                }
            }

            else -> {
                "register".log
                registerInternal()
            }
        }
    }

    fun unregister() {
        if (!isRegister.get()) return
        isRegister.set(false)
        unregisterInternal()
    }

    fun dispatchConfigurationChanged(configuration: Configuration) {
        consumer.accept(configuration)
    }

    private fun registerInternal() {
        when (configurationOwner) {

            is AppCompatActivity -> {
                if (isAppCompatSameComponentEnabled) {
                    configurationOwner.addOnConfigurationChangedListener(consumer)
                } else {
                    "registerInternal AppCompatActivity $configurationOwner Need to manually call dispatchConfigurationChanged method".log
                }
                init(configurationOwner.resources)
            }

            is ComponentActivity -> {
                "registerInternal ComponentActivity $configurationOwner".log
                configurationOwner.addOnConfigurationChangedListener(consumer)
                init(configurationOwner.resources)
            }

            is Activity -> {
                "registerInternal Activity $configurationOwner Need to manually call dispatchConfigurationChanged method".log
                init(configurationOwner.resources)
            }

            is Fragment -> {
                when (val requireContext = configurationOwner.requireContext()) {
                    is AppCompatActivity -> {
                        if (isAppCompatSameComponentEnabled) {
                            requireContext.addOnConfigurationChangedListener(consumer)
                        } else {
                            "registerInternal Fragment AppCompatActivity $configurationOwner Need to manually call dispatchConfigurationChanged method".log
                        }
                    }

                    is ComponentActivity -> {
                        "registerInternal Fragment ComponentActivity $configurationOwner".log
                        requireContext.addOnConfigurationChangedListener(consumer)
                    }

                    else -> {
                        requireContext.registerComponentCallbacks(componentCallback)
                    }
                }
                init(configurationOwner.resources)
            }

            is Window -> {
                "registerInternal Window $configurationOwner".log
                init(configurationOwner.resources)
            }

            is Context -> {
                "registerInternal Context $configurationOwner".log
                configurationOwner.registerComponentCallbacks(componentCallback)
                init(configurationOwner.resources)
            }

            is ContextWrapper -> {
                when (val requireContext = configurationOwner.context) {
                    is AppCompatActivity -> {
                        if (isAppCompatSameComponentEnabled) {
                            requireContext.addOnConfigurationChangedListener(consumer)
                        } else {
                            "registerInternal ContextWrapper AppCompatActivity $requireContext Need to manually call dispatchConfigurationChanged method".log
                        }
                    }

                    is ComponentActivity -> {
                        "registerInternal ContextWrapper ComponentActivity $requireContext".log
                        requireContext.addOnConfigurationChangedListener(consumer)
                    }

                    is Activity -> {
                        "registerInternal ContextWrapper Activity $requireContext Need to manually call dispatchConfigurationChanged method".log
                    }

                    else -> {
                        "registerInternal Context $requireContext".log
                        requireContext.registerComponentCallbacks(componentCallback)
                    }
                }
                init(configurationOwner.context.resources)
            }

            else -> {
                throw IllegalArgumentException("Unsupported configurationOwner : $configurationOwner")
            }
        }
    }

    private fun unregisterInternal() {
        when (configurationOwner) {
            is AppCompatActivity -> {
                if (isAppCompatSameComponentEnabled) {
                    configurationOwner.removeOnConfigurationChangedListener(consumer)
                } else {
                    "unregisterInternal AppCompatActivity $configurationOwner".log
                }
            }

            is ComponentActivity -> {
                "unregisterInternal ComponentActivity $configurationOwner".log
                configurationOwner.removeOnConfigurationChangedListener(consumer)
            }

            is Activity -> {
                "unregisterInternal Activity $configurationOwner".log
            }

            is Fragment -> {
                when (val requireContext = configurationOwner.requireContext()) {
                    is AppCompatActivity -> {
                        if (isAppCompatSameComponentEnabled) {
                            requireContext.removeOnConfigurationChangedListener(consumer)
                        } else {
                            "unregisterInternal Fragment AppCompatActivity $configurationOwner".log
                        }
                    }

                    is ComponentActivity -> {
                        "unregisterInternal Fragment ComponentActivity $configurationOwner".log
                        requireContext.removeOnConfigurationChangedListener(consumer)
                    }

                    else -> {
                        "unregisterInternal Fragment FragmentActivity $configurationOwner".log
                        requireContext.registerComponentCallbacks(componentCallback)
                    }
                }
            }

            is Window -> {
                "unregisterInternal Window $configurationOwner".log
            }

            is Context -> {
                "unregisterInternal Context $configurationOwner".log
                configurationOwner.unregisterComponentCallbacks(componentCallback)
            }

            is ContextWrapper -> {
                when (val requireContext = configurationOwner.context) {

                    is AppCompatActivity -> {
                        if (isAppCompatSameComponentEnabled) {
                            requireContext.removeOnConfigurationChangedListener(consumer)
                        } else {
                            "unregisterInternal ContextWrapper AppCompatActivity $requireContext".log
                        }
                    }

                    is ComponentActivity -> {
                        "unregisterInternal ContextWrapper ComponentActivity $requireContext".log
                        requireContext.removeOnConfigurationChangedListener(consumer)
                    }

                    is Activity -> {
                        "unregisterInternal ContextWrapper Activity $requireContext".log
                    }

                    else -> {
                        "registerInternal Context $requireContext".log
                        requireContext.unregisterComponentCallbacks(componentCallback)
                    }
                }
            }

            else -> {
                throw IllegalArgumentException("Unsupported configurationOwner : $configurationOwner")
            }
        }
    }

    private fun init(resources: Resources) {
        currentLocale = resources.currentLocale
        currentNightMode = resources.currentNightMode
        currentOrientation = resources.currentOrientation
    }

    inner class ContextWrapper(val context: Context) : ConfigurationOwner {

        override fun onConfigChanged(configuration: Configuration) {
            configurationOwner.onConfigChanged(configuration)
        }

        override fun onLocaleChanged(locale: Locale) {
            configurationOwner.onLocaleChanged(locale)
        }

        override fun onNightModeChanged(nightMode: Boolean) {
            configurationOwner.onNightModeChanged(nightMode)
        }

        override fun onOrientationChanged(orientation: Int) {
            configurationOwner.onOrientationChanged(orientation)
        }
    }
}