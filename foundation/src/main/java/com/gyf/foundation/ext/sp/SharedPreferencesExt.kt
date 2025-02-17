package com.gyf.foundation.ext.sp

import android.content.Context
import android.content.SharedPreferences
import com.gyf.foundation.Foundation
import com.gyf.foundation.ext.clazz.isBoolean
import com.gyf.foundation.ext.clazz.isFloat
import com.gyf.foundation.ext.clazz.isInt
import com.gyf.foundation.ext.clazz.isLong
import com.gyf.foundation.ext.clazz.isSet
import com.gyf.foundation.ext.clazz.isSting
import com.gyf.foundation.ext.exception.tryResult
import com.gyf.foundation.ext.json.fromJson
import com.gyf.foundation.ext.json.toJson
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * SharedPreferences扩展函数
 * @author gyf
 * @date 2020/9/17
 */

inline fun <reified R, reified T> R.sp(
    defaultValue: T? = null,
    apply: Boolean = true,
    noinline after: ((T) -> Unit)? = null
) = Preference(
    Foundation.context.applicationContext,
    defaultValue,
    T::class.java,
    apply,
    R::class.java.name,
    after
)

class Preference<T>(
    private val context: Context,
    private val defaultValue: T?,
    private val clazz: Class<T>,
    private val apply: Boolean,
    private val fileName: String = "fileName",
    private val setBlock: ((T) -> Unit)? = null
) : ReadWriteProperty<Any?, T> {

    private val preferences by lazy {
        context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        val key = findKey(property)
        return when (defaultValue) {
            null -> preferences.getNull(key, clazz)
            else -> preferences.get(key, clazz, defaultValue)
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        val key = findKey(property)
        when (value) {
            null -> preferences.putNull(key, clazz, apply)
            else -> preferences.put(key, value, clazz, apply)
        }
        setBlock?.invoke(value)
    }

    private fun findKey(property: KProperty<*>) = property.name
}

private fun <T> SharedPreferences.getNull(key: String, clazz: Class<T>): T {
    return when {
        clazz.isSet -> try {
            getStringSet(key, null) ?: getJson(key, clazz)
        } catch (e: Exception) {
            getJson(key, clazz)
        }

        clazz.isSting -> getString(key, null)
        clazz.isInt -> try {
            getInt(key, 0)
        } catch (e: Exception) {
            0
        }

        clazz.isLong -> try {
            getLong(key, 0L)
        } catch (e: Exception) {
            0L
        }

        clazz.isFloat -> try {
            getFloat(key, 0f)
        } catch (e: Exception) {
            0f
        }

        clazz.isBoolean -> try {
            getBoolean(key, false)
        } catch (e: Exception) {
            false
        }

        else -> getJson(key, clazz)
    } as T
}

@Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
private fun <T> SharedPreferences.get(key: String, clazz: Class<T>, defaultValue: T): T {
    return try {
        when (defaultValue) {
            is Set<*> -> if (defaultValue.toTypedArray().isArrayOf<String>()) {
                getStringSet(key, defaultValue as Set<String>)
            } else {
                getJson(key, clazz) ?: defaultValue
            }

            is String -> getString(key, defaultValue)
            is Int -> getInt(key, defaultValue)
            is Long -> getLong(key, defaultValue)
            is Float -> getFloat(key, defaultValue)
            is Boolean -> getBoolean(key, defaultValue)
            else -> getJson(key, clazz) ?: defaultValue
        } as T
    } catch (e: Exception) {
        defaultValue
    }
}

private fun SharedPreferences.putNull(key: String, clazz: Class<*>, apply: Boolean) {
    edit().apply {
        when {
            clazz.isSet -> try {
                putStringSet(key, null as Set<String>?)
            } catch (e: Exception) {
                putString(key, null)
            }

            clazz.isSting -> putString(key, null)
            clazz.isInt -> putInt(key, 0)
            clazz.isLong -> putLong(key, 0L)
            clazz.isFloat -> putFloat(key, 0f)
            clazz.isBoolean -> putBoolean(key, false)
            else -> putString(key, null)
        }
    }.apply {
        if (apply) apply() else commit()
    }
}

@Suppress("UNCHECKED_CAST")
private fun <T> SharedPreferences.put(key: String, value: T, clazz: Class<T>, apply: Boolean) {
    edit().apply {
        when (value) {
            is Set<*> -> if (value.toTypedArray().isArrayOf<String>()) {
                putStringSet(key, value as Set<String>)
            } else {
                putJson(key, value, clazz)
            }

            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            is Boolean -> putBoolean(key, value)
            else -> putJson(key, value, clazz)
        }
    }.apply {
        if (apply) apply() else commit()
    }
}

private fun <T> SharedPreferences.getJson(key: String, clazz: Class<T>) =
    tryResult { getString(key, null)?.fromJson(clazz) }

private fun <T> SharedPreferences.Editor.putJson(
    key: String,
    value: T,
    clazz: Class<T>
) {
    putString(key, tryResult { value.toJson(clazz) })
}