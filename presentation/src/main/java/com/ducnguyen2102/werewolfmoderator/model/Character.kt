package com.ducnguyen2102.werewolfmoderator.model

data class Character(val type: CharacterType) {

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
}
