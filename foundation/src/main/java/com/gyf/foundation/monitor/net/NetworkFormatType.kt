package com.gyf.foundation.monitor.net

/**
 * 网络格式类型枚举类
 * Network format type enumeration class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/26 14:46
 */
enum class NetworkFormatType {
    /**
     * 表示没有网络连接
     * Indicates no network connection
     */
    NONE,

    /**
     * 表示连接到WiFi网络
     * Indicates connection to WiFi network
     */
    WIFI,

    /**
     * 表示连接到2G网络
     * Indicates connection to 2G network
     */
    G2,

    /**
     * 表示连接到3G网络
     * Indicates connection to 3G network
     */
    G3,

    /**
     * 表示连接到4G网络
     * Indicates connection to 4G network
     */
    G4,

    /**
     * 表示连接到5G网络
     * Indicates connection to 5G network
     */
    G5,

    /**
     * 表示未知的网络连接类型
     * Indicates unknown network connection type
     */
    UNKNOWN
}