package com.gyf.foundation.ext.json

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

/**
 * DefaultIfNullFactory类是一个JsonAdapter.Factory的实现。
 * 它的主要功能是创建一个新的JsonAdapter，该JsonAdapter可以处理null值。
 * 当从JsonReader读取json值时，如果遇到null值，它会过滤掉这些null值。
 * 在将值写入JsonWriter时，它将委托给下一个适配器来处理。
 *
 * @author  ifan
 * @date  2024/6/20 11:05
 */
class DefaultIfNullsFactory : JsonAdapter.Factory {

    override fun create(
        type: Type,
        annotations: MutableSet<out Annotation>,
        moshi: Moshi
    ): JsonAdapter<*> {
        val delegate = moshi.nextAdapter<Any>(this, type, annotations)
        return object : JsonAdapter<Any>() {
            override fun fromJson(reader: JsonReader): Any? {
                val blob = try {
                    reader.readJsonValue()
                } catch (e: Exception) {
                    null
                }
                if (blob is Map<*, *>) {
                    val noNulls = blob.filterValues { it != null }
                    return delegate.fromJsonValue(noNulls)
                }
                return delegate.fromJsonValue(blob)
            }

            override fun toJson(writer: JsonWriter, value: Any?) {
                return delegate.toJson(writer, value)
            }
        }
    }

}