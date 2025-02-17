@file:Suppress("DEPRECATION")

package com.gyf.foundation.monitor.net

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.telephony.TelephonyManager
import androidx.core.app.ActivityCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import okhttp3.OkHttpClient
import okhttp3.Request

suspend fun Context.isNetworkAvailable(): Boolean {
    return getNetworkAvailableType() == NetworkAvailableType.AVAILABLE
}

/**
 * 获取网络可用类型
 * Get network available type
 *
 * @return 网络可用类型
 * @return Network available type
 */
suspend fun Context.getNetworkAvailableType(timeout: Long = 500): NetworkAvailableType {
    return if (networkFormatType == NetworkFormatType.NONE) {
        NetworkAvailableType.NONE
    } else {
        val internetAvailableUsingPing = isNetworkAvailableUsingOkHttp(timeout)
        if (internetAvailableUsingPing) {
            NetworkAvailableType.AVAILABLE
        } else {
            NetworkAvailableType.UNAVAILABLE
        }
    }
}

/**
 * 使用OkHttp检查网络是否可用
 * Check if the network is available using OkHttp
 *
 * @return 网络是否可用
 * @return Whether the network is available
 */
suspend fun isNetworkAvailableUsingOkHttp(timeout: Long = 500): Boolean {
    return withContext(Dispatchers.IO) {
        withTimeoutOrNull(timeout) {
            try {
                val client = OkHttpClient()
                val request = Request.Builder().url("https://www.baidu.com").build()
                val response = client.newCall(request).execute()
                response.isSuccessful
            } catch (e: Exception) {
                false
            }
        } ?: true
    }
}

/**
 * 获取网络格式类型
 * Get network format type
 *
 * @return 网络格式类型
 * @return Network format type
 */
val Context.networkFormatType: NetworkFormatType
    get() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return NetworkFormatType.NONE
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(network) ?: return NetworkFormatType.NONE

            return when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> NetworkFormatType.WIFI
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> networkFormatTypeInternal
                else -> NetworkFormatType.UNKNOWN
            }
        } else {
            val activeNetworkInfo =
                connectivityManager.activeNetworkInfo ?: return NetworkFormatType.NONE
            if (!activeNetworkInfo.isConnected) return NetworkFormatType.NONE
            return when (activeNetworkInfo.type) {
                ConnectivityManager.TYPE_WIFI -> NetworkFormatType.WIFI
                ConnectivityManager.TYPE_MOBILE -> networkFormatTypeInternal
                else -> NetworkFormatType.UNKNOWN
            }
        }
    }

/**
 * 获取内部网络格式类型
 * Get internal network format type
 *
 * @return 网络格式类型
 * @return Network format type
 */
private val Context.networkFormatTypeInternal: NetworkFormatType
    get() {
        val telephonyManager =
            getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val networkType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                telephonyManager.dataNetworkType
            } else {
                telephonyManager.networkType
            }
            when (networkType) {
                TelephonyManager.NETWORK_TYPE_GPRS,
                TelephonyManager.NETWORK_TYPE_EDGE,
                TelephonyManager.NETWORK_TYPE_CDMA,
                TelephonyManager.NETWORK_TYPE_1xRTT,
                TelephonyManager.NETWORK_TYPE_IDEN -> NetworkFormatType.G2

                TelephonyManager.NETWORK_TYPE_UMTS,
                TelephonyManager.NETWORK_TYPE_EVDO_0,
                TelephonyManager.NETWORK_TYPE_EVDO_A,
                TelephonyManager.NETWORK_TYPE_HSDPA,
                TelephonyManager.NETWORK_TYPE_HSUPA,
                TelephonyManager.NETWORK_TYPE_HSPA,
                TelephonyManager.NETWORK_TYPE_EVDO_B,
                TelephonyManager.NETWORK_TYPE_EHRPD,
                TelephonyManager.NETWORK_TYPE_HSPAP -> NetworkFormatType.G3

                TelephonyManager.NETWORK_TYPE_LTE -> NetworkFormatType.G4
                TelephonyManager.NETWORK_TYPE_NR -> NetworkFormatType.G5
                else -> NetworkFormatType.UNKNOWN
            }
        } else {
            NetworkFormatType.UNKNOWN
        }
    }