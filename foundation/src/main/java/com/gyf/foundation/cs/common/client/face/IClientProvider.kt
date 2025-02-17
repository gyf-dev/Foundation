package com.gyf.foundation.cs.common.client.face

import com.gyf.foundation.cs.common.face.IGet
import com.gyf.foundation.cs.common.face.IMessage
import com.gyf.foundation.cs.common.face.IPost
import com.gyf.foundation.ext.coroutine.ICoroutine

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/25 11:18
 */
interface IClientProvider : IClientBind, IClientRequest, IMessage, IPost, IGet, ICoroutine