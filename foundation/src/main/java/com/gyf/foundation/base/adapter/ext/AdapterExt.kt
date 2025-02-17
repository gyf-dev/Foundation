package com.gyf.foundation.base.adapter.ext

import androidx.annotation.IntRange
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter4.BaseQuickAdapter
import com.gyf.foundation.base.adapter.BaseAdapter
import com.gyf.foundation.base.adapter.BaseBindingAdapter
import com.gyf.foundation.base.adapter.viewholder.BaseBindingViewHolder
import com.gyf.foundation.base.adapter.viewholder.BaseViewHolder

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/1 16:49
 */
@Suppress("FunctionName")
fun <VB : ViewBinding, T : Any> SimpleBindingAdapter(
    convert: (holder: BaseBindingViewHolder<VB>, position: Int, item: T) -> Unit
) = object : BaseBindingAdapter<VB, T>() {
    override fun convert(
        holder: BaseBindingViewHolder<VB>,
        position: Int,
        item: T
    ) {
        convert.invoke(holder, position, item)
    }
}

@Suppress("FunctionName")
fun <T : Any> SimpleAdapter(
    layoutResId: Int,
    convert: (viewHolder: BaseViewHolder, position: Int, item: T) -> Unit
) = object : BaseAdapter<T>(layoutResId) {
    override fun convert(holder: BaseViewHolder, position: Int, item: T) {
        convert.invoke(holder, position, item)
    }
}

private fun <T : Any> BaseQuickAdapter<T, *>.mutableItems(): MutableList<T> {
    return when (items) {
        is java.util.ArrayList -> {
            items as java.util.ArrayList
        }

        is MutableList -> {
            items as MutableList
        }

        else -> {
            items.toMutableList().apply { items = this }
        }
    }
}

operator fun <T : Any> BaseQuickAdapter<T, *>.set(
    @IntRange(from = 0) position: Int,
    data: T,
    payloads: Any
) {
    if (position >= items.size) {
        throw IndexOutOfBoundsException("position: ${position}. size:${items.size}")
    }
    mutableItems()[position] = data
    notifyItemChanged(position, payloads)
}

fun <T : Any> BaseQuickAdapter<T, *>.getItemNonNull(position: Int) = getItem(position)!!