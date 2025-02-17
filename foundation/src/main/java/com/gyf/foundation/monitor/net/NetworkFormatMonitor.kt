@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.monitor.net

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import com.gyf.foundation.Foundation
import com.gyf.foundation.ext.flow.stateFlow
import com.gyf.foundation.monitor.AbsMonitor
import com.gyf.foundation.monitor.net.iml.LollipopNetworkIml
import com.gyf.foundation.monitor.net.iml.NNetworkIml
import com.gyf.foundation.monitor.net.iml.OtherNetwork

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/3 20:20
 */
@SuppressLint("ObsoleteSdkInt")
class NetworkFormatMonitor(val context: Context) :
    AbsMonitor<NetworkFormatType>(NetworkFormatType.NONE) {

    companion object {
        val instance by lazy { NetworkFormatMonitor(Foundation.context) }
    }

    private val netCompat by lazy {
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> NNetworkIml(context) {
                isFirst = false
                value.value = it
            }

            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> LollipopNetworkIml(context) {
                isFirst = false
                value.value = it
            }

            else -> OtherNetwork(context) {
                isFirst = false
                value.value = it
            }
        }
    }

    val available by stateFlow(NetworkAvailableType.NONE)

    private var isFirst = true

    init {
        value.flow.collectQuick {
            "network format type: $it".log
            available.value = context.getNetworkAvailableType()
        }
        available.flow.collectQuick {
            "network available type: $it".log
        }
        value.value = context.networkFormatType
    }

    override fun startInternal() {
        netCompat.start()
    }

    override fun stopInternal() {
        netCompat.stop()
    }
}