package com.challenges.tripoptimizerapi.service

import com.challenges.tripoptimizerapi.dto.PathCreationDto
import com.challenges.tripoptimizerapi.dto.resource.PathResource

interface IPathService {
    fun savePath(pathId: Long, pathCreationDto: PathCreationDto): PathResource
}