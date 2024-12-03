package com.challenges.tripoptimizerapi.service

import com.challenges.tripoptimizerapi.model.Path

interface IMinimalDistanceStrategy {
    fun findMinimalDistance(
            sourceId: Long,
            destinationId: Long,
            pathList: List<Path>
    ): Pair<List<Long>, Double>?

}