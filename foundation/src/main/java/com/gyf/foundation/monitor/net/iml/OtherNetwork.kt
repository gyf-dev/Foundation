@file:Suppress("DEPRECATION")

package com.gyf.foundation.monitor.net.iml

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.text.TextUtils
import com.gyf.foundation.monitor.net.NetworkFormatType
import com.gyf.foundation.monitor.net.networkFormatType

/**
 * 其他网络类
 * Other network class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/4 9:33
 */
class OtherNetwork(
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
     * 网络广播接收器
     * Network broadcast receiver
     */
    private val networkBroadcastReceiver by lazy { NetBroadcastReceiver() }

    /**
     * 启动网络监听
     * Start network monitoring
     *
     * @return 无返回值
     * @return No return value
     */
    override fun start() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        context.registerReceiver(networkBroadcastReceiver, intentFilter)
    }

    /**
     * 停止网络监听
     * Stop network monitoring
     *
     * @return 无返回值
     * @return No return value
     */
    override fun stop() {
        context.unregisterReceiver(networkBroadcastReceiver)
    }

    /**
     * 网络广播接收器类
     * Network broadcast receiver class
     *
     * @Author  Ifan.Ge
     * @Date    2024/6/4 9:33
     */
    inner class NetBroadcastReceiver : BroadcastReceiver() {

        /**
         * 当接收到广播时调用
         * Called when a broadcast is received
         *
         * @param context 上下文环境
         * @param intent 意图
         * @return 无返回值
         * @return No return value
         */
        override fun onReceive(context: Context, intent: Intent?) {
            if (intent == null) {
                return
            }
            if (TextUtils.equals(intent.action, ConnectivityManager.CONNECTIVITY_ACTION)) {
                callback(context.networkFormatType)
            }
        }
    }
}