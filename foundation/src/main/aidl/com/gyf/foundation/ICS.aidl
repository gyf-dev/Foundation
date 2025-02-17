// ICS.aidl
package com.gyf.foundation;

import android.os.Bundle;
import com.gyf.foundation.ICSCallback;

/*
 * ICS接口定义了一组可以通过IPC进行通信的方法
 */
interface ICS {

    /*
     * 同步接收一个Bundle数据

     * @param clientTag 客户端标签
     * @param message 数据
     */
    Message execute(in String clientTag, in Message message);

    /*
     * 异步获取数据，将通过ICSCallback回调返回

     * @param clientTag 客户端标签
     * @param message 数据
     */
    void enqueue(in String clientTag, in Message message);

    /*
     * 注册一个ICSCallback回调

     * @param clientTag 客户端标签
     * @param callback 回调接口
     */
    void registerCallback(in String clientTag, in ICSCallback callback);

    /*
     * 注销一个ICSCallback回调

     * @param clientTag 客户端标签
     * @param callback 回调接口
     */
    void unregisterCallback(in String clientTag, in ICSCallback callback);

    /*
     * 删除所有ICSCallback回调

     * @param clientTag 客户端标签
     */
    void removeAllCallbacks(in String clientTag);
}