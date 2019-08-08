package com.ducnguyen2102.werewolfmoderator.ui.gameplay

import androidx.databinding.ObservableField

class ItemSentenceViewModel {
    val id = ObservableField<Int>()
    val content = ObservableField<String>()

    companion object {
        fun createListItem(listSentence: List<String>): List<ItemSentenceViewModel> {
            val listItem = ArrayList<ItemSentenceViewModel>()
            for (i in 0..listSentence.lastIndex) {
                val itemSentence = ItemSentenceViewModel()
                itemSentence.id.set(i)
                itemSentence.content.set(listSentence[i])
                listItem.add(itemSentence)
            }
            return listItem
        }
    }
}