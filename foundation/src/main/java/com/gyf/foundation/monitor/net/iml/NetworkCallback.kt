package com.gyf.foundation.monitor.net.iml

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.gyf.foundation.monitor.net.NetworkFormatType
import com.gyf.foundation.monitor.net.networkFormatType

/**
 * 网络回调类
 * Network callback class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/4 9:28
 */
@SuppressLint("ObsoleteSdkInt")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class NetworkCallback(
    /**
     * 上下文环境
     * Context environment
     */
    private val context: Context,

    /**
     * 回调函数，参数为网络格式类型
     * Callback function, the parameter is network format type
     */
    private val callback: (NetworkFormatType) -> Unit
) : ConnectivityManager.NetworkCallback() {

    /**
     * 当网络可用时调用
     * Called when the network is available
     *
     * @param network 网络
     * @return 无返回值
     */
    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        callback(context.networkFormatType)
    }

    /**
     * 当网络丢失时调用
     * Called when the network is lost
     *
     * @param network 网络
     * @return 无返回值
     */
    override fun onLost(network: Network) {
        super.onLost(network)
        callback(context.networkFormatType)
    }

    /**
     * 当网络能力发生变化时调用
     * Called when network capabilities change
     *
     * @param network 网络
     * @param networkCapabilities 网络能力
     * @return 无返回值
     */
    override fun onCapabilitiesChanged(
        network: Network,
        networkCapabilities: NetworkCapabilities
    ) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        callback(context.networkFormatType)
    }
}