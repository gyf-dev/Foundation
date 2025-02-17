package com.gyf.foundation.window.delegate

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.FragmentHostCallback

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/28 13:39
 */
open class FragmentHostCallbacks<E>(
    private val owner: E,
    windowAnimations: Int = 0
) : FragmentHostCallback<E>(
    owner, Handler(Looper.getMainLooper()), windowAnimations
), IComponent by owner
        where E : Context, E : IComponent {
    override fun onGetHost() = owner
}
