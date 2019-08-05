package com.ducnguyen2102.werewolfmoderator.di.builder

import com.ducnguyen2102.werewolfmoderator.data.di.networkModules
import com.ducnguyen2102.werewolfmoderator.data.di.repositoryModules
import com.ducnguyen2102.werewolfmoderator.rx.AppSchedulerProvider
import com.ducnguyen2102.werewolfmoderator.rx.SchedulerProvider
import org.koin.dsl.module.module

val schedulers = module {
    single<SchedulerProvider> { AppSchedulerProvider() }
}

val modules = listOf(viewModels, schedulers, networkModules, repositoryModules)