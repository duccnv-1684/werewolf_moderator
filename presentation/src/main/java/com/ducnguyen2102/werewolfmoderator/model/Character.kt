package com.ducnguyen2102.werewolfmoderator.model

data class Character(val type: CharacterType) {

    enum class CharacterType(val type: Int) {
        GOOF(1),
        CUPID(2),
        TWO_SISTERS(3),
        THREE_BROTHERS(4),
        BASTARD(5),
        PROTECTOR(6),
        WEREWOLF(7),
        WEREWOLF_CURSE(8),
        WEREWOLF_BOSS(9),
        WITCH(10),
        SEER(11),
        FOX(12),
        KNIGHT(13),
        HUNTER(14),
        FLUTIST(15)
    }
}
