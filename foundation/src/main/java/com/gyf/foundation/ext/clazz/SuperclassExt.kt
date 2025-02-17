@file:Suppress("UNCHECKED_CAST")

package com.gyf.foundation.ext.clazz

import java.lang.reflect.ParameterizedType

/**
 * @Author Ifan.Ge
 * @Date 2024/7/1 14:07
 */

fun <T> Any.findSuperclass(targetCls: Class<*>): Class<T> {
    val superclassList = findSuperclassList<Any>(targetCls)
    if (superclassList.isEmpty()) {
        throw IllegalArgumentException("No superclass found")
    }
    return superclassList[0] as Class<T>
}

fun <T> Any.findSuperclassList(targetCls: Class<*>): List<Class<T>> {
    val list = mutableListOf<Class<T>>()
    findSuperclassInternal<T>(targetCls) { _, tClass ->
        list.add(tClass)
    }
    return list
}


fun <T> Any.findSuperclassMap(cls: Class<*>): Map<Int, Class<T>> {
    val map = LinkedHashMap<Int, Class<T>>()
    findSuperclassInternal<T>(cls) { i, tClass ->
        map[i] = tClass
    }
    return map
}

private fun <T> Any.findSuperclassInternal(
    targetCls: Class<*>,
    block: (Int, Class<T>) -> Unit
) {
    val parameterizedType = findParameterizedType(javaClass, targetCls)
    if (parameterizedType != null) {
        val types = parameterizedType.actualTypeArguments
        for (i in types.indices) {
            val type = types[i]
            if (type is Class<*> && targetCls.isAssignableFrom(type)) {
                val tClass = type as Class<T>
                block(i, tClass)
            }
        }
    }
}

private fun findParameterizedType(cla: Class<*>, targetCls: Class<*>): ParameterizedType? {
    val genericSuperclass = cla.genericSuperclass
    val parameterizedType: ParameterizedType?
    if (genericSuperclass is ParameterizedType) {
        if (hasSuperclassClass(genericSuperclass, targetCls)) {
            parameterizedType = genericSuperclass
        } else {
            val claNext = cla.superclass
            parameterizedType =
                if (claNext != null) findParameterizedType(claNext, targetCls) else null
        }
    } else {
        val claNext = cla.superclass
        parameterizedType =
            if (claNext != null) findParameterizedType(claNext, targetCls) else null
    }
    return parameterizedType
}


private fun hasSuperclassClass(
    parameterizedType: ParameterizedType?,
    targetCls: Class<*>
): Boolean {
    if (parameterizedType != null) {
        val types = parameterizedType.actualTypeArguments
        for (i in types.indices) {
            val type = types[i]
            if (type is Class<*> && targetCls.isAssignableFrom(type)) {
                return true
            }
        }
    }
    return false
}
