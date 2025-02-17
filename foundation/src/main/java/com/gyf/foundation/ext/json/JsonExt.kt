package com.gyf.foundation.ext.json

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


/**
 * @author  ifan
 * @date  2021/11/8 20:13
 */

// ------------------------------Moshi-------------------------------------

/**
 * 如果json字段的值为null，将使用默认值的Moshi对象
 *
 * Moshi need default value
 */
val moshiNeedDefaultValue: Moshi by lazy {
    Moshi.Builder()
        .add(DefaultIfNullsFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()
}

/**
 * 如果json字段的值为null，将不使用默认值的Moshi对象
 *
 * Moshi no need default value
 */
val moshiNoNeedDefaultValue: Moshi by lazy {
    Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
}

fun getMoshi(defaultIfNulls: Boolean): Moshi =
    if (defaultIfNulls) moshiNeedDefaultValue else moshiNoNeedDefaultValue

// -----------------------------cloneDepth---------------------------------------

/**
 * 深度克隆
 *
 * @receiver T 克隆对象
 * @param clazz Class<T> 克隆对象的类型
 * @param size Int 克隆的个数
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @param serializeNulls Boolean 是否序列化字段为null的值
 * @return List<T>
 */
fun <T> T.cloneDepth(
    clazz: Class<T>,
    size: Int,
    defaultIfNulls: Boolean = true,
    serializeNulls: Boolean = false
): List<T> {
    val moshi = getMoshi(defaultIfNulls)
    val adapter = moshi.adapter(clazz)
    val json = adapter.run { if (serializeNulls) serializeNulls() else this }.toJson(this)
    val data = mutableListOf<T>()
    repeat(size) {
        adapter.fromJson(json)?.also { data += it }
    }
    return data
}

/**
 * 深度克隆
 *
 * @receiver T 克隆对象
 * @param clazz Class<T> 克隆对象的类型
 * @return T
 */
fun <T> T.cloneDepth(clazz: Class<T>) = cloneDepth(clazz, 1).first()

/**
 * 深度克隆
 *
 * @receiver T 克隆对象
 * @param size Int 克隆的个数
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @param serializeNulls Boolean 是否序列化字段为null的值
 * @return List<T>
 */
inline fun <reified T> T.cloneDepth(
    size: Int,
    defaultIfNulls: Boolean = true,
    serializeNulls: Boolean = false
) = cloneDepth(T::class.java, size, defaultIfNulls, serializeNulls)


/**
 * 深度克隆
 *
 * @receiver T
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @param serializeNulls Boolean 是否序列化字段为null的值
 * @return T
 */
inline fun <reified T> T.cloneDepth(
    defaultIfNulls: Boolean = true,
    serializeNulls: Boolean = false
) = cloneDepth(1, defaultIfNulls, serializeNulls).first()

// -----------------------------toJson---------------------------------------

/**
 * 序列化
 *
 * @receiver T 对象
 * @param clazz Class<T> 对象的类型
 * @param serializeNulls Boolean 是否序列化字段为null的值
 * @return String
 */
fun <T> T.toJson(clazz: Class<T>, serializeNulls: Boolean = false): String {
    return moshiNoNeedDefaultValue.adapter(clazz)
        .run { if (serializeNulls) serializeNulls() else this }
        .toJson(this)
}

/**
 * 序列化
 *
 * @receiver T 对象
 * @param serializeNulls Boolean 是否序列化字段为null的值
 * @return String
 */
inline fun <reified T> T.toJson(serializeNulls: Boolean = false) =
    toJson(T::class.java, serializeNulls)

// ----------------------------fromJson---------------------------------------

/**
 * 转化为具体类型
 *
 * @receiver String json
 * @param clazz Class<T> 对象的类型
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @return T?
 */
fun <T> String.fromJson(clazz: Class<T>, defaultIfNulls: Boolean = true): T? {
    val moshi = getMoshi(defaultIfNulls)
    return moshi.adapter(clazz).fromJson(this)
}

/**
 * 转化为具体类型
 *
 * @receiver String json
 * @param defaultIfNull Boolean 如果json字段的值为null，将使用默认值
 * @return T?
 */
inline fun <reified T> String.fromJson(defaultIfNull: Boolean = true) =
    fromJson(T::class.java, defaultIfNull)


/**
 * 转化为具体类型
 *
 * @receiver String json
 * @param clazz Class<T> 对象的类型
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @return T
 */
fun <T> String.fromJsonNotNull(clazz: Class<T>, defaultIfNulls: Boolean = true): T =
    fromJson(clazz, defaultIfNulls) ?: throw NullPointerException()

/**
 * 转化为具体类型
 *
 * @receiver String json
 * @param defaultIfNull Boolean 如果json字段的值为null，将使用默认值
 * @return T
 */
inline fun <reified T> String.fromJsonNotNull(defaultIfNull: Boolean = true): T =
    fromJson<T>(defaultIfNull) ?: throw NullPointerException()


/**
 * 转化为List<T>类型
 *
 * @receiver String json
 * @param clazz Class<T> 对象的类型
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @return List<T>
 */
fun <T> String.fromJsonWithList(clazz: Class<T>, defaultIfNulls: Boolean = true): List<T> {
    val moshi = getMoshi(defaultIfNulls)
    val listType = Types.newParameterizedType(List::class.java, clazz)
    return moshi.adapter<List<T>>(listType).fromJson(this) ?: emptyList()
}

/**
 * 转化为List<T>类型
 *
 * @receiver String json
 * @param defaultIfNull Boolean 如果json字段的值为null，将使用默认值
 * @return List<T>
 */
inline fun <reified T> String.fromJsonWithList(defaultIfNull: Boolean = true) =
    fromJsonWithList(T::class.java, defaultIfNull)

// ------------------------------toTarget-------------------------------------

/**
 * 类型转换
 *
 * @receiver T 原始对象
 * @param original Class<T> 原始对象的类型
 * @param target Class<D> 目标对象的类型
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @param serializeNulls Boolean 是否序列化字段为null的值
 * @return D? 目标对象
 */
fun <T, D> T.toTarget(
    original: Class<T>,
    target: Class<D>,
    defaultIfNulls: Boolean = true,
    serializeNulls: Boolean = false
): D? {
    val moshi = getMoshi(defaultIfNulls)
    val json = moshi.adapter(original)
        .run { if (serializeNulls) serializeNulls() else this }
        .toJson(this)
    return moshi.adapter(target).fromJson(json)
}

/**
 * 类型转换
 *
 * @receiver T 原始对象
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @param serializeNulls Boolean 是否序列化字段为null的值
 * @return D?
 */
inline fun <reified T, reified D> T.toTarget(
    defaultIfNulls: Boolean = true,
    serializeNulls: Boolean = false
) = toTarget(T::class.java, D::class.java, defaultIfNulls, serializeNulls)

/**
 * 类型转换
 *
 * @receiver T 原始对象
 * @param original Class<T> 原始对象的类型
 * @param defaultIfNulls Boolean 如果json字段的值为null，将使用默认值
 * @param serializeNulls Boolean 是否序列化字段为null的值
 * @return D?
 */
inline fun <T, reified D> T.toTarget(
    original: Class<T>,
    defaultIfNulls: Boolean = true,
    serializeNulls: Boolean = false
) = toTarget(original, D::class.java, defaultIfNulls, serializeNulls)