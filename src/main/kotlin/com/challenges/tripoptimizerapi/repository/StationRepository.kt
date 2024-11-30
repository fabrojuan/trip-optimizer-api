package com.challenges.tripoptimizerapi.repository

import com.challenges.tripoptimizerapi.model.Station
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class StationRepository {

    private val logger = LoggerFactory.getLogger(this::class.java)
    private var stationsCollection = mutableListOf<Station>()

    fun save(station: Station): Station {
        logger.info("Station with id ${station.id} and name ${station.name} was saved")
        stationsCollection.add(station)
        logger.info("stations collection size: ${stationsCollection.size}")
        return station
    }
}