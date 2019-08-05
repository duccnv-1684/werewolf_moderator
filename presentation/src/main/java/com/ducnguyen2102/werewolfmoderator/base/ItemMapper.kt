package com.ducnguyen2102.werewolfmoderator.base

import com.ducnguyen2102.werewolfmoderator.domain.model.Model

interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToPresentation(model: M): ModelItem

    fun mapToDomain(modelItem: MI): Model
}