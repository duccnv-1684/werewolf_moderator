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

class PickCharacterAdapter(
        private val dataBindingComponent: DataBindingComponent,
        private val callback: ((ItemCharacterViewModel) -> Unit?)
) : BaseRecyclerAdapter<ItemCharacterViewModel>(
        callBack = object : DiffUtil.ItemCallback<ItemCharacterViewModel>() {
            override fun areItemsTheSame(oldItem: ItemCharacterViewModel, newItem: ItemCharacterViewModel): Boolean {
                return oldItem.type.get() == newItem.type.get()
            }

            override fun areContentsTheSame(oldItem: ItemCharacterViewModel, newItem: ItemCharacterViewModel): Boolean {
                return oldItem.type.get() == newItem.type.get() && oldItem.isSelected.get() == newItem.isSelected.get()
            }
        }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemCharacterBinding>(
                LayoutInflater.from(parent.context), R.layout.item_character, parent,
                false, dataBindingComponent
        ).apply {
            root.setOnClickListener {
                this.character?.let { character ->
                    callback.invoke(character)
                }
            }
        }
    }

    override fun bind(binding: ViewDataBinding, item: ItemCharacterViewModel) {
        if (binding is ItemCharacterBinding) binding.character = item
    }

}
