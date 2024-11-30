package com.challenges.tripoptimizerapi.repository

import com.challenges.tripoptimizerapi.model.Station

interface IStationRepository {
    fun save(station: Station): Station
}