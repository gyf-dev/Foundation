// ICSCallback.aidl
package com.gyf.foundation;

import android.os.Bundle;

/*
 * ICSCallback接口定义了一个回调方法，用于接收数据
 */
interface ICSCallback {
    /*
     * 当接收到数据时调用

     * @param clientTag 客户端标签
     * @param message 数据
     */
    void onResponse(in String clientTag, in Message message);
}