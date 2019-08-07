package com.ducnguyen2102.werewolfmoderator.ui.gameplay

import android.os.Bundle
import com.ducnguyen2102.werewolfmoderator.BR
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseFragment
import com.ducnguyen2102.werewolfmoderator.binding.FragmentDataBindingComponent
import com.ducnguyen2102.werewolfmoderator.databinding.FragmentGamePlayBinding
import com.ducnguyen2102.werewolfmoderator.ui.MainSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamePlayFragment : BaseFragment<FragmentGamePlayBinding, GamePlayViewModel>() {

    override val bindingVariable = BR.viewModel

    override val layoutId = R.layout.fragment_game_play

    override val viewModel: GamePlayViewModel by viewModel()

    private val sharedViewModel: MainSharedViewModel by sharedViewModel()

    private var bindingComponent = FragmentDataBindingComponent(this)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.run {
        }
        subscribeUI()
    }

    private fun subscribeUI() {
    }
}