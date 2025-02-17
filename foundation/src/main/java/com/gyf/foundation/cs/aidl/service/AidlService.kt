package com.gyf.foundation.cs.aidl.service

import com.gyf.foundation.cs.common.service.AbsService
import com.gyf.foundation.cs.common.service.face.IServiceProvider

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 14:23
 */
open class AidlService : AbsService() {
    override val provider: IServiceProvider by lazy { AidlServiceProvider(this) }
}