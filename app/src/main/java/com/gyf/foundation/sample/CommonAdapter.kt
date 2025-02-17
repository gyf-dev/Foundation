package com.gyf.foundation.sample

import com.gyf.foundation.base.adapter.BaseBindingAdapter
import com.gyf.foundation.base.adapter.viewholder.BaseBindingViewHolder
import com.gyf.foundation.sample.databinding.ItemCommonBinding

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/27 14:16
 */
class CommonAdapter : BaseBindingAdapter<ItemCommonBinding, String>() {

    override fun convert(
        holder: BaseBindingViewHolder<ItemCommonBinding>,
        position: Int,
        item: String
    ) {
        holder.binding.tvContent.text = item
    }
}