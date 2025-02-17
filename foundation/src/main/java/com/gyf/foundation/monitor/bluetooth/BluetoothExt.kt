package com.gyf.foundation.monitor.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import androidx.annotation.RequiresPermission
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.isAccessible

/**
 * 蓝牙扩展类
 * Bluetooth extension class
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/5 10:32
 */

/**
 * 判断蓝牙设备是否已连接
 * Determine whether the Bluetooth device is connected
 *
 * @return Boolean 是否已连接
 *                 Whether it is connected
 */
val BluetoothDevice?.isConnectedExt: Boolean
    get() {
        try {
            if (this == null) return false
            val bluetoothDeviceKClass = BluetoothDevice::class
            val method = bluetoothDeviceKClass.declaredFunctions.find { it.name == "isConnected" }
            method?.isAccessible = true
            return method?.call(this) as? Boolean ?: false
        } catch (e: Exception) {
            return false
        }
    }

/**
 * 获取蓝牙适配器的连接状态
 * Get the connection state of the Bluetooth adapter
 *
 * @return Int 连接状态
 *             Connection state
 */
val BluetoothAdapter?.connectionStateExt: Int
    get() {
        try {
            if (this == null) {
                return -1
            }
            val bluetoothAdapterKClass = BluetoothAdapter::class
            val method =
                bluetoothAdapterKClass.declaredFunctions.find { it.name == "getConnectionState" }
            method?.isAccessible = true
            val state = method?.call(this) as? Int
            return state ?: -1
        } catch (e: Exception) {
            return -1
        }
    }

/**
 * 获取蓝牙适配器的连接状态
 * Get the connection state of the Bluetooth adapter
 *
 * @param profile 蓝牙配置文件
 *                Bluetooth profile
 * @return Int 连接状态
 *             Connection state
 */
@RequiresPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
fun BluetoothAdapter?.getConnectionState(profile: Int): Int {
    if (this == null) {
        return -1
    }
    return getProfileConnectionState(profile)
}