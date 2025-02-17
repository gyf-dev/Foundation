package com.gyf.foundation.cs.exit

import android.os.Message
import com.gyf.foundation.cs.common.CsConst
import com.gyf.foundation.ext.bundle.get

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/19 17:00
 */
/**
 * 获取Message的数据
 *
 * @receiver Message
 * @return Any
 */
inline fun <reified T> Message.getData(defaultValue: T? = null): T =
    data.get<T>(CsConst.MSG_EXTRA_DATA, defaultValue)!!

inline fun <reified T> Message.getData(defaultValue: T? = null, block: T.() -> Unit) =
    data.get<T>(CsConst.MSG_EXTRA_DATA, defaultValue, block)

/**
 * 获取Message的数据2
 *
 * @receiver Message
 * @return Any
 */
inline fun <reified T> Message.getData2(defaultValue: T? = null): T =
    data.get<T>(CsConst.MSG_EXTRA_DATA2, defaultValue)!!

inline fun <reified T> Message.getData2(defaultValue: T? = null, block: T.() -> Unit) =
    data.get<T>(CsConst.MSG_EXTRA_DATA2, defaultValue, block)

/**
 * 获取Message的数据3
 *
 * @receiver Message
 * @return Any
 */
inline fun <reified T> Message.getData3(defaultValue: T? = null): T =
    data.get<T>(CsConst.MSG_EXTRA_DATA3, defaultValue)!!

inline fun <reified T> Message.getData3(defaultValue: T? = null, block: T.() -> Unit) =
    data.get<T>(CsConst.MSG_EXTRA_DATA3, defaultValue, block)

/**
 * 获取Message的数据4
 *
 * @receiver Message
 * @return Any
 */
inline fun <reified T> Message.getData4(defaultValue: T? = null): T =
    data.get<T>(CsConst.MSG_EXTRA_DATA4, defaultValue)!!

inline fun <reified T> Message.getData4(defaultValue: T? = null, block: T.() -> Unit) =
    data.get<T>(CsConst.MSG_EXTRA_DATA4, defaultValue, block)

/**
 * 获取Message的数据5
 *
 * @receiver Message
 * @return Any
 */
inline fun <reified T> Message.getData5(defaultValue: T? = null): T =
    data.get<T>(CsConst.MSG_EXTRA_DATA5, defaultValue)!!

inline fun <reified T> Message.getData5(defaultValue: T? = null, block: T.() -> Unit) =
    data.get<T>(CsConst.MSG_EXTRA_DATA5, defaultValue, block)

/**
 * 获取Message的数据
 *
 * @receiver Message
 * @return Any?
 */
inline fun <reified T> Message?.getDataOrNull(defaultValue: T? = null): T? =
    if (this == null) null else data.get<T>(CsConst.MSG_EXTRA_DATA, defaultValue)

/**
 * 获取Message的数据2
 *
 * @receiver Message
 * @return Any?
 */
inline fun <reified T> Message?.getDataOrNull2(defaultValue: T? = null): T? =
    if (this == null) null else data.get<T>(CsConst.MSG_EXTRA_DATA2, defaultValue)

/**
 * 获取Message的数据3
 *
 * @receiver Message
 * @return Any?
 */
inline fun <reified T> Message?.getDataOrNull3(defaultValue: T? = null): T? =
    if (this == null) null else data.get<T>(CsConst.MSG_EXTRA_DATA3, defaultValue)

/**
 * 获取Message的数据4
 *
 * @receiver Message
 * @return Any?
 */
inline fun <reified T> Message?.getDataOrNull4(defaultValue: T? = null): T? =
    if (this == null) null else data.get<T>(CsConst.MSG_EXTRA_DATA4, defaultValue)

/**
 * 获取Message的数据5
 *
 * @receiver Message
 * @return Any?
 */
inline fun <reified T> Message?.getDataOrNull5(defaultValue: T? = null): T? =
    if (this == null) null else data.get<T>(CsConst.MSG_EXTRA_DATA5, defaultValue)