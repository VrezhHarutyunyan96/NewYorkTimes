package com.android.weatherapp.nextstack.nytimes.ui.main

import android.os.Bundle
import com.android.weatherapp.nextstack.nytimes.R
import com.android.weatherapp.nextstack.nytimes.base.BaseActivity
import com.android.weatherapp.nextstack.nytimes.databinding.ActivityMainBinding
import com.android.weatherapp.nextstack.nytimes.ui.home.view.fragment.HomeFragment
import com.android.weatherapp.nextstack.nytimes.utils.FragmentAnimationType
import com.android.weatherapp.nextstack.nytimes.utils.openFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val fragment = HomeFragment.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        openFragment(
            fragment = fragment,
            addToBackStack = true,
            animationType = FragmentAnimationType.SLIDE_VERTICAL
        )
    }
}