package com.gyf.foundation.monitor.net.iml

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import com.gyf.foundation.monitor.net.NetworkFormatType

/**
 * Lollipop及以上版本的网络实现类
 * Network implementation class for Lollipop and above
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/4 9:27
 */
@SuppressLint("ObsoleteSdkInt")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class LollipopNetworkIml(
    /**
     * 上下文对象
     * Context object
     */
    private val context: Context,

    /**
     * 网络格式类型回调
     * Network format type callback
     */
    private val callback: (NetworkFormatType) -> Unit
) : INetwork {

    /**
     * 连接管理器
     * Connectivity manager
     */
    private val connectivityManager by lazy { context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    /**
     * 网络回调
     * Network callback
     */
    private val networkCallback by lazy { NetworkCallback(context, callback) }

    /**
     * 启动网络监听
     * Start network monitoring
     *
     * @return 无返回值
     * @return No return value
     */
    override fun start() {

        val builder = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        val networkRequest = builder.build()

        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    /**
     * 停止网络监听
     * Stop network monitoring
     *
     * @return 无返回值
     * @return No return value
     */
    override fun stop() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}