package com.ducnguyen2102.werewolfmoderator.ui.confimcharacter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseRecyclerAdapter
import com.ducnguyen2102.werewolfmoderator.databinding.ItemConfirmCharacterBinding


class ConfirmCharacterAdapter(
        private val dataBindingComponent: DataBindingComponent,
        private val callback: ((ItemConfirmCharacterViewModel) -> Unit?)
) : BaseRecyclerAdapter<ItemConfirmCharacterViewModel>(
        callBack = object : DiffUtil.ItemCallback<ItemConfirmCharacterViewModel>() {
            override fun areItemsTheSame(oldItem: ItemConfirmCharacterViewModel, newItem: ItemConfirmCharacterViewModel): Boolean {
                return oldItem.type.get() == newItem.type.get()
            }

            override fun areContentsTheSame(oldItem: ItemConfirmCharacterViewModel, newItem: ItemConfirmCharacterViewModel): Boolean {
                return oldItem.type.get() == newItem.type.get() && oldItem.isSelected.get() == newItem.isSelected.get()
            }
        }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemConfirmCharacterBinding>(
                LayoutInflater.from(parent.context), R.layout.item_confirm_character, parent,
                false, dataBindingComponent
        ).apply {
            root.setOnClickListener {
                this.character?.let { character ->
                    callback.invoke(character)
                }
            }
        }
    }

    override fun bind(binding: ViewDataBinding, item: ItemConfirmCharacterViewModel) {
        if (binding is ItemConfirmCharacterBinding) binding.character = item
    }

}
