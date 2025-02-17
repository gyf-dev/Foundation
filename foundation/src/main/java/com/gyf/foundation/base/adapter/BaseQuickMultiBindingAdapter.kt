@file:Suppress("UNCHECKED_CAST")

package com.gyf.foundation.base.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.SparseArray
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
open class BaseQuickMultiBindingAdapter(items: List<Any> = emptyList()) :
    BaseMultiItemAdapter<Any>(items) , ITag {

    @SuppressLint("UseSparseArrays")
    private val itemViewTypes = SparseArray<Int>()

    private var nextInt = 0

    @Synchronized
    fun getOrAssignInt(clazz: Class<*>): Int {
        val hashCode = clazz.hashCode()
        val existingIndex = itemViewTypes.get(hashCode, -1)
        if (existingIndex == -1) {
            itemViewTypes.put(hashCode, nextInt)
            return nextInt++
        }
        return existingIndex
    }

    private fun getInt(clazz: Class<*>): Int {
        val hashCode = clazz.hashCode()
        val existingIndex = itemViewTypes.get(hashCode, 0)
        return existingIndex
    }

    init {
        onItemViewType { position, list ->
            getInt(list[position].javaClass)
        }
    }

    inline fun <reified T, reified VB : ViewBinding> addItem(
        listener: OnBindingAdapter<T, VB>
    ) {
        val itemViewType = getOrAssignInt(T::class.java)
        addItemType(
            itemViewType,
            object : OnMultiItemAdapterListener<Any, BaseBindingViewHolder<VB>> {

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
                    item: Any?
                ) {
                    if (item == null) {
                        return
                    }
                    if (item is T) {
                        listener.onBind(holder, position, item)
                    }
                }

                override fun onBind(
                    holder: BaseBindingViewHolder<VB>,
                    position: Int,
                    item: Any?,
                    payloads: List<Any>
                ) {
                    if (item == null) {
                        return
                    }
                    if (item is T) {
                        listener.onBind(holder, position, item, payloads)
                    }
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
                listener.adapter = this@BaseQuickMultiBindingAdapter
            })
    }

    inline fun <reified T, reified VB : ViewBinding> addItem(
        crossinline convert: (holder: BaseBindingViewHolder<VB>, position: Int, item: T) -> Unit
    ) = apply {
        addItem<T, VB>(object : OnBindingAdapter<T, VB>() {
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