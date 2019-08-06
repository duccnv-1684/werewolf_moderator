package com.ducnguyen2102.werewolfmoderator.ui.setnumberplayer

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.ducnguyen2102.werewolfmoderator.BR
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseFragment
import com.ducnguyen2102.werewolfmoderator.binding.FragmentDataBindingComponent
import com.ducnguyen2102.werewolfmoderator.databinding.FragmentSetNumberPlayerBinding
import com.ducnguyen2102.werewolfmoderator.extension.hideKeyBoard
import com.ducnguyen2102.werewolfmoderator.ui.MainSharedViewModel
import kotlinx.android.synthetic.main.fragment_set_number_player.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SetNumberPlayerFragment : BaseFragment<FragmentSetNumberPlayerBinding, SetNumberPlayerViewModel>() {

    override val bindingVariable = BR.viewModel

    override val layoutId = R.layout.fragment_set_number_player

    override val viewModel: SetNumberPlayerViewModel by viewModel()

    private val sharedViewModel: MainSharedViewModel by sharedViewModel()

    private var bindingComponent = FragmentDataBindingComponent(this)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.run {
        }
        confirm.setOnClickListener {
            val inputText = numberPlayer.editText?.text.toString()
            val numberPlayers = inputText.toIntOrNull()
            numberPlayers?.let {
                sharedViewModel.numberPlayers.value = it
                hideKeyBoard()
                findNavController().navigate(R.id.action_mainFragment_to_pickCharacterFragment)
            }
        }
        subscribeUI()
    }

    private fun subscribeUI() {
    }
}
