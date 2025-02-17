package com.gyf.foundation.cs.common.service.face

import android.os.IBinder

/**
 * IServiceBinder接口，定义了获取Binder对象的方法
 * IServiceBinder interface, defines a method for getting Binder object
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/25 18:15
 */
interface IServiceBinder {

    /**
     * 获取Binder对象的方法
     * Method for getting Binder object
     *
     * @return IBinder 返回Binder对象
     *                 Return Binder object
     */
    val binder: IBinder
}