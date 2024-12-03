package com.challenges.tripoptimizerapi.controller

import com.challenges.tripoptimizerapi.dto.PathCreationDto
import com.challenges.tripoptimizerapi.dto.resource.OptimalPathResource
import com.challenges.tripoptimizerapi.dto.resource.PathResource
import com.challenges.tripoptimizerapi.service.IPathService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/paths")
@Tag(name = "Path API", description = "Manage path resources in the app")
class PathController(val pathService: IPathService) {

    @PutMapping("/{path_id}")
    @Operation(summary = "Create Path", description = "Create a new path with its origin, destination and cost")
    fun createStation(@PathVariable(name="path_id") pathId: Long,
                      @RequestBody pathCreationData: PathCreationDto): ResponseEntity<PathResource> {
        return ResponseEntity.ok(pathService.savePath(pathId, pathCreationData))
    }

    @GetMapping("/{source_id}/{destination_id}")
    @Operation(summary = "Get optimal Path", description = "Retrieve an optimal path between an origin and a destination")
    fun getOptimalPath(@PathVariable(name = "source_id") sourceId: Long,
                       @PathVariable(name = "destination_id") destinationId: Long): ResponseEntity<OptimalPathResource> {
        return ResponseEntity.ok(pathService.getOptimalPath(sourceId, destinationId))
    }

}