package com.gyf.foundation.cs.common.service.face

import com.gyf.foundation.cs.common.face.IMessage
import com.gyf.foundation.cs.common.face.IMessageQuick
import com.gyf.foundation.cs.common.face.IPost
import com.gyf.foundation.ext.coroutine.ICoroutine

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 14:18
 */
interface IServiceProvider : IServiceBinder, IServiceResponse, IMessage, IMessageQuick, IPost,
    ICoroutine