package com.ducnguyen2102.werewolfmoderator.model

import com.ducnguyen2102.werewolfmoderator.R
import java.util.*
import kotlin.collections.ArrayList

data class Character(val type: CharacterType) {
    val id: String = UUID.randomUUID().toString()
    val nameId: Int
    val imageId: Int
    val isCalledEveryNight: Boolean
    var isSelected = false

    init {
        when (type) {
            CharacterType.IDIOT -> {
                nameId = R.string.character_idiot
                imageId = R.drawable.character01
                isCalledEveryNight = false
            }
            CharacterType.CUPID -> {
                nameId = R.string.character_cupid
                imageId = R.drawable.character02
                isCalledEveryNight = false
            }
            CharacterType.TWO_SISTERS -> {
                nameId = R.string.character_two_sisters
                imageId = R.drawable.character03
                isCalledEveryNight = false
            }
            CharacterType.THREE_BROTHERS -> {
                nameId = R.string.character_three_brothers
                imageId = R.drawable.character04
                isCalledEveryNight = false
            }
            CharacterType.WILD_CHILD -> {
                nameId = R.string.character_wild_child
                imageId = R.drawable.character05
                isCalledEveryNight = false
            }
            CharacterType.ANCIENT -> {
                nameId = R.string.character_ancient
                imageId = R.drawable.character06
                isCalledEveryNight = false
            }
            CharacterType.SAVIOR -> {
                nameId = R.string.character_savior
                imageId = R.drawable.character07
                isCalledEveryNight = true
            }
            CharacterType.WOLF -> {
                nameId = R.string.character_wolf
                imageId = R.drawable.character08
                isCalledEveryNight = true
            }
            CharacterType.VILE_FATHER_OF_WOLF -> {
                nameId = R.string.character_vile_father_of_wolf
                imageId = R.drawable.character09
                isCalledEveryNight = true
            }
            CharacterType.BIG_BAD_WOLF -> {
                nameId = R.string.character_big_dad_wolf
                imageId = R.drawable.character10
                isCalledEveryNight = true
            }
            CharacterType.WITCH -> {
                nameId = R.string.character_witch
                imageId = R.drawable.character11
                isCalledEveryNight = true
            }
            CharacterType.SEER -> {
                nameId = R.string.character_seer
                imageId = R.drawable.character12
                isCalledEveryNight = true
            }
            CharacterType.FOX -> {
                nameId = R.string.character_fox
                imageId = R.drawable.character13
                isCalledEveryNight = true
            }
            CharacterType.KNIGHT -> {
                nameId = R.string.character_knight
                imageId = R.drawable.character14
                isCalledEveryNight = false
            }
            CharacterType.HUNTER -> {
                nameId = R.string.character_hunter
                imageId = R.drawable.character15
                isCalledEveryNight = false
            }
            CharacterType.FLUTIST -> {
                nameId = R.string.character_flutist
                imageId = R.drawable.character16
                isCalledEveryNight = true
            }
            CharacterType.VILLAGER -> {
                nameId = R.string.character_villager
                imageId = R.drawable.character17
                isCalledEveryNight = false
            }
        }
    }

    companion object {
        fun createCharacter(): ArrayList<Character> {
            val listCharacters = ArrayList<Character>()
            listCharacters.add(Character(CharacterType.IDIOT))
            listCharacters.add(Character(CharacterType.CUPID))
            listCharacters.add(Character(CharacterType.TWO_SISTERS))
            listCharacters.add(Character(CharacterType.THREE_BROTHERS))
            listCharacters.add(Character(CharacterType.WILD_CHILD))
            listCharacters.add(Character(CharacterType.ANCIENT))
            listCharacters.add(Character(CharacterType.SAVIOR))
            listCharacters.add(Character(CharacterType.WOLF))
            listCharacters.add(Character(CharacterType.VILE_FATHER_OF_WOLF))
            listCharacters.add(Character(CharacterType.BIG_BAD_WOLF))
            listCharacters.add(Character(CharacterType.WITCH))
            listCharacters.add(Character(CharacterType.SEER))
            listCharacters.add(Character(CharacterType.FOX))
            listCharacters.add(Character(CharacterType.KNIGHT))
            listCharacters.add(Character(CharacterType.HUNTER))
            listCharacters.add(Character(CharacterType.FLUTIST))
            listCharacters.add(Character(CharacterType.VILLAGER))
            return listCharacters
        }
    }

    enum class CharacterType(val type: Int) {
        IDIOT(1),
        CUPID(2),
        TWO_SISTERS(3),
        THREE_BROTHERS(4),
        WILD_CHILD(5),
        ANCIENT(6),
        SAVIOR(7),
        WOLF(8),
        VILE_FATHER_OF_WOLF(9),
        BIG_BAD_WOLF(10),
        WITCH(11),
        SEER(12),
        FOX(13),
        KNIGHT(14),
        HUNTER(15),
        FLUTIST(16),
        VILLAGER(17)
    }

    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other !is Character -> false
            else -> other.id == this.id
        }
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + nameId
        result = 31 * result + imageId
        result = 31 * result + isCalledEveryNight.hashCode()
        result = 31 * result + isSelected.hashCode()
        return result
    }
}
