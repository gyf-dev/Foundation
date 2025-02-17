@file:Suppress("UNCHECKED_CAST")

package com.gyf.foundation.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter4.BaseQuickAdapter
import com.gyf.foundation.base.adapter.viewholder.BaseBindingViewHolder
import com.gyf.foundation.ext.log.ITag
import com.gyf.foundation.ext.viewbinding.viewBindingByClassGenerics

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/1 16:23
 */
abstract class BaseBindingAdapter<VB : ViewBinding, T : Any>(items: List<T> = emptyList()) :
    BaseQuickAdapter<T, BaseBindingViewHolder<VB>>(items), ITag {

    init {
        addOnViewAttachStateChangeListener(object : OnViewAttachStateChangeListener {
            override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
                if (holder is BaseBindingViewHolder<*>) {
                    this@BaseBindingAdapter.onViewAttachedToWindow(holder as BaseBindingViewHolder<VB>)
                }
            }

            override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
                if (holder is BaseBindingViewHolder<*>) {
                    this@BaseBindingAdapter.onViewDetachedFromWindow(holder as BaseBindingViewHolder<VB>)
                }
            }
        })
    }

    final override fun onBindViewHolder(
        holder: BaseBindingViewHolder<VB>,
        position: Int,
        item: T?
    ) {
        if (item == null) {
            return
        }
        convert(holder, position, item)
    }

    final override fun onBindViewHolder(
        holder: BaseBindingViewHolder<VB>,
        position: Int,
        item: T?,
        payloads: List<Any>
    ) {
        if (item == null) {
            return
        }
        convert(holder, position, item, payloads)
    }

    abstract fun convert(holder: BaseBindingViewHolder<VB>, position: Int, item: T)

    open fun convert(
        holder: BaseBindingViewHolder<VB>, position: Int, item: T,
        payloads: List<Any>
    ) {
        convert(holder, position, item)
    }

    final override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): BaseBindingViewHolder<VB> {
        return BaseBindingViewHolder(
            viewBindingByClassGenerics(
                LayoutInflater.from(parent.context),
                parent
            )
        )
    }

    open fun onViewAttachedToWindow(holder: BaseBindingViewHolder<VB>) {

    }

    open fun onViewDetachedFromWindow(holder: BaseBindingViewHolder<VB>) {

    }
}