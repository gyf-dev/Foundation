package com.gyf.foundation.sample

import android.os.Bundle
import com.gyf.foundation.base.activity.BaseBindingActivity
import com.gyf.foundation.sample.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(binding.flContent.id, mainFragment)
            .setPrimaryNavigationFragment(mainFragment)
            .addToBackStack(null)
            .commit()
    }
}