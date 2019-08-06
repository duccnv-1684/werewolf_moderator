package com.ducnguyen2102.werewolfmoderator.ui.pickcharacter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseRecyclerAdapter
import com.ducnguyen2102.werewolfmoderator.databinding.ItemCharacterBinding
import com.ducnguyen2102.werewolfmoderator.model.Character

class PickCharacterAdapter(
        private val dataBindingComponent: DataBindingComponent,
        private val callback: ((Character) -> Unit?)
) : BaseRecyclerAdapter<Character>(
        callBack = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.type == newItem.type
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.type == newItem.type
            }
        }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemCharacterBinding>(
                LayoutInflater.from(parent.context), R.layout.item_character, parent,
                false, dataBindingComponent
        ).apply {
            root.setOnClickListener {
                this.character?.let { item ->
                    callback.invoke(item)
                }
            }
        }
    }

    override fun bind(binding: ViewDataBinding, item: Character) {
        if (binding is ItemCharacterBinding) binding.character = item
    }

}
