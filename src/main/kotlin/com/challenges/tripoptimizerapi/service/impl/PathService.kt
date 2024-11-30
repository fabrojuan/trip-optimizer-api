package com.challenges.tripoptimizerapi.service.impl

import com.challenges.tripoptimizerapi.dto.PathCreationDto
import com.challenges.tripoptimizerapi.dto.resource.PathResource
import com.challenges.tripoptimizerapi.mapper.PathMapper
import com.challenges.tripoptimizerapi.mapper.PathResourceMapper
import com.challenges.tripoptimizerapi.repository.PathRepository
import com.challenges.tripoptimizerapi.service.IPathService
import org.springframework.stereotype.Service

@Service
class PathService(val pathRepository: PathRepository): IPathService {
    override fun savePath(pathId: Long, pathCreationDto: PathCreationDto): PathResource {
        val path = PathMapper.build(pathId, pathCreationDto)
        return PathResourceMapper.build(pathRepository.save(path))
    }
}