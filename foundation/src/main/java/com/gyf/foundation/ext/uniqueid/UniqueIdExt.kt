@file:Suppress("DEPRECATION")

package com.gyf.foundation.ext.uniqueid

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import java.util.UUID

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/12 16:15
 */


private const val ANDROID_ID = "9774d56d682e549c"

val Context.uniqueId: String
    get() {
        return device ?: androidId ?: hardware ?: ""
    }

/**
 * Wifi mac address
 */
val Context.wifiMacAddress: String
    @SuppressLint("WifiManagerLeak", "HardwareIds")
    get() {
        val wifiManager =
            getSystemService(Context.WIFI_SERVICE) as WifiManager
        val wifiInfo = wifiManager.connectionInfo
        return wifiInfo.macAddress
    }

private val Context.device: String?
    @SuppressLint("MissingPermission", "HardwareIds")
    get() {
        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        try {
            val deviceId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                telephonyManager.imei
            } else {
                telephonyManager.deviceId
            }
            return deviceId
        } catch (_: Exception) {
        }
        return null
    }

private val hardware: String?
    @SuppressLint("MissingPermission", "HardwareIds")
    get() {
        val devIdShort = "35" +
                Build.BOARD.length % 10 + Build.BRAND.length % 10 +
                Build.CPU_ABI.length % 10 + Build.DEVICE.length % 10 +
                Build.DISPLAY.length % 10 + Build.HOST.length % 10 +
                Build.ID.length % 10 + Build.MANUFACTURER.length % 10 +
                Build.MODEL.length % 10 + Build.PRODUCT.length % 10 +
                Build.TAGS.length % 10 + Build.TYPE.length % 10 +
                Build.USER.length % 10
        val serial = try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Build.getSerial()
            } else {
                Build.SERIAL
            } ?: ""
        } catch (exception: Exception) {
            ""
        }
        return if (serial.isBlank()) {
            null
        } else {
            UUID(devIdShort.hashCode().toLong(), serial.hashCode().toLong())
                .toString()
        }
    }

private val Context.androidId: String?
    @SuppressLint("HardwareIds")
    get() {
        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        if (androidId != ANDROID_ID) {
            return androidId
        }
        return null
    }