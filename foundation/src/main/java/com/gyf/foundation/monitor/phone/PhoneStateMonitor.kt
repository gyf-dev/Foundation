@file:Suppress("DEPRECATION", "OVERRIDE_DEPRECATION", "SpellCheckingInspection")

package com.gyf.foundation.monitor.phone

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.CallLog
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi
import com.gyf.foundation.Foundation
import com.gyf.foundation.monitor.AbsMonitor

/**
 * PhoneStateMonitor类，用于监控电话状态的变化
 * PhoneStateMonitor class, used to monitor changes in phone state
 *
 * @Author  Ifan.Ge
 * @Date    2024/5/21 14:35
 */
class PhoneStateMonitor(private val context: Context) :
    AbsMonitor<Int>(-1) {

    companion object {
        val instance by lazy { PhoneStateMonitor(Foundation.context) }
    }

    /**
     * 电话管理器
     * Telephony manager
     */
    private val telephonyManager by lazy {
        context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    }

    /**
     * 电话状态监听器
     * Phone state listener
     */
    private var phoneStateListener = MyPhoneStateListener()

    @RequiresApi(Build.VERSION_CODES.S)
    /**
     * 电话回调
     * Telephony callback
     */
    private var telephonyCallback = MyTelephonyCallback()

    /**
     * 开始监控电话状态
     * Start monitoring phone state
     */
    @SuppressLint("ObsoleteSdkInt")
    override fun startInternal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephonyManager.registerTelephonyCallback(context.mainExecutor, telephonyCallback)
        } else {
            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
        }
    }

    /**
     * 停止监控电话状态
     * Stop monitoring phone state
     */
    @SuppressLint("ObsoleteSdkInt")
    override fun stopInternal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephonyManager.unregisterTelephonyCallback(telephonyCallback)
        } else {
            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE)
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    /**
     * 自定义电话回调类，用于处理电话状态的变化
     * Custom telephony callback class, used to handle changes in phone state
     */
    inner class MyTelephonyCallback : TelephonyCallback(), TelephonyCallback.CallStateListener {
        override fun onCallStateChanged(state: Int) {
            when (state) {
                TelephonyManager.CALL_STATE_IDLE -> "CALL_STATE_IDLE".log
                TelephonyManager.CALL_STATE_RINGING -> "CALL_STATE_RINGING: ${getLastIncomingCallNumber()}".log
                TelephonyManager.CALL_STATE_OFFHOOK -> "CALL_STATE_OFFHOOK".log
            }
            value.value = state
        }

        /**
         * 获取最后一个来电号码
         * Get the last incoming call number
         *
         * @return String? 返回最后一个来电号码
         *                 Return the last incoming call number
         */
        private fun getLastIncomingCallNumber(): String? {
            val cursor = context.contentResolver.query(
                CallLog.Calls.CONTENT_URI,
                arrayOf(CallLog.Calls.NUMBER, CallLog.Calls.TYPE),
                "${CallLog.Calls.TYPE} = ?",
                arrayOf(CallLog.Calls.INCOMING_TYPE.toString()),
                "${CallLog.Calls.DATE} DESC"
            )
            cursor?.use {
                if (it.moveToFirst()) {
                    return it.getString(it.getColumnIndexOrThrow(CallLog.Calls.NUMBER))
                }
            }
            return null
        }
    }

    /**
     * 自定义电话状态监听器类，用于处理电话状态的变化
     * Custom phone state listener class, used to handle changes in phone state
     */
    inner class MyPhoneStateListener : PhoneStateListener() {
        override fun onCallStateChanged(state: Int, phoneNumber: String?) {
            when (state) {
                TelephonyManager.CALL_STATE_IDLE -> "CALL_STATE_IDLE".log
                TelephonyManager.CALL_STATE_RINGING -> "CALL_STATE_RINGING: $phoneNumber".log
                TelephonyManager.CALL_STATE_OFFHOOK -> "CALL_STATE_OFFHOOK".log
            }
            value.value = state
        }
    }
}