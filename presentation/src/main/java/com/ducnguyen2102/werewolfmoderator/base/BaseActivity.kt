package com.ducnguyen2102.werewolfmoderator.base

import androidx.appcompat.app.AppCompatActivity
import com.ducnguyen2102.werewolfmoderator.R

abstract class BaseActivity : AppCompatActivity() {
    abstract fun firstFragment(): BaseFragment<*, *>

    override fun onBackPressed() {
        ((supportFragmentManager.findFragmentById(R.id.container)) as BaseFragment<*, *>).onBackPressed()
        super.onBackPressed()
    }
}