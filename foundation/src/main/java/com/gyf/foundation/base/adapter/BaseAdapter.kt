package com.gyf.foundation.base.adapter

import android.content.Context
import android.view.ViewGroup
import com.chad.library.adapter4.BaseQuickAdapter
import com.gyf.foundation.base.adapter.viewholder.BaseViewHolder
import com.gyf.foundation.ext.inflater.inflate
import com.gyf.foundation.ext.log.ITag

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/1 16:13
 */
abstract class BaseAdapter<T : Any>(private val layoutResId: Int, items: List<T> = emptyList()) :
    BaseQuickAdapter<T, BaseViewHolder>(items) , ITag {

    final override fun onBindViewHolder(holder: BaseViewHolder, position: Int, item: T?) {
        if (item == null) {
            return
        }
        convert(holder, position, item)
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder,
        position: Int,
        item: T?,
        payloads: List<Any>
    ) {
        if (item == null) {
            return
        }
        convert(holder, position, item, payloads)
    }

    abstract fun convert(holder: BaseViewHolder, position: Int, item: T)

    open fun convert(holder: BaseViewHolder, position: Int, item: T, payloads: List<Any>) {
        convert(holder, position, item)
    }

    final override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        return BaseViewHolder(parent.inflate(layoutResId))
    }
}