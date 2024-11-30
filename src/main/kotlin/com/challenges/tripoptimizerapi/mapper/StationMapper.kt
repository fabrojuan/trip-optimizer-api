package com.challenges.tripoptimizerapi.mapper

import com.challenges.tripoptimizerapi.dto.StationCreationDto
import com.challenges.tripoptimizerapi.model.Station

object StationMapper {

    fun build(stationId: Long, stationCreationDto: StationCreationDto): Station {
        return map(stationId, stationCreationDto)
    }

    private fun map(stationId: Long, stationCreationDto: StationCreationDto): Station {
        return Station().apply {
            id = stationId
            name = stationCreationDto.name
        }
    }
}