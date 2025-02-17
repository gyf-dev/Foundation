@file:Suppress("UNCHECKED_CAST")

package com.gyf.foundation.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter4.BaseMultiItemAdapter
import com.gyf.foundation.base.adapter.viewholder.BaseBindingViewHolder
import com.gyf.foundation.ext.log.ITag
import com.gyf.foundation.ext.viewbinding.inflateBinding

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/8 14:28
 */
open class BaseMultiBindingAdapter<T : Any>(items: List<T> = emptyList()) :
    BaseMultiItemAdapter<T>(items), ITag {

    inline fun <reified VB : ViewBinding> addItem(
        itemViewType: Int,
        listener: OnBindingAdapter<T, VB>
    ) {
        addItemType(
            itemViewType,
            object : OnMultiItemAdapterListener<T, BaseBindingViewHolder<VB>> {

                override fun onCreate(
                    context: Context,
                    parent: ViewGroup,
                    viewType: Int
                ): BaseBindingViewHolder<VB> {
                    val binding = VB::class.java.inflateBinding(
                        LayoutInflater.from(context),
                        parent
                    )
                    return BaseBindingViewHolder(binding)
                }

                override fun onBind(
                    holder: BaseBindingViewHolder<VB>,
                    position: Int,
                    item: T?
                ) {
                    if (item == null) {
                        return
                    }
                    listener.onBind(holder, position, item)
                }

                override fun onBind(
                    holder: BaseBindingViewHolder<VB>,
                    position: Int,
                    item: T?,
                    payloads: List<Any>
                ) {
                    if (item == null) {
                        return
                    }
                    listener.onBind(holder, position, item, payloads)
                }

                override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
                    if (holder is BaseBindingViewHolder<*>) {
                        listener.onViewDetachedFromWindow(holder as BaseBindingViewHolder<VB>)
                    }
                }

                override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
                    if (holder is BaseBindingViewHolder<*>) {
                        listener.onViewAttachedToWindow(holder as BaseBindingViewHolder<VB>)
                    }
                }

                override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
                    if (holder is BaseBindingViewHolder<*>) {
                        listener.onViewRecycled(holder as BaseBindingViewHolder<VB>)
                    }
                }

                override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean {
                    if (holder is BaseBindingViewHolder<*>) {
                        return listener.onFailedToRecycleView(holder as BaseBindingViewHolder<VB>)
                    }
                    return false
                }

                override fun isFullSpanItem(itemType: Int): Boolean {
                    return listener.isFullSpanItem(itemType)
                }

            }.apply {
                listener.adapter = this@BaseMultiBindingAdapter
            })
    }

    inline fun <reified VB : ViewBinding> addItem(
        itemViewType: Int,
        crossinline convert: (holder: BaseBindingViewHolder<VB>, position: Int, item: T) -> Unit
    ) = apply {
        addItem(
            itemViewType,
            object : OnBindingAdapter<T, VB>() {
                override fun onBind(
                    holder: BaseBindingViewHolder<VB>,
                    position: Int,
                    item: T
                ) {
                    convert(holder, position, item)
                }
            })
    }
}