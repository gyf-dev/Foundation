package com.gyf.foundation.monitor.net.iml

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.gyf.foundation.monitor.net.NetworkFormatType

/**
 * N及其以上网络实现类
 * Network implementation class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/4 9:27
 */
@SuppressLint("ObsoleteSdkInt")
@RequiresApi(Build.VERSION_CODES.N)
class NNetworkIml(
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
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
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