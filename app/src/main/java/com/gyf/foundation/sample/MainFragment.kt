package com.gyf.foundation.sample

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.gyf.foundation.ext.context.isSystemApp
import com.gyf.foundation.sample.page.cs
import com.gyf.foundation.sample.page.window
import com.gyf.foundation.window.Window

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/27 14:31
 */
@SuppressLint("ObsoleteSdkInt")
class MainFragment : CommonFragment() {

    private val data = listOf("客户端与服务端通信", "自定义Window")

    private var overlayPermissionLauncher: ActivityResultLauncher<Intent>? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (host is FragmentActivity) {
            overlayPermissionLauncher =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (Settings.canDrawOverlays(requireContext())) {
                            window()
                        } else {
                            // 用户拒绝了权限，可以提示用户权限的重要性
                            Toast.makeText(
                                requireContext(),
                                "悬浮窗权限被拒绝，部分功能将无法使用",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData(data)
        setOnItemClick {
            when (it) {
                0 -> cs()

                1 -> requestFloatingWindowPermissions {
                    window()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.finish()
        if (host is Window) {
            (host as Window).finish()
        }
    }

    private fun requestFloatingWindowPermissions(block: () -> Unit) {
        val resultLauncher = overlayPermissionLauncher
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M
            || requireContext().isSystemApp
            || host !is FragmentActivity
            || resultLauncher == null
            || Settings.canDrawOverlays(requireContext())
        ) {
            block()
            return
        }
        val intent = Intent(
            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:${requireContext().packageName}")
        )
        resultLauncher.launch(intent)
    }
}