package com.ducnguyen2102.werewolfmoderator

import android.app.Application
import com.ducnguyen2102.werewolfmoderator.di.builder.modules
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}