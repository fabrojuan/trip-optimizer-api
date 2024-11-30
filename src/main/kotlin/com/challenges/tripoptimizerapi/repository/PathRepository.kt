package com.challenges.tripoptimizerapi.repository

import com.challenges.tripoptimizerapi.model.Path
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PathRepository {

    private val logger = LoggerFactory.getLogger(this::class.java)
    private var pathsCollection = mutableListOf<Path>()

    fun save(path: Path): Path {
        logger.info("Path with id ${path.id}, source ${path.sourceId}, destination ${path.destinationId} and cost ${path.cost} was saved")
        pathsCollection.add(path)
        logger.info("paths collection size: ${pathsCollection.size}")
        return path
    }

}