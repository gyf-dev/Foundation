package com.gyf.foundation.ext.clazz

import android.os.Bundle
import android.os.Parcelable
import android.util.SparseArray
import java.io.Serializable

/**
 * 扩展包，包含了一些关于 Class 的扩展方法
 *
 * @Author  Ifan.Ge
 * @Date    2024/6/20 10:33
 */

/**
 * 判断当前类是否是指定类的子类
 *
 * @param clazz 指定的类
 * @return 如果当前类是指定类的子类，则返回 true，否则返回 false
 */
fun <T> Class<*>.isClassOf(clazz: Class<T>) = clazz.isAssignableFrom(this)

/**
 * 判断当前类是否是 Byte 类型
 *
 * @return 如果当前类是 Byte 类型，则返回 true，否则返回 false
 */
val Class<*>.isByte get() = isClassOf(java.lang.Byte::class.java) || isClassOf(Byte::class.java)

/**
 * 判断当前类是否是 Int 类型
 *
 * @return 如果当前类是 Int 类型，则返回 true，否则返回 false
 */
val Class<*>.isInt get() = isClassOf(java.lang.Integer::class.java) || isClassOf(Int::class.java)

/**
 * 判断当前类是否是 Long 类型
 *
 * @return 如果当前类是 Long 类型，则返回 true，否则返回 false
 */
val Class<*>.isLong get() = isClassOf(java.lang.Long::class.java) || isClassOf(Long::class.java)

/**
 * 判断当前类是否是 Float 类型
 *
 * @return 如果当前类是 Float 类型，则返回 true，否则返回 false
 */
val Class<*>.isFloat get() = isClassOf(java.lang.Float::class.java) || isClassOf(Float::class.java)

/**
 * 判断当前类是否是 Double 类型
 *
 * @return 如果当前类是 Double 类型，则返回 true，否则返回 false
 */
val Class<*>.isDouble get() = isClassOf(java.lang.Double::class.java) || isClassOf(Double::class.java)

/**
 * 判断当前类是否是 Char 类型
 *
 * @return 如果当前类是 Char 类型，则返回 true，否则返回 false
 */
val Class<*>.isChar get() = isClassOf(java.lang.Character::class.java) || isClassOf(Char::class.java)

/**
 * 判断当前类是否是 Short 类型
 *
 * @return 如果当前类是 Short 类型，则返回 true，否则返回 false
 */
val Class<*>.isShort get() = isClassOf(java.lang.Short::class.java) || isClassOf(Short::class.java)

/**
 * 判断当前类是否是 Boolean 类型
 *
 * @return 如果当前类是 Boolean 类型，则返回 true，否则返回 false
 */
val Class<*>.isBoolean get() = isClassOf(java.lang.Boolean::class.java) || isClassOf(Boolean::class.java)

/**
 * 判断当前类是否是 CharSequence 类型
 *
 * @return 如果当前类是 CharSequence 类型，则返回 true，否则返回 false
 */
val Class<*>.isCharSequence
    get() = isClassOf(java.lang.CharSequence::class.java) || isClassOf(
        CharSequence::class.java
    )

/**
 * 判断当前类是否是 String 类型
 *
 * @return 如果当前类是 String 类型，则返回 true，否则返回 false
 */
val Class<*>.isSting get() = isClassOf(java.lang.String::class.java) || isClassOf(String::class.java)

/**
 * 判断当前类是否是 Bundle 类型
 *
 * @return 如果当前类是 Bundle 类型，则返回 true，否则返回 false
 */
val Class<*>.isBundle get() = isClassOf(Bundle::class.java)

/**
 * 判断当前类是否是 ByteArray 类型
 *
 * @return 如果当前类是 ByteArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isByteArray get() = isClassOf(ByteArray::class.java)

/**
 * 判断当前类是否是 IntArray 类型
 *
 * @return 如果当前类是 IntArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isIntArray get() = isClassOf(IntArray::class.java)

/**
 * 判断当前类是否是 LongArray 类型
 *
 * @return 如果当前类是 LongArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isLongArray get() = isClassOf(LongArray::class.java)

/**
 * 判断当前类是否是 FloatArray 类型
 *
 * @return 如果当前类是 FloatArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isFloatArray get() = isClassOf(FloatArray::class.java)

/**
 * 判断当前类是否是 DoubleArray 类型
 *
 * @return 如果当前类是 DoubleArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isDoubleArray get() = isClassOf(DoubleArray::class.java)

/**
 * 判断当前类是否是 CharArray 类型
 *
 * @return 如果当前类是 CharArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isCharArray get() = isClassOf(CharArray::class.java)

/**
 * 判断当前类是否是 ShortArray 类型
 *
 * @return 如果当前类是 ShortArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isShortArray get() = isClassOf(ShortArray::class.java)

/**
 * 判断当前类是否是 BooleanArray 类型
 *
 * @return 如果当前类是 BooleanArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isBooleanArray get() = isClassOf(BooleanArray::class.java)

/**
 * 判断当前类是否是 SparseArray 类型
 *
 * @return 如果当前类是 SparseArray 类型，则返回 true，否则返回 false
 */
val Class<*>.isSparseArray get() = isClassOf(SparseArray::class.java)

/**
 * 判断当前类是否是 Parcelable 类型
 *
 * @return 如果当前类是 Parcelable 类型，则返回 true，否则返回 false
 */
val Class<*>.isParcelable get() = isClassOf(Parcelable::class.java)

/**
 * 判断当前类是否是 Serializable 类型
 *
 * @return 如果当前类是 Serializable 类型，则返回 true，否则返回 false
 */
val Class<*>.isSerializable get() = isClassOf(Serializable::class.java)

/**
 * 判断当前类是否是 Collection 类型
 *
 * @return 如果当前类是 Collection 类型，则返回 true，否则返回 false
 */
val Class<*>.isCollection get() = isClassOf(Collection::class.java)

/**
 * 判断当前类是否是 ArrayList 类型
 *
 * @return 如果当前类是 ArrayList 类型，则返回 true，否则返回 false
 */
val Class<*>.isArrayList get() = isClassOf(ArrayList::class.java)

/**
 * 判断当前类是否是 List 类型
 *
 * @return 如果当前类是 List 类型，则返回 true，否则返回 false
 */
val Class<*>.isList get() = isClassOf(List::class.java)

/**
 * 判断当前类是否是 Map 类型
 *
 * @return 如果当前类是 Map 类型，则返回 true，否则返回 false
 */
val Class<*>.isMap get() = isClassOf(Map::class.java)

/**
 * 判断当前类是否是 Set 类型
 *
 * @return 如果当前类是 Set 类型，则返回 true，否则返回 false
 */
val Class<*>.isSet get() = isClassOf(Set::class.java)
