package com.challenges.tripoptimizerapi.fixture

import com.challenges.tripoptimizerapi.dto.StationCreationDto
import com.challenges.tripoptimizerapi.dto.resource.StationResource
import com.challenges.tripoptimizerapi.model.Station

class StationFixtureTestObject {

    val STATION_ID = 1L
    val STATION_NAME = "Station 1"

    fun getStationCreationDto() =
            StationCreationDto().apply {
                name = STATION_NAME
            }

    fun getStation() = Station().apply {
        id = STATION_ID
        name = STATION_NAME
    }

    fun getStationResource() = StationResource().apply {
        id = STATION_ID
        name = STATION_NAME
    }
}