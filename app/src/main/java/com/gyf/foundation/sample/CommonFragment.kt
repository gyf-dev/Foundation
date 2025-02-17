package com.gyf.foundation.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.gyf.foundation.base.fragment.BaseBindingFragment
import com.gyf.foundation.sample.databinding.LayoutCommonBinding

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/27 14:17
 */
open class CommonFragment : BaseBindingFragment<LayoutCommonBinding>() {

    private val adapter by lazy { CommonAdapter() }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvContent.adapter = adapter
    }

    fun setOnItemClick(listener: (position: Int) -> Unit) = apply {
        adapter.setOnItemClickListener { _, _, position ->
            listener(position)
        }
    }

    fun setData(vararg data: String) = apply {
        adapter.submitList(data.toList())
    }

    fun setData(list: List<String>) = apply {
        adapter.submitList(list)
    }
}

fun CommonFragment.replaceFragment(
    list: List<String>,
    isPrimary: Boolean = false,
    listener: (position: Int) -> Unit
): Fragment {
    val fragment = CommonFragment().setData(list).setOnItemClick(listener)
    childFragmentManager.beginTransaction()
        .replace(binding.flContent.id, fragment)
        .addToBackStack(null)
        .apply {
            if (isPrimary) {
                setPrimaryNavigationFragment(fragment)
            }
        }
        .commit()
    return fragment
}