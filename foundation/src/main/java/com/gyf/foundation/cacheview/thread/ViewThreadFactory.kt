package com.gyf.foundation.cacheview.thread

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author geyifeng
 * @date 2020/2/25 2:50 PM
 */
internal class ViewThreadFactory : ThreadFactory {
    private val mThreadNumber = AtomicInteger(1)
    private val mNamePrefix =
        "ViewPool-" + AtomicInteger(1).getAndIncrement() + "-Thread-"

    override fun newThread(r: Runnable) = Thread(
        Thread.currentThread().threadGroup,
        r,
        mNamePrefix + mThreadNumber.getAndIncrement(),
        0
    ).apply {
        if (isDaemon) {
            isDaemon = false
        }
        if (priority != Thread.NORM_PRIORITY) {
            priority = Thread.NORM_PRIORITY
        }
    }
}