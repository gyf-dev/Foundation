@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.monitor.bluetooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.gyf.foundation.Foundation
import com.gyf.foundation.monitor.AbsMonitor

/**
 * 蓝牙监视器类
 * Bluetooth Monitor Class
 *
 * @Author  Ifan.Ge
 * @Date    2024/5/21 18:02
 */
class BluetoothMonitor(
    /**
     * 上下文环境
     * Context
     */
    private val context: Context,

    /**
     * 蓝牙配置文件ID列表
     * List of Bluetooth profile IDs
     */
    private val profileId: List<Int> = mutableListOf(11, 16, 17, 18)
) : AbsMonitor<Int>(0) {

    companion object {
        val instance by lazy { BluetoothMonitor(Foundation.context) }
    }

    /**
     * 配置文件代理
     * Profile proxy
     */
    private val profileProxy = mutableMapOf<Int, BluetoothProfile>()

    /**
     * 蓝牙适配器
     * Bluetooth adapter
     */
    private val bluetoothAdapter by lazy {
        (context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter
    }

    /**
     * 蓝牙配置文件监听器
     * Bluetooth profile listener
     */
    private val bluetoothProfileListener = object : BluetoothProfile.ServiceListener {
        /**
         * 服务已连接
         * Service has connected
         *
         * @param profile 配置文件
         *                Profile
         * @param proxy 代理
         *              Proxy
         */
        override fun onServiceConnected(profile: Int, proxy: BluetoothProfile) {
            "onServiceConnected profile $profile".log
            if (profileId.contains(profile)) {
                profileProxy[profile] = proxy
            }
        }

        /**
         * 服务已断开
         * Service has disconnected
         *
         * @param profile 配置文件
         *                Profile
         */
        override fun onServiceDisconnected(profile: Int) {
            "onServiceDisconnected profile $profile".log
            if (profileId.contains(profile)) {
                profileProxy[profile]?.also {
                    bluetoothAdapter?.closeProfileProxy(profile, it)
                }
                profileProxy.remove(profile)
            }
        }
    }

    /**
     * 蓝牙接收器
     * Bluetooth receiver
     */
    private val bluetoothReceiver = object : BroadcastReceiver() {
        /**
         * 接收
         * Receive
         *
         * @param context 上下文
         *                Context
         * @param intent 意图
         *               Intent
         */
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action
            "action: $action".log
            when (action) {
                BluetoothDevice.ACTION_ACL_DISCONNECTED -> {
                    //蓝牙设备已断开连接
                    //Bluetooth device has disconnected
                }

                BluetoothDevice.ACTION_ACL_CONNECTED -> {
                    //蓝牙连接
                    //Bluetooth connected
                }

                BluetoothAdapter.ACTION_STATE_CHANGED -> {
                    val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1)
                    when (state) {
                        BluetoothAdapter.STATE_TURNING_ON -> {
                            // 蓝牙正在打开
                            // Bluetooth is turning on
                        }

                        BluetoothAdapter.STATE_ON -> {
                            // 蓝牙已经打开
                            // Bluetooth is on
                        }

                        BluetoothAdapter.STATE_TURNING_OFF -> {
                            // 蓝牙正在关闭
                            // Bluetooth is turning off
                        }

                        BluetoothAdapter.STATE_OFF -> {
                            // 蓝牙已经关闭
                            // Bluetooth is off
                        }
                    }
                }
            }

        }
    }

    /**
     * 已配对的设备
     * Bonded devices
     *
     * @return Set<BluetoothDevice> 已配对的设备集合
     *                              Set of bonded devices
     */
    val bondedDevices: Set<BluetoothDevice>
        get() {
            bluetoothAdapter ?: return emptySet()

            if (!bluetoothAdapter.isEnabled) return emptySet()

            return if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                bluetoothAdapter.bondedDevices.onEach {
                    "bondedDevices : ${it.name} ${it.bondState}".log
                }
            } else {
                emptySet()
            }
        }

    /**
     * 连接状态
     * Connection state
     *
     * @return Int 连接状态
     *             Connection state
     */
    val connectionState: Int get() = bluetoothAdapter.connectionStateExt

    /**
     * 是否已连接
     * Has connected
     *
     * @return Boolean 连接状态是否等于BluetoothAdapter.STATE_CONNECTED
     *                 Whether the connection state is equal to BluetoothAdapter.STATE_CONNECTED
     */
    val hasConnected: Boolean get() = connectionState == BluetoothAdapter.STATE_CONNECTED

    init {
        value.flow.collectQuick {
            "Is Bluetooth connected? $it".log
        }
        value.value = connectionState
    }

    /**
     * 开始
     * Start
     *
     */
    override fun startInternal() {

        profileId.forEach {
            bluetoothAdapter?.getProfileProxy(context, bluetoothProfileListener, it)
        }

        val filter = IntentFilter()
        filter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED)
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED)
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
        context.registerReceiver(bluetoothReceiver, filter)
    }

    /**
     * 停止
     * Stop
     *
     */
    override fun stopInternal() {
        profileProxy.forEach {
            bluetoothAdapter?.closeProfileProxy(it.key, it.value)
        }
        context.unregisterReceiver(bluetoothReceiver)
    }
}