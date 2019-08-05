package com.ducnguyen2102.werewolfmoderator.data.base

import com.ducnguyen2102.werewolfmoderator.domain.model.Model


interface EntityMapper<M : Model, ME : ModelEntity> {
    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}