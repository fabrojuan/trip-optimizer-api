package com.challenges.tripoptimizerapi.controller

import com.challenges.tripoptimizerapi.dto.StationCreationDto
import com.challenges.tripoptimizerapi.dto.resource.StationResource
import com.challenges.tripoptimizerapi.service.IStationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/stations")
@Tag(name = "Station API", description = "Manage station resources in the app")
class StationController(val stationService: IStationService) {

    @PutMapping("/{station_id}")
    @Operation(summary = "Create Station", description = "Create a new station with its name")
    fun createStation(@PathVariable(name = "station_id") stationId: Long,
                      @RequestBody stationCrationData: StationCreationDto): ResponseEntity<StationResource> {
        return ResponseEntity.ok(stationService.saveStation(stationId, stationCrationData))
    }
}