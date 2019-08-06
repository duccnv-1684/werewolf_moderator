package com.ducnguyen2102.werewolfmoderator.ui.pickcharacter

import android.os.Bundle
import com.ducnguyen2102.werewolfmoderator.BR
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseFragment
import com.ducnguyen2102.werewolfmoderator.binding.FragmentDataBindingComponent
import com.ducnguyen2102.werewolfmoderator.databinding.FragmentPickCharacterBinding
import com.ducnguyen2102.werewolfmoderator.model.Character
import com.ducnguyen2102.werewolfmoderator.ui.MainSharedViewModel
import com.ducnguyen2102.werewolfmoderator.util.autoCleared
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PickCharacterFragment : BaseFragment<FragmentPickCharacterBinding, PickCharacterViewModel>() {

    override val bindingVariable = BR.viewModel

    override val layoutId = R.layout.fragment_pick_character

    override val viewModel: PickCharacterViewModel by viewModel()

    private val sharedViewModel: MainSharedViewModel by sharedViewModel()

    private var bindingComponent = FragmentDataBindingComponent(this)

    private var pickCharacterAdapter by autoCleared<PickCharacterAdapter>()

    private var count = 0
    private var numberPlayer = 0
    private var characters = Character.createCharacter()
    private var listItem = ItemCharacterViewModel.createListFromCharacters(characters)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.run {
            pickCharacterAdapter = PickCharacterAdapter(bindingComponent) {
                makeSelect(it)
            }
            listCharacters.adapter = pickCharacterAdapter
        }
        numberPlayer = sharedViewModel.numberPlayers.value!!
        if (count != numberPlayer) {
            viewDataBinding.next.apply {
                text = String.format("%d/%d", count, numberPlayer)
                background = context?.getDrawable(R.drawable.background_next_disable)
                isEnabled = false
            }
        } else {
            viewDataBinding.next.apply {
                setText(R.string.title_continue)
                background = context?.getDrawable(R.drawable.background_next_enable)
                isEnabled = true
            }
        }
        viewDataBinding.apply {
            back.setOnClickListener {

            }
            next.setOnClickListener {

            }
        }
        pickCharacterAdapter.submitList(listItem)
        subscribeUI()
    }

    private fun makeSelect(itemCharacterViewModel: ItemCharacterViewModel) {
        itemCharacterViewModel.apply {
            if (count != numberPlayer || isSelected.get()!!) {
                isSelected.set(!isSelected.get()!!)
                if (isSelected.get()!!) {
                    count += when {
                        itemCharacterViewModel.type.get()!! == Character.CharacterType.TWO_SISTERS -> 2
                        itemCharacterViewModel.type.get()!! == Character.CharacterType.THREE_BROTHERS -> 3
                        else -> 1
                    }
                } else {
                    count -= when {
                        itemCharacterViewModel.type.get()!! == Character.CharacterType.TWO_SISTERS -> 2
                        itemCharacterViewModel.type.get()!! == Character.CharacterType.THREE_BROTHERS -> 3
                        else -> 1
                    }
                }
                if (count != numberPlayer) {
                    viewDataBinding.next.apply {
                        text = String.format("%d/%d", count, numberPlayer)
                        background = context?.getDrawable(R.drawable.background_next_disable)
                        isEnabled = false
                    }
                } else {
                    viewDataBinding.next.apply {
                        setText(R.string.title_continue)
                        background = context?.getDrawable(R.drawable.background_next_enable)
                        isEnabled = true
                    }
                }

                if (isSelected.get()!! && itemCharacterViewModel.type.get()!! == Character.CharacterType.WOLF) {
                    listItem.add(listItem.indexOf(itemCharacterViewModel) + 1, ItemCharacterViewModel(Character(Character.CharacterType.WOLF)))
                    pickCharacterAdapter.notifyItemInserted(listItem.indexOf(itemCharacterViewModel) + 1)
                } else if (!isSelected.get()!! && itemCharacterViewModel.type.get()!! == Character.CharacterType.WOLF) {
                    val index = listItem.indexOf(itemCharacterViewModel)
                    if (listItem[index - 1].type.get()!! == Character.CharacterType.WOLF || listItem[index + 1].type.get()!! == Character.CharacterType.WOLF) {
                        listItem.removeAt(index)
                        pickCharacterAdapter.notifyItemRemoved(index)
                    }
                }
                if (isSelected.get()!! && itemCharacterViewModel.type.get()!! == Character.CharacterType.VILLAGER) {
                    listItem.add(listItem.indexOf(itemCharacterViewModel) + 1, ItemCharacterViewModel(Character(Character.CharacterType.VILLAGER)))
                    pickCharacterAdapter.notifyItemInserted(listItem.indexOf(itemCharacterViewModel) + 1)
                } else if (!isSelected.get()!! && itemCharacterViewModel.type.get()!! == Character.CharacterType.VILLAGER) {
                    val index = listItem.indexOf(itemCharacterViewModel)
                    if (listItem[index - 1].type.get()!! == Character.CharacterType.VILLAGER || listItem[index + 1].type.get()!! == Character.CharacterType.VILLAGER) {
                        listItem.removeAt(index)
                        pickCharacterAdapter.notifyItemRemoved(index)
                    }
                }
            }
        }
    }


    private fun subscribeUI() {

    }
}
