package com.ducnguyen2102.werewolfmoderator.ui.setnumberplayer

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
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
        next.setOnClickListener {
            val inputText = numberPlayer.editText?.text.toString()
            val numberPlayers = inputText.toIntOrNull()
            numberPlayers?.let {
                if (it in 5..30) {
                    sharedViewModel.numberPlayers.value = it
                    sharedViewModel.listPickingCharacter.value = null
                    hideKeyBoard()
                    findNavController().navigate(R.id.action_mainFragment_to_pickCharacterFragment)
                } else {
                    Toast.makeText(context, R.string.number_player_error, Toast.LENGTH_LONG).show()
                }
            }
        }
        subscribeUI()
    }

    private fun subscribeUI() {
        sharedViewModel.run {
            numberPlayers.observe(this@SetNumberPlayerFragment, Observer {
                viewDataBinding.numberPlayer.editText?.setText(it.toString())
            })
        }
    }
}
