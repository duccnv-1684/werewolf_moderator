package com.ducnguyen2102.werewolfmoderator.di.builder

import com.ducnguyen2102.werewolfmoderator.ui.MainSharedViewModel
import com.ducnguyen2102.werewolfmoderator.ui.pickcharacter.PickCharacterViewModel
import com.ducnguyen2102.werewolfmoderator.ui.setnumberplayer.SetNumberPlayerViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModels = module {
    viewModel { SetNumberPlayerViewModel(get()) }

    viewModel { PickCharacterViewModel(get()) }

    viewModel { MainSharedViewModel() }
}