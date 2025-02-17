import android.content.Context
import android.content.res.Configuration
import com.gyf.foundation.Foundation
import com.gyf.foundation.ext.configuration.ConfigurationOwner
import com.gyf.foundation.ext.configuration.ConfigurationRegister
import com.gyf.foundation.ext.configuration.currentLocale
import com.gyf.foundation.ext.resources.currentLocale
import com.gyf.foundation.ext.resources.currentNightMode
import com.gyf.foundation.monitor.AbsMonitor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

/**
 * @Author Ifan.Ge
 * @Date 2024/8/26 15:49
 */
class ConfigurationMonitor(val context: Context) :
    AbsMonitor<Configuration>(context.resources.configuration) {

    private val configurationRegister by lazy {

        ConfigurationRegister(object : ConfigurationOwner {

            override fun onConfigChanged(configuration: Configuration) {
                "configuration changed:$configuration".log
                configurationChangedListeners.forEach { it(configuration) }
                _configurationFlow.value = configuration
                value.value = configuration
            }

            override fun onLocaleChanged(locale: Locale) {
                "locale changed:$locale".log
                localeChangedListeners.forEach { it(locale) }
                _localeFlow.value = locale
            }

            override fun onNightModeChanged(nightMode: Boolean) {
                "night mode changed:$nightMode".log
                nightModeChangedListeners.forEach { it(nightMode) }
                _nightModeFlow.value = nightMode
            }
        }).delegate(context)
    }
    private val configurationChangedListeners = mutableListOf<(Configuration) -> Unit>()
    private val localeChangedListeners = mutableListOf<(Locale) -> Unit>()
    private val nightModeChangedListeners = mutableListOf<(Boolean) -> Unit>()

    // Flow
    private val _configurationFlow =
        MutableStateFlow<Configuration>(context.resources.configuration)
    val configurationFlow = _configurationFlow.asStateFlow()
    private val _localeFlow = MutableStateFlow(context.resources.configuration.currentLocale)
    val localeFlow = _localeFlow.asStateFlow()
    private val _nightModeFlow =
        MutableStateFlow(
            context.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        )
    val nightModeFlow = _nightModeFlow.asStateFlow()


    override fun startInternal() {
        _localeFlow.value = context.resources.currentLocale
        _nightModeFlow.value = context.resources.currentNightMode
        configurationRegister.register()
    }

    override fun stopInternal() {
        configurationRegister.unregister()
    }

    fun addOnConfigurationChangedListener(listener: (Configuration) -> Unit) = apply {
        configurationChangedListeners.add(listener)
    }

    fun removeOnConfigurationChangedListener(listener: (Configuration) -> Unit) = apply {
        configurationChangedListeners.remove(listener)
    }

    fun addOnLocaleChangedListener(listener: (Locale) -> Unit) = apply {
        localeChangedListeners.add(listener)
    }

    fun removeOnLocaleChangedListener(listener: (Locale) -> Unit) = apply {
        localeChangedListeners.remove(listener)
    }

    fun addOnNightModeChangedListener(listener: (Boolean) -> Unit) = apply {
        nightModeChangedListeners.add(listener)
    }

    fun removeOnNightModeChangedListener(listener: (Boolean) -> Unit) = apply {
        nightModeChangedListeners.remove(listener)
    }

    companion object {
        val instance by lazy { ConfigurationMonitor(Foundation.context) }
    }
}
