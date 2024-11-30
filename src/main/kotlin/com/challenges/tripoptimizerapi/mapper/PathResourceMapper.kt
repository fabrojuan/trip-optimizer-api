package com.challenges.tripoptimizerapi.mapper

import com.challenges.tripoptimizerapi.dto.resource.PathResource
import com.challenges.tripoptimizerapi.model.Path

object PathResourceMapper {

    fun build(path: Path): PathResource {
        return map(path)
    }

    private fun map(path: Path): PathResource {
        return PathResource().apply {
            id = path.id
            sourceId = path.sourceId
            destinationId = path.destinationId
            cost = path.cost
        }
    }

}