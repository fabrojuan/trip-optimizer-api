package com.challenges.tripoptimizerapi.service.impl

import com.challenges.tripoptimizerapi.dto.PathCreationDto
import com.challenges.tripoptimizerapi.dto.resource.OptimalPathResource
import com.challenges.tripoptimizerapi.dto.resource.PathResource
import com.challenges.tripoptimizerapi.exception.OptimalPathNotFoundException
import com.challenges.tripoptimizerapi.mapper.PathMapper
import com.challenges.tripoptimizerapi.mapper.PathResourceMapper
import com.challenges.tripoptimizerapi.model.Path
import com.challenges.tripoptimizerapi.repository.IPathRepository
import com.challenges.tripoptimizerapi.service.IMinimalDistanceStrategy
import com.challenges.tripoptimizerapi.service.IPathService
import org.springframework.stereotype.Service
import kotlin.math.cos

@Service
class PathService(val pathRepository: IPathRepository, val minimalDistanceStrategy: IMinimalDistanceStrategy) : IPathService {
    override fun savePath(pathId: Long, pathCreationDto: PathCreationDto): PathResource {
        val path = PathMapper.build(pathId, pathCreationDto)
        return PathResourceMapper.build(pathRepository.save(path))
    }

    override fun getOptimalPath(sourceId: Long, destinationId: Long): OptimalPathResource {
        val (optimalPath, optimalCost) = minimalDistanceStrategy.findMinimalDistance(sourceId, destinationId, pathRepository.findAll())
                ?: throw OptimalPathNotFoundException(sourceId, destinationId)
        return OptimalPathResource().apply {
            path = optimalPath
            this.cost = optimalCost
        }
    }

}