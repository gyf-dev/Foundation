@file:Suppress(
    "UNCHECKED_CAST", "KotlinConstantConditions", "SpellCheckingInspection",
    "DEPRECATION", "ObsoleteSdkInt"
)

package com.gyf.foundation.ext.bundle

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.util.ArrayMap
import android.util.Size
import android.util.SizeF
import android.util.SparseArray
import androidx.fragment.app.Fragment
import com.gyf.foundation.ext.clazz.isBoolean
import com.gyf.foundation.ext.clazz.isBooleanArray
import com.gyf.foundation.ext.clazz.isBundle
import com.gyf.foundation.ext.clazz.isByte
import com.gyf.foundation.ext.clazz.isByteArray
import com.gyf.foundation.ext.clazz.isChar
import com.gyf.foundation.ext.clazz.isCharArray
import com.gyf.foundation.ext.clazz.isCharSequence
import com.gyf.foundation.ext.clazz.isClassOf
import com.gyf.foundation.ext.clazz.isDouble
import com.gyf.foundation.ext.clazz.isDoubleArray
import com.gyf.foundation.ext.clazz.isFloat
import com.gyf.foundation.ext.clazz.isFloatArray
import com.gyf.foundation.ext.clazz.isInt
import com.gyf.foundation.ext.clazz.isIntArray
import com.gyf.foundation.ext.clazz.isList
import com.gyf.foundation.ext.clazz.isLong
import com.gyf.foundation.ext.clazz.isLongArray
import com.gyf.foundation.ext.clazz.isParcelable
import com.gyf.foundation.ext.clazz.isSerializable
import com.gyf.foundation.ext.clazz.isShort
import com.gyf.foundation.ext.clazz.isShortArray
import com.gyf.foundation.ext.clazz.isSparseArray
import com.gyf.foundation.ext.clazz.isSting
import com.gyf.foundation.ext.json.fromJson
import com.gyf.foundation.ext.json.toJson
import java.io.File
import java.io.Serializable
import java.security.InvalidParameterException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author ifan
 * @date 2021/11/10 17:20
 */

// --------------------------------Bundle-----------------------------------

/**
 * 使用Pair创建Bundle
 *
 * @param params Array<out Pair<String, Any?>> Pairs 要传入的键值对 Array
 * @return Bundle 返回一个Bundle对象
 */
fun Bundle(vararg params: Pair<String, Any?>) = Bundle().put(*params)


// --------------------------------Put-----------------------------------

/**
 * 使用Pair扩展Bundle
 *
 * @receiver Bundle 接收一个Bundle对象，如果为null，则新建一个Bundle对象
 * @param params Array<out Pair<String, Any?>> 要传入的键值对 Array
 * @return Bundle 返回一个Bundle对象
 */
fun Bundle?.put(vararg params: Pair<String, Any?>) = (this ?: Bundle()).apply {
    val stringBuilder = StringBuilder()
    params.forEach {
        var log = it.first
        when (val value = it.second) {
            null -> {
                log += " putString"
                putString(it.first, null)
            }

            is Byte -> {
                log += " putByte"
                putByte(it.first, value)
            }

            is Int -> {
                log += " putInt"
                putInt(it.first, value)
            }

            is Long -> {
                log += " putLong"
                putLong(it.first, value)
            }

            is Float -> {
                log += " putFloat"
                putFloat(it.first, value)
            }

            is Double -> {
                log += " putDouble"
                putDouble(it.first, value)
            }

            is Char -> {
                log += " putChar"
                putChar(it.first, value)
            }

            is Short -> {
                log += " putShort"
                putShort(it.first, value)
            }

            is Boolean -> {
                log += " putBoolean"
                putBoolean(it.first, value)
            }

            is CharSequence -> {
                log += " putCharSequence"
                putCharSequence(it.first, value)
            }

            is String -> {
                log += " putString"
                putString(it.first, value)
            }

            is Bundle -> {
                log += " putBundle"
                putBundle(it.first, value)
            }

            is ByteArray -> {
                log += " putByteArray"
                putByteArray(it.first, value)
            }

            is IntArray -> {
                log += " putIntArray"
                putIntArray(it.first, value)
            }

            is LongArray -> {
                log += " putLongArray"
                putLongArray(it.first, value)
            }

            is FloatArray -> {
                log += " putFloatArray"
                putFloatArray(it.first, value)
            }

            is DoubleArray -> {
                log += " putDoubleArray"
                putDoubleArray(it.first, value)
            }

            is CharArray -> {
                log += " putCharArray"
                putCharArray(it.first, value)
            }

            is ShortArray -> {
                log += " putShortArray"
                putShortArray(it.first, value)
            }

            is BooleanArray -> {
                log += " putBooleanArray"
                putBooleanArray(it.first, value)
            }

            is Array<*> -> {
                when {
                    value.isArrayOf<Byte>() -> {
                        log += " isArrayOf Byte"
                        putByteArray(
                            it.first,
                            value.filterIsInstance<Byte>().toTypedArray().toByteArray()
                        )
                    }

                    value.isArrayOf<Int>() -> {
                        log += " isArrayOf Int"
                        putIntArray(
                            it.first,
                            value.filterIsInstance<Int>().toTypedArray().toIntArray()
                        )
                    }

                    value.isArrayOf<Long>() -> {
                        log += " isArrayOf Long"
                        putLongArray(
                            it.first,
                            value.filterIsInstance<Long>().toTypedArray().toLongArray()
                        )
                    }

                    value.isArrayOf<Float>() -> {
                        log += " isArrayOf Float"
                        putFloatArray(
                            it.first,
                            value.filterIsInstance<Float>().toTypedArray().toFloatArray()
                        )
                    }

                    value.isArrayOf<Double>() -> {
                        log += " isArrayOf Double"
                        putDoubleArray(
                            it.first,
                            value.filterIsInstance<Double>().toTypedArray().toDoubleArray()
                        )
                    }

                    value.isArrayOf<Char>() -> {
                        log += " isArrayOf Char"
                        putCharArray(
                            it.first,
                            value.filterIsInstance<Char>().toTypedArray().toCharArray()
                        )
                    }

                    value.isArrayOf<Short>() -> {
                        log += " isArrayOf Short"
                        putShortArray(
                            it.first,
                            value.filterIsInstance<Short>().toTypedArray().toShortArray()
                        )
                    }

                    value.isArrayOf<Boolean>() -> {
                        log += " isArrayOf Boolean"
                        putBooleanArray(
                            it.first,
                            value.filterIsInstance<Boolean>().toTypedArray().toBooleanArray()
                        )
                    }

                    value.isArrayOf<CharSequence>() -> {
                        log += " isArrayOf CharSequence"
                        putCharSequenceArray(
                            it.first,
                            value.filterIsInstance<CharSequence>().toTypedArray()
                        )
                    }

                    value.isArrayOf<String>() -> {
                        log += " isArrayOf String"
                        putStringArray(
                            it.first,
                            value.filterIsInstance<String>().toTypedArray()
                        )
                    }

                    value.isArrayOf<Parcelable>() -> {
                        log += " isArrayOf Parcelable"
                        putParcelableArray(
                            it.first,
                            value.filterIsInstance<Parcelable>().toTypedArray()
                        )
                    }

                    value.isArrayOf<Serializable>() -> {
                        log += " isArrayOf Serializable"
                        putParcelableArray(
                            it.first,
                            value.filterIsInstance<Parcelable>().toTypedArray()
                        )
                    }

                    else -> {
                        log += " isArrayOf putReflect"
                        putReflect(it.first to value)
                    }
                }
            }

            is SparseArray<*>, is List<*> -> {
                log += " SparseArray or List  putReflect"
                putReflect(it.first to value)
            }

            is Parcelable -> {
                log += " putParcelable"
                putParcelable(it.first, value)
            }

            is Serializable -> {
                log += " putSerializable"
                putSerializable(it.first, value)
            }

            else -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 && value is IBinder) {
                    log += " putBinder"
                    putBinder(it.first, value)
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && value is Size) {
                    log += " putSize"
                    putSize(it.first, value)
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && value is SizeF) {
                    log += " putSizeF"
                    putSizeF(it.first, value)
                } else {
                    log += " other putReflect"
                    putReflect(it.first to value)
                }
            }
        }
        stringBuilder.append(log)
        stringBuilder.append(File.separator)
    }
    val lastIndex = stringBuilder.lastIndexOf(File.separator)
    if (lastIndex != -1) {
        stringBuilder.delete(lastIndex, lastIndex + File.separator.length)
    }
//    Log.d("BundleExt", stringBuilder.toString())
}

@SuppressLint("NewApi")
private fun Bundle.putReflect(param: Pair<String, Any?>) {
    try {
        val bundle = this
        val unparcelMethod = bundle::class.java.superclass.getDeclaredMethod("unparcel")
        val mapField = bundle::class.java.superclass.getDeclaredField("mMap")

        unparcelMethod.isAccessible = true
        unparcelMethod.invoke(bundle)
        unparcelMethod.isAccessible = false

        mapField.isAccessible = true
        val oldData = mapField.get(bundle) as ArrayMap<String, Any>
        val newData = ArrayMap<String, Any>()
        newData += oldData
        newData[param.first] = param.second
        mapField.set(bundle, newData)
        mapField.isAccessible = false
    } catch (e: Exception) {
        putJson(param)
    }
}

private fun Bundle.putJson(param: Pair<String, Any?>) {
    putString(param.first, param.second.toJson())
}

// --------------------------------Get-----------------------------------

/**
 * 获取Bundle中的数据
 *
 * @receiver Bundle? Bundle对象，如果为null，则返回null
 * @param cla Class<D> 对象类型
 * @param key String 键
 * @param defaultValue D? 默认值
 * @return D? 返回一个实际的对象，可以为null
 */
@SuppressLint("ObsoleteSdkInt")
fun <D> Bundle?.get(cla: Class<D>, key: String, defaultValue: D? = null) = run {
    if (this == null) return@run null
    when {
        cla.isByte -> if (defaultValue != null) getByte(key, defaultValue as Byte) else getByte(key)
        cla.isInt -> if (defaultValue != null) getInt(key, defaultValue as Int) else getInt(key)
        cla.isLong -> if (defaultValue != null) getLong(key, defaultValue as Long) else getLong(key)
        cla.isFloat -> if (defaultValue != null) getFloat(key, defaultValue as Float) else getFloat(
            key
        )

        cla.isDouble -> if (defaultValue != null) getDouble(
            key,
            defaultValue as Double
        ) else getDouble(key)

        cla.isChar -> if (defaultValue != null) getChar(key, defaultValue as Char) else getChar(key)
        cla.isShort -> if (defaultValue != null) getShort(key, defaultValue as Short) else getShort(
            key
        )

        cla.isBoolean -> if (defaultValue != null) getBoolean(
            key,
            defaultValue as Boolean
        ) else getBoolean(key)

        cla.isSting -> if (defaultValue != null) getString(
            key,
            defaultValue as String
        ) else getString(key)

        cla.isCharSequence -> if (defaultValue != null) getCharSequence(
            key,
            defaultValue as CharSequence
        ) else getCharSequence(key)

        cla.isBundle -> getBundle(key)
        cla.isByteArray -> getByteArray(key)
        cla.isIntArray -> getIntArray(key)
        cla.isLongArray -> getLongArray(key)
        cla.isFloatArray -> getFloatArray(key)
        cla.isDoubleArray -> getDoubleArray(key)
        cla.isCharArray -> getCharArray(key)
        cla.isShortArray -> getShortArray(key)
        cla.isBooleanArray -> getBooleanArray(key)
        cla.isArray -> {
            val componentType = cla.componentType
                ?: throw InvalidParameterException("Bundle extra $key has wrong type ${cla.name}")
            when {
                componentType.isByte -> getByteArray(key)
                componentType.isInt -> getIntArray(key)
                componentType.isLong -> getLongArray(key)
                componentType.isFloat -> getFloatArray(key)
                componentType.isDouble -> getDoubleArray(key)
                componentType.isChar -> getCharArray(key)
                componentType.isShort -> getShortArray(key)
                componentType.isBoolean -> getBooleanArray(key)
                componentType.isSting -> getStringArray(key)
                componentType.isCharSequence -> getCharSequenceArray(key)
                componentType.isParcelable -> getParcelableArray(key)
                else -> get(key, cla)
            }
        }

        cla.isSparseArray || cla.isList -> get(key, cla)
        cla.isParcelable -> getParcelable(key)
        cla.isSerializable -> getSerializable(key)
        else -> {
            if (Build.VERSION.SDK_INT >= 18 && cla.isClassOf(IBinder::class.java)) {
                getBundle(key)
            } else if (Build.VERSION.SDK_INT >= 21 && cla.isClassOf(Size::class.java)) {
                getSize(key)
            } else if (Build.VERSION.SDK_INT >= 21 && cla.isClassOf(SizeF::class.java)) {
                getSizeF(key)
            } else {
                get(key, cla)
            }
        }
    } as? D ?: defaultValue
}

/**
 * 获取Bundle中的数据
 * @receiver Bundle? Bundle对象，如果为null，则返回null
 * @param key String 键
 * @param defaultValue D? 默认值
 * @return D? 返回一个实际的对象，可以为null
 */
inline fun <reified D> Bundle?.get(key: String, defaultValue: D? = null) =
    this?.get(D::class.java, key, defaultValue)

inline fun <reified D> Bundle?.get(key: String, defaultValue: D? = null, block: D.() -> Unit) =
    this?.get<D>(key, defaultValue)?.also { block(it) }

/**
 * 获取Bundle中的数据，结果不为null
 *
 * @receiver Bundle Bundle对象
 * @param key String 键
 * @param cla Class<D> 对象类型
 * @param defaultValue D 默认值
 * @return D 返回一个实际的对象
 */
fun <D> Bundle.getNotNull(key: String, cla: Class<D>, defaultValue: D): D =
    get(cla, key, defaultValue)!!

/**
 * 获取Bundle中的数据，结果不为null
 *
 * @receiver Bundle Bundle对象
 * @param key String  键
 * @param defaultValue D 默认值
 * @return D 返回一个实际的对象
 */
inline fun <reified D> Bundle.getNotNull(key: String, defaultValue: D): D =
    get<D>(key, defaultValue)!!

private fun <D> Bundle.get(key: String, cla: Class<D>) = try {
    val value = get(key)
    if (value != null && value::class.java.isClassOf(cla)) {
        value
    } else {
        getJson(key, cla)
    }
} catch (e: Exception) {
    getJson(key, cla)
}

private fun <D> Bundle.getJson(
    key: String,
    cla: Class<D>
) = try {
    val json = getString(key)
    json?.fromJson(cla)
} catch (e: Exception) {
    if (e !is NullPointerException) {
        throw InvalidParameterException("Bundle extra $key has wrong type ${cla.name}")
    } else {
        null
    }
}

// --------------------------------Bundle委托-----------------------------------

/**
 * Bundle委托
 *
 * @param key String? 键
 * @param defaultValue T? 默认值
 * @param bundle Bundle? Bundle对象
 * @return BundlePreference<T> 返回一个BundlePreference对象
 */
inline fun <reified T> bundle(
    key: String? = null,
    defaultValue: T? = null,
    bundle: Bundle? = null
) = BundlePreference(T::class.java, bundle, key, defaultValue)

/**
 * Bundle委托
 *
 * @receiver Bundle Bundle对象
 * @param key String? 键
 * @param defaultValue T? 默认值
 * @return BundlePreference<T> 返回一个BundlePreference对象
 */
inline fun <reified T> Bundle.bundle(key: String? = null, defaultValue: T? = null) =
    BundlePreference(T::class.java, this, key, defaultValue)

/**
 * Bundle委托类
 *
 * @param T 类型
 * @property clazz Class<T> 类型Class
 * @property bundle Bundle? Bundle对象
 * @property key String? 键
 * @property defaultValue T? 默认值
 * @constructor 创建一个BundlePreference对象
 */
class BundlePreference<T>(
    private val clazz: Class<T>,
    private val bundle: Bundle?,
    private val key: String?,
    private val defaultValue: T? = null
) : ReadWriteProperty<Any?, T> {

    /**
     * 获取Bundle中的数据
     *
     * @param thisRef Any? 任意对象
     * @param property KProperty<*> 属性
     * @return T 返回一个实际的对象
     */
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
//        Log.d("BundleExt", "thisRef = $thisRef, property = $property")
        val findKey = findKey(property)
        return if (bundle != null) {
            bundle.get(clazz, findKey, defaultValue) as T
        } else {
            if (thisRef is Activity && thisRef.intent != null && thisRef.intent.extras != null) {
                thisRef.intent.extras.get(clazz, findKey, defaultValue) as T
            } else if (thisRef is Fragment && thisRef.arguments != null) {
                thisRef.requireArguments().get(clazz, findKey, defaultValue) as T
            } else {
                throw RuntimeException("Missing bundle parameter")
            }
        }
    }

    /**
     * 设置Bundle中的数据
     *
     * @param thisRef Any? 任意对象
     * @param property KProperty<*> 属性
     * @param value T 值
     */
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        val findKey = findKey(property)
        if (bundle != null) {
            bundle.put(findKey to value)
        } else {
            if (thisRef is Activity && thisRef.intent != null && thisRef.intent.extras != null) {
                thisRef.intent.extras.put(findKey to value)
            } else if (thisRef is Fragment && thisRef.arguments != null) {
                thisRef.requireArguments().put(findKey to value)
            } else {
                throw RuntimeException("Missing bundle parameter")
            }
        }
    }

    private fun findKey(property: KProperty<*>) = if (key.isNullOrBlank()) property.name else key
}

