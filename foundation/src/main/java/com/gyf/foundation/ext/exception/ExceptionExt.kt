package com.gyf.foundation.ext.exception

/**
 * @author  ifan
 * @date  2022/3/2 15:24
 */

fun <T> tryResult(block: () -> T) = tryResult(null, block)

fun <T> tryResult(exception: (() -> T)? = null, block: () -> T) = try {
    block()
} catch (e: Exception) {
    exception?.invoke()
}