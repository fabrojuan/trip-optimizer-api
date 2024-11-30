package com.challenges.tripoptimizerapi.controller

import com.challenges.tripoptimizerapi.dto.PathCreationDto
import com.challenges.tripoptimizerapi.dto.resource.PathResource
import com.challenges.tripoptimizerapi.service.IPathService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/paths")
class PathController(val pathService: IPathService) {

    @PutMapping("/{path_id}")
    fun createStation(@PathVariable(name="path_id") pathId: Long,
                      @RequestBody pathCreationData: PathCreationDto): ResponseEntity<PathResource> {
        return ResponseEntity.ok(pathService.savePath(pathId, pathCreationData))
    }

    @GetMapping("/{source_id}/{destination_id}")
    fun getOptimalPath(@PathVariable(name = "source_id") sourceId: Long,
                       @PathVariable(name = "destination_id") destinationId: Long) {

    }

}