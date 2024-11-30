package com.challenges.tripoptimizerapi.controller

import com.challenges.tripoptimizerapi.dto.StationCreationDto
import com.challenges.tripoptimizerapi.dto.resource.StationResource
import com.challenges.tripoptimizerapi.service.impl.StationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/stations")
class StationController(val stationService: StationService) {

    @PutMapping("/{station_id}")
    fun createStation(@PathVariable(name = "station_id") stationId: Long,
                      @RequestBody stationCrationData: StationCreationDto): ResponseEntity<StationResource> {
        return ResponseEntity.ok(stationService.saveStation(stationId, stationCrationData))
    }
}