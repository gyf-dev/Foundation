package com.gyf.foundation.sample

import android.os.Bundle
import android.view.View
import com.chad.library.adapter4.BaseQuickAdapter
import com.gyf.foundation.base.activity.BaseBindingActivity
import com.gyf.foundation.sample.databinding.LayoutCommonBinding

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/27 13:50
 */
abstract class CommonActivity : BaseBindingActivity<LayoutCommonBinding>(),
    BaseQuickAdapter.OnItemClickListener<String> {

    private val adapter by lazy { CommonAdapter() }

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

    fun replaceFragment(
        list: List<String>,
        isPrimary: Boolean = false,
        listener: (position: Int) -> Unit
    ) {
        val fragment = CommonFragment().setData(list).setOnItemClick(listener)
        supportFragmentManager.beginTransaction()
            .replace(binding.flContent.id, fragment)
            .addToBackStack(null)
            .apply {
                if (isPrimary) {
                    setPrimaryNavigationFragment(fragment)
                }
            }
            .commit()
    }
}
