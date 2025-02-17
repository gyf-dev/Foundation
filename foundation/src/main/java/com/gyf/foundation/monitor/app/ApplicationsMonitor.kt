@file:Suppress("SameParameterValue", "MemberVisibilityCanBePrivate")

package com.gyf.foundation.monitor.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ResolveInfo
import android.database.ContentObserver
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import com.gyf.foundation.Foundation
import com.gyf.foundation.ext.coroutine.coroutineScope
import com.gyf.foundation.ext.json.fromJson
import com.gyf.foundation.monitor.AbsMonitor
import com.gyf.foundation.monitor.MonitorConst
import kotlinx.coroutines.launch

/**
 * ApplicationsMonitor类，用于监控应用的变化
 * ApplicationsMonitor class, used to monitor changes in applications
 *
 * @Author Ifan.Ge
 * @Date 2024/5/14 9:46
 */
class ApplicationsMonitor(private val context: Context) :
    AbsMonitor<List<Applications>>(emptyList()) {

    companion object {
        val instance by lazy { ApplicationsMonitor(Foundation.context) }
    }

    /**
     * 广播接收器，用于接收应用的安装、卸载、更新的广播
     * Broadcast receiver, used to receive broadcasts of application installation, uninstallation, and update
     */
    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            if (intent == null) return
            when {
                Intent.ACTION_PACKAGE_ADDED == intent.action ||
                        Intent.ACTION_PACKAGE_REPLACED == intent.action ||
                        Intent.ACTION_PACKAGE_REMOVED == intent.action -> obtainApplications()
            }
        }
    }

    /**
     * 内容观察者，用于观察应用的变化
     * Content observer, used to observe changes in applications
     */
    private val contentObserver by lazy {
        object : ContentObserver(Handler(Looper.getMainLooper())) {
            override fun onChange(selfChange: Boolean) {
                obtainApplications()
            }
        }
    }

    /**
     * 应用包信息
     * Application package information
     */
    private var packages: Packages = Packages()

    /**
     * 黑名单是否启用
     * Whether the blacklist is enabled
     */
    var blackEnabled = true
        set(value) {
            field = value
            obtainApplications()
        }

    /**
     * 开始监控
     * Start monitoring
     */
    override fun startInternal() {
        registerAppsReceiver()
        registerPackagesResolver()
        initData()
    }

    /**
     * 停止监控
     * Stop monitoring
     */
    override fun stopInternal() {
        unregisterAppsReceiver()
        unregisterPackagesResolver()
    }

    /**
     * 初始化数据
     * Initialize data
     */
    private fun initData() {
        obtainApplications()
        Settings.Global.getString(
            context.contentResolver,
            MonitorConst.MONITOR_PACKAGES_INFO
        )?.fromJson<Packages>()?.also {
            setPackages(it)
        }
    }

    /**
     * 设置黑白名单
     *
     * @param packages Packages
     */
    fun setPackages(packages: Packages) = apply {
        this.packages = packages
        obtainApplications()
    }

    /**
     * 切换黑名单
     * Toggle blacklist
     */
    fun toggleBlack() {
        blackEnabled = !blackEnabled
    }

    /**
     * 获取应用图标
     * Get application icon
     *
     * @param pkg String 应用包名
     *                Application package name
     * @return Drawable? 返回应用图标
     *                  Return application icon
     */
    fun getIconDrawable(pkg: String): Drawable? {
        return value.value.firstOrNull { it.pkg == pkg }?.iconDrawable
    }

    /**
     * 注册应用广播接收器
     * Register application broadcast receiver
     */
    private fun registerAppsReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED)
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED)
        intentFilter.addAction(Intent.ACTION_PACKAGE_REPLACED)
        intentFilter.addDataScheme("package")
        context.registerReceiver(receiver, intentFilter)
    }

    /**
     * 注册应用包解析器
     * Register application package resolver
     */
    private fun registerPackagesResolver() {
        context.contentResolver.registerContentObserver(
            Settings.Global.getUriFor(MonitorConst.MONITOR_PACKAGES_INFO),
            false, contentObserver
        )
    }

    /**
     * 注销应用广播接收器
     * Unregister application broadcast receiver
     */
    private fun unregisterAppsReceiver() {
        context.unregisterReceiver(receiver)
    }

    /**
     * 注销应用包解析器
     * Unregister application package resolver
     */
    private fun unregisterPackagesResolver() {
        context.contentResolver.unregisterContentObserver(contentObserver)
    }

    /**
     * 获取应用信息
     * Get application information
     */
    fun obtainApplications() = coroutineScope.launch {
        val launcherIntent = Intent(Intent.ACTION_MAIN, null)
        launcherIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        val resolveInfoList = context.packageManager.queryIntentActivities(launcherIntent, 0)
        val applicationsList = mutableListOf<Applications>()
        for (index in resolveInfoList.indices) {
            val resolveInfo = resolveInfoList[index]
            val title = resolveInfo.loadLabel(context.packageManager).toString()
            val iconDrawable = resolveInfo.loadIcon(context.packageManager)
            val pkg = resolveInfo.activityInfo.packageName
            val cls = resolveInfo.activityInfo.name
            val isBlack = isBlack(resolveInfo)
            if (isBlack) {
                continue
            }
            if (isWhite(resolveInfo)) {
                val applications = Applications(title, iconDrawable, pkg, cls)
                applicationsList.add(applications)
            }
        }
        if (applicationsList.isNotEmpty()) {
            applicationsList.sortWith { o1, o2 ->
                var index1 = packages.sortListByName.indexOf(o1.title)
                var index2 = packages.sortListByName.indexOf(o2.title)
                index1 = if (index1 == -1) Int.MAX_VALUE else index1
                index2 = if (index2 == -1) Int.MAX_VALUE else index2
                index1.compareTo(index2)
            }
            applicationsList.sortWith { o1, o2 ->
                var index1 = packages.sortListByClassName.indexOf(o1.cls)
                var index2 = packages.sortListByClassName.indexOf(o2.cls)
                index1 = if (index1 == -1) Int.MAX_VALUE else index1
                index2 = if (index2 == -1) Int.MAX_VALUE else index2
                index1.compareTo(index2)
            }
            value.value = applicationsList
        }
    }

    private fun isBlack(resolveInfo: ResolveInfo): Boolean {
        if (!blackEnabled) {
            return false
        }
        val blacklist = packages.blacklist
        var isBlack = false
        for (packageInfo in blacklist) {
            val clsName = packageInfo.clsName
            if (clsName.isEmpty()) {
                if (packageInfo.pkgName == resolveInfo.activityInfo.packageName) {
                    isBlack = true
                }
            } else {
                if (clsName.contains(resolveInfo.activityInfo.name)) {
                    isBlack = true
                }
            }
        }
        return isBlack
    }

    private fun isWhite(resolveInfo: ResolveInfo): Boolean {
        if (packages.whitelist.isEmpty()) {
            return true
        }
        val whitelist = packages.whitelist
        var isWhite = false
        for (packageInfo in whitelist) {
            val clsName = packageInfo.clsName
            if (clsName.isEmpty()) {
                if (packageInfo.pkgName == resolveInfo.activityInfo.packageName) {
                    isWhite = true
                }
            } else {
                if (clsName.contains(resolveInfo.activityInfo.name)) {
                    isWhite = true
                }
            }
        }
        return isWhite
    }
}