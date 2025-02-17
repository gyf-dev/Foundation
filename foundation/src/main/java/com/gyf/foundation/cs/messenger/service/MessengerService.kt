@file:Suppress("MemberVisibilityCanBePrivate")

package com.gyf.foundation.cs.messenger.service

import com.gyf.foundation.cs.common.service.AbsService
import com.gyf.foundation.cs.common.service.face.IServiceProvider

/**
 * @author Ifan.Ge
 * @date 2024/5/10 14:42
 */

/**
 * Messenger绑定服务类。
 *
 * 提供了一系列与Messenger通信的方法。
 */
abstract class MessengerService : AbsService() {
    override val provider: IServiceProvider by lazy { MessengerServiceProvider(this) }
}