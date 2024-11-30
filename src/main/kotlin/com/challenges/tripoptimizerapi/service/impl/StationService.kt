package com.challenges.tripoptimizerapi.service.impl

import com.challenges.tripoptimizerapi.dto.StationCreationDto
import com.challenges.tripoptimizerapi.dto.resource.StationResource
import com.challenges.tripoptimizerapi.mapper.StationMapper
import com.challenges.tripoptimizerapi.mapper.StationResourceMapper
import com.challenges.tripoptimizerapi.repository.StationRepository
import com.challenges.tripoptimizerapi.service.IStationService
import org.springframework.stereotype.Service

@Service
class StationService(val stationRepository: StationRepository): IStationService {
    override fun saveStation(stationId: Long, stationDto: StationCreationDto): StationResource {
        val station = StationMapper.build(stationId, stationDto)
        return StationResourceMapper.build(stationRepository.save(station))
    }
}