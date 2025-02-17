package com.gyf.foundation.sample.window

import android.os.Bundle
import android.view.View
import com.chad.library.adapter4.BaseQuickAdapter
import com.gyf.foundation.sample.CommonAdapter
import com.gyf.foundation.sample.databinding.LayoutCommonBinding
import com.gyf.foundation.window.Window

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/27 13:50
 */
abstract class CommonWindow : Window(), BaseQuickAdapter.OnItemClickListener<String> {

    protected val binding by lazy { LayoutCommonBinding.inflate(layoutInflater) }

    protected val adapter by lazy { CommonAdapter() }

    abstract val obtainList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvContent.adapter = adapter
        adapter.submitList(obtainList)
        adapter.setOnItemClickListener(this)
    }

    override fun onClick(adapter: BaseQuickAdapter<String, *>, view: View, position: Int) {

    }
}
