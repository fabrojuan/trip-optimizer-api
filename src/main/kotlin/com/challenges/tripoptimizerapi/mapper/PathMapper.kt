package com.challenges.tripoptimizerapi.mapper

import com.challenges.tripoptimizerapi.dto.PathCreationDto
import com.challenges.tripoptimizerapi.model.Path

object PathMapper {

    fun build(pathId: Long, pathCreationDto: PathCreationDto): Path {
        return map(pathId, pathCreationDto)
    }

    private fun map(pathId: Long, pathCreationDto: PathCreationDto): Path {
        return Path().apply {
            id = pathId
            sourceId = pathCreationDto.sourceId
            destinationId = pathCreationDto.destinationId
            cost = pathCreationDto.cost
        }
    }
}