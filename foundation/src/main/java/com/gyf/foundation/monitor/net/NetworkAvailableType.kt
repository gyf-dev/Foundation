package com.gyf.foundation.monitor.net

/**
 * 网络可用类型枚举类
 * Network available type enumeration class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/3 20:53
 */
enum class NetworkAvailableType {
    /**
     * 表示没有连接网络
     * Indicates no network connection
     */
    NONE,

    /**
     * 表示已连接网络，但网络不可用
     * Indicates network is connected, but not available
     */
    UNAVAILABLE,

    /**
     * 表示已连接网络，并且网络可用
     * Indicates network is connected and available
     */
    AVAILABLE
}