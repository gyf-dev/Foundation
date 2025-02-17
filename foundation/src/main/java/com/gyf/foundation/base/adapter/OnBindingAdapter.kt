package com.gyf.foundation.base.adapter

import androidx.viewbinding.ViewBinding
import com.chad.library.adapter4.BaseMultiItemAdapter
import com.gyf.foundation.base.adapter.viewholder.BaseBindingViewHolder
import com.gyf.foundation.ext.log.ITag

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/23 14:42
 */
abstract class OnBindingAdapter<T, VB : ViewBinding> : ITag {

    lateinit var adapter: BaseMultiItemAdapter<*>

    val recyclerView get() = adapter.recyclerView

    abstract fun onBind(holder: BaseBindingViewHolder<VB>, position: Int, item: T)

    open fun onBind(
        holder: BaseBindingViewHolder<VB>,
        position: Int,
        item: T,
        payloads: List<Any>
    ) {
        onBind(holder, position, item)
    }

    open fun onViewAttachedToWindow(holder: BaseBindingViewHolder<VB>) {

    }

    open fun onViewDetachedFromWindow(holder: BaseBindingViewHolder<VB>) {

    }

    open fun onViewRecycled(holder: BaseBindingViewHolder<VB>) {

    }

    open fun onFailedToRecycleView(holder: BaseBindingViewHolder<VB>): Boolean {
        return false
    }

    open fun isFullSpanItem(itemType: Int): Boolean {
        return false
    }

    companion object {
        fun <T, VB : ViewBinding> empty() = object : OnBindingAdapter<T, VB>() {
            override fun onBind(
                holder: BaseBindingViewHolder<VB>,
                position: Int,
                item: T
            ) {
            }
        }
    }
}