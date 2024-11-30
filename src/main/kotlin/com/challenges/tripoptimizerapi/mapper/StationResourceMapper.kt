package com.challenges.tripoptimizerapi.mapper

import com.challenges.tripoptimizerapi.dto.resource.StationResource
import com.challenges.tripoptimizerapi.model.Station

object StationResourceMapper {

    fun build(station: Station): StationResource {
        return map(station)
    }

    private fun map(station: Station): StationResource {
        return StationResource().apply {
            id = station.id
            name = station.name
        }
    }

}