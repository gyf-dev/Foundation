package com.gyf.foundation.base.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.gyf.foundation.ext.log.ITag

/**
 * @Author  Ifan.Ge
 * @Date    2024/7/8 14:14
 */
class BaseBindingViewHolder<VB : ViewBinding>(val binding: VB) :
    RecyclerView.ViewHolder(binding.root), ITag