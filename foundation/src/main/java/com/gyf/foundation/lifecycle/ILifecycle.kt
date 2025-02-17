package com.gyf.foundation.lifecycle

/**
 * @constructor Create empty I speech
 * @Author  Ifan.Ge
 * @Date    2024/5/6 16:57
 */
interface ILifecycle {

    /**
     * @param inParams Array<out Any>
     */
    fun create(vararg inParams: Any) {

    }


    /**
     * @param inParams Array<out Any>
     */
    fun start(vararg inParams: Any) {

    }


    /**
     * @param inParams Array<out Any>
     */
    fun resume(vararg inParams: Any) {

    }


    /**
     * @param inParams Array<out Any>
     */
    fun pause(vararg inParams: Any) {

    }


    /**
     * @param inParams Array<out Any>
     */
    fun stop(vararg inParams: Any) {

    }


    /**
     * @param inParams Array<out Any>
     */
    fun destroy(vararg inParams: Any) {

    }

    /**
     * @param inParams Array<out Any>
     */
    fun reset(vararg inParams: Any) {

    }
}