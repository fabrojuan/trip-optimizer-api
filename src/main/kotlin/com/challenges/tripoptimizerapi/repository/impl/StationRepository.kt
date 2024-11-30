package com.challenges.tripoptimizerapi.repository.impl

import com.challenges.tripoptimizerapi.model.Station
import com.challenges.tripoptimizerapi.repository.IStationRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class StationRepository: IStationRepository {

    private val logger = LoggerFactory.getLogger(this::class.java)
    private var stationsCollection = mutableListOf<Station>()

    override fun save(station: Station): Station {
        logger.info("Station with id ${station.id} and name ${station.name} was saved")
        stationsCollection.add(station)
        logger.info("stations collection size: ${stationsCollection.size}")
        return station
    }
}