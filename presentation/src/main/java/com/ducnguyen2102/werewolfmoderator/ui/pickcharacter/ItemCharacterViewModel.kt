package com.ducnguyen2102.werewolfmoderator.ui.pickcharacter

import androidx.databinding.ObservableField
import com.ducnguyen2102.werewolfmoderator.model.Character

class ItemCharacterViewModel(val character: Character) {

    val type = ObservableField<Character.CharacterType>()
    val id = ObservableField<String>()
    val nameId = ObservableField<Int>()
    val imageId = ObservableField<Int>()
    val isCalledEveryNight = ObservableField<Boolean>()
    var isSelected = ObservableField<Boolean>()

    init {
        type.set(character.type)
        id.set(character.id)
        nameId.set(character.nameId)
        imageId.set(character.imageId)
        isCalledEveryNight.set(character.isCalledEveryNight)
        isSelected.set(character.isSelected)
    }


    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other !is ItemCharacterViewModel -> false
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
        fun createListFromCharacters(characters: List<Character>): List<ItemCharacterViewModel> {
            val listItem = ArrayList<ItemCharacterViewModel>()
            characters.forEach {
                listItem.add(ItemCharacterViewModel(it))
            }
            return listItem
        }

        fun createListFromItemViewModel(listItem:List<ItemCharacterViewModel>): List<Character> {
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