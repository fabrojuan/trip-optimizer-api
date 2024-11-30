package com.challenges.tripoptimizerapi.service

import com.challenges.tripoptimizerapi.dto.StationCreationDto
import com.challenges.tripoptimizerapi.dto.resource.StationResource

interface IStationService {
    fun saveStation(stationId: Long, stationDto: StationCreationDto): StationResource
}