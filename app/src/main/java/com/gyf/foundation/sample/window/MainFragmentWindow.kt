package com.gyf.foundation.sample.window

import android.os.Bundle
import com.gyf.foundation.sample.MainFragment
import com.gyf.foundation.sample.databinding.ActivityMainBinding
import com.gyf.foundation.window.FragmentWindow

/**
 * @Author  Ifan.Ge
 * @Date    2024/6/27 17:54
 */
class MainFragmentWindow : FragmentWindow() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(binding.flContent.id, mainFragment)
            .setPrimaryNavigationFragment(mainFragment)
            .addToBackStack(null)
            .commit()
    }
}