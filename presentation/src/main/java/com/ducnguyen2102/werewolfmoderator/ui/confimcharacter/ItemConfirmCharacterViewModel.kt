package com.ducnguyen2102.werewolfmoderator.ui.confimcharacter

import androidx.databinding.ObservableField
import com.ducnguyen2102.werewolfmoderator.model.Character
import com.ducnguyen2102.werewolfmoderator.ui.pickcharacter.ItemCharacterViewModel

class ItemConfirmCharacterViewModel(val character: Character) {

    val type = ObservableField<Character.CharacterType>()
    val id = ObservableField<String>()
    val nameId = ObservableField<Int>()
    val imageId = ObservableField<Int>()
    val isCalledEveryNight = ObservableField<Boolean>()
    var isSelected = ObservableField<Boolean>()
    var count = ObservableField<Int>()

    init {
        type.set(character.type)
        id.set(character.id)
        nameId.set(character.nameId)
        imageId.set(character.imageId)
        isCalledEveryNight.set(character.isCalledEveryNight)
        isSelected.set(character.isSelected)
        when (type.get()) {
            Character.CharacterType.TWO_SISTERS -> count.set(2)
            Character.CharacterType.THREE_BROTHERS -> count.set(3)
            else -> count.set(1)
        }
    }


    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other !is ItemConfirmCharacterViewModel -> false
            else -> other.id.get()!! == this.id.get()!!
        }
    }

    override fun hashCode(): Int {
        var result = character.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + nameId.hashCode()
        result = 31 * result + imageId.hashCode()
        result = 31 * result + isCalledEveryNight.hashCode()
        result = 31 * result + isSelected.hashCode()
        return result
    }

    companion object {
        fun createListFromCharacters(characters: List<Character>): List<ItemConfirmCharacterViewModel> {
            val listItem = ArrayList<ItemConfirmCharacterViewModel>()
            characters.forEach {
                if (it.isSelected)
                    when {
                        listItem.isEmpty() -> listItem.add(ItemConfirmCharacterViewModel(it))
                        listItem.last().type.get() != it.type -> listItem.add(ItemConfirmCharacterViewModel(it))
                        else -> listItem.last().count.set(listItem.last().count.get()!! + 1)
                    }
            }
            return listItem
        }
        fun createListFromItemViewModel(listItem:List<ItemConfirmCharacterViewModel>): List<Character> {
            val list = ArrayList<Character>()
            listItem.forEach {
                val character = Character(it.type.get()!!)
                character.id = it.id.get()!!
                character.imageId = it.imageId.get()!!
                character.nameId = it.nameId.get()!!
                character.isCalledEveryNight = it.isCalledEveryNight.get()!!
                character.isSelected = it.isSelected.get()!!
                list.add(character)
            }
            return list
        }
    }
}