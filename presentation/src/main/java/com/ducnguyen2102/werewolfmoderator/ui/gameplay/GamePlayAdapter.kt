package com.ducnguyen2102.werewolfmoderator.ui.gameplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseRecyclerAdapter
import com.ducnguyen2102.werewolfmoderator.databinding.ItemSentenceBinding

class GamePlayAdapter(
        private val dataBindingComponent: DataBindingComponent,
        private val callback: ((ItemSentenceViewModel) -> Unit?)
) : BaseRecyclerAdapter<ItemSentenceViewModel>(
        callBack = object : DiffUtil.ItemCallback<ItemSentenceViewModel>() {
            override fun areItemsTheSame(oldItem: ItemSentenceViewModel, newItem: ItemSentenceViewModel): Boolean {
                return oldItem.id.get() == newItem.id.get()
            }

            override fun areContentsTheSame(oldItem: ItemSentenceViewModel, newItem: ItemSentenceViewModel): Boolean {
                return oldItem.id.get() == newItem.id.get() && oldItem.content.get() == newItem.content.get()
            }
        }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemSentenceBinding>(
                LayoutInflater.from(parent.context), R.layout.item_sentence, parent,
                false, dataBindingComponent
        ).apply {
            root.setOnClickListener {
                this.sentence?.let { sentence ->
                    callback.invoke(sentence)
                }
            }
        }
    }

    override fun bind(binding: ViewDataBinding, item: ItemSentenceViewModel) {
        if (binding is ItemSentenceBinding) binding.sentence = item
    }

}

