package com.ducnguyen2102.werewolfmoderator.data.di

import android.content.Context
import com.ducnguyen2102.werewolfmoderator.data.local.pref.AppPrefs
import com.ducnguyen2102.werewolfmoderator.data.local.pref.PrefHelper
import org.koin.dsl.module.module

fun createPrefHelper(appPrefs: AppPrefs): PrefHelper = appPrefs

fun createAppPrefs(context: Context): AppPrefs = AppPrefs(context)


val repositoryModules = module {
//    single { createAppPrefs(get()) }
//
//    single { createPrefHelper(get()) }
}
