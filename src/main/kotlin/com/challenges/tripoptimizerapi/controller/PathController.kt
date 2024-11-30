package com.challenges.tripoptimizerapi.controller

import com.challenges.tripoptimizerapi.dto.PathCreationDto
import com.challenges.tripoptimizerapi.dto.resource.PathResource
import com.challenges.tripoptimizerapi.service.impl.PathService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/paths")
class PathController(val pathService: PathService) {

    @PutMapping("/{path_id}")
    fun createStation(@PathVariable(name="path_id") pathId: Long,
                      @RequestBody pathCreationData: PathCreationDto): ResponseEntity<PathResource> {
        return ResponseEntity.ok(pathService.savePath(pathId, pathCreationData))
    }

}