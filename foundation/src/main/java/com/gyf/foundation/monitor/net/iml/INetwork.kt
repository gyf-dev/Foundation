package com.gyf.foundation.monitor.net.iml

/**
 * 网络接口
 * Network interface
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/4 9:26
 */
interface INetwork {
    /**
     * 启动网络监听
     * Start network monitoring
     *
     * @return 无返回值
     * @return No return value
     */
    fun start()

    /**
     * 停止网络监听
     * Stop network monitoring
     *
     * @return 无返回值
     * @return No return value
     */
    fun stop()
}