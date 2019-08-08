package com.ducnguyen2102.werewolfmoderator.ui.confimcharacter

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.ducnguyen2102.werewolfmoderator.BR
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseFragment
import com.ducnguyen2102.werewolfmoderator.binding.FragmentDataBindingComponent
import com.ducnguyen2102.werewolfmoderator.databinding.FragmentConfirmCharacterBinding
import com.ducnguyen2102.werewolfmoderator.ui.MainSharedViewModel
import com.ducnguyen2102.werewolfmoderator.util.autoCleared
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConfirmCharacterFragment : BaseFragment<FragmentConfirmCharacterBinding, ConfirmCharacterViewModel>() {
    override val bindingVariable = BR.viewModel

    override val layoutId = R.layout.fragment_confirm_character

    override val viewModel: ConfirmCharacterViewModel by viewModel()

    private val sharedViewModel: MainSharedViewModel by sharedViewModel()

    private var bindingComponent = FragmentDataBindingComponent(this)

    private var confirmCharacterAdapter by autoCleared<ConfirmCharacterAdapter>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.run {
            confirmCharacterAdapter = ConfirmCharacterAdapter(bindingComponent) {

            }
            val listItem = ItemConfirmCharacterViewModel.createListFromCharacters(sharedViewModel.listPickingCharacter.value!!)
            listCharacters.adapter = confirmCharacterAdapter
            confirmCharacterAdapter.submitList(listItem)
            next.setOnClickListener {
                sharedViewModel.listCharacter.value = ItemConfirmCharacterViewModel.createListFromItemViewModel(listItem)
                findNavController().navigate(R.id.action_confirmCharacterFragment_to_gamePlayFragment)
            }
            back.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}
