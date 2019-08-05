package com.ducnguyen2102.werewolfmoderator.ui.pickcharacter

import android.os.Bundle
import com.ducnguyen2102.werewolfmoderator.BR
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseFragment
import com.ducnguyen2102.werewolfmoderator.binding.FragmentDataBindingComponent
import com.ducnguyen2102.werewolfmoderator.databinding.FragmentPickCharacterBinding
import com.ducnguyen2102.werewolfmoderator.ui.MainSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PickCharacterFragment : BaseFragment<FragmentPickCharacterBinding, PickCharacterViewModel>() {

    override val bindingVariable = BR.viewModel

    override val layoutId = R.layout.fragment_pick_character

    override val viewModel: PickCharacterViewModel by viewModel()

    private val sharedViewModel : MainSharedViewModel by sharedViewModel()

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
