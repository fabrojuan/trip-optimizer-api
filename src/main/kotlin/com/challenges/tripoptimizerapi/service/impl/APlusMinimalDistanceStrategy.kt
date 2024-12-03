package com.challenges.tripoptimizerapi.service.impl

import com.challenges.tripoptimizerapi.model.Path
import com.challenges.tripoptimizerapi.service.IMinimalDistanceStrategy
import org.springframework.stereotype.Service

@Service
class APlusMinimalDistanceStrategy: IMinimalDistanceStrategy {
    override fun findMinimalDistance(sourceId: Long, destinationId: Long, pathList: List<Path>): Pair<List<Long>, Double>? {
        // Build the graph
        val adjacencyMap = mutableMapOf<Long, MutableList<Path>>()

        pathList.forEach { path ->
            // Add the forward connection
            adjacencyMap.computeIfAbsent(path.sourceId!!) { mutableListOf() }.add(path)
            // Add the reverse connection
            adjacencyMap.computeIfAbsent(path.destinationId!!) { mutableListOf() }.add(
                    Path().apply {
                        this.sourceId = path.destinationId
                        this.destinationId = path.sourceId
                        cost = path.cost
                    }
            )
        }

        // A* algorithm (same as before)
        val gScores = mutableMapOf<Long, Double>().withDefault { Double.MAX_VALUE } // Cost from start to node
        val fScores = mutableMapOf<Long, Double>().withDefault { Double.MAX_VALUE } // Estimated total cost
        val previousNodes = mutableMapOf<Long, Long?>()
        val openSet = java.util.PriorityQueue<Pair<Long, Double>>(compareBy { it.second })

        gScores[sourceId] = 0.0
        fScores[sourceId] = 0.0
        openSet.add(Pair(sourceId, fScores[sourceId]!!))

        while (openSet.isNotEmpty()) {
            val (currentNode, _) = openSet.poll()

            if (currentNode == destinationId) {
                // Reconstruct the path
                val path = mutableListOf<Long>()
                var backtrackNode: Long? = destinationId
                while (backtrackNode != null) {
                    path.add(0, backtrackNode)
                    backtrackNode = previousNodes[backtrackNode]
                }
                return Pair(path, gScores[destinationId]!!)
            }

            adjacencyMap[currentNode]?.forEach { neighbor ->
                val tentativeGScore = gScores.getValue(currentNode) + neighbor.cost!!
                if (tentativeGScore < gScores.getValue(neighbor.destinationId!!)) {
                    // Update scores
                    previousNodes[neighbor.destinationId!!] = currentNode
                    gScores[neighbor.destinationId!!] = tentativeGScore
                    fScores[neighbor.destinationId!!] = tentativeGScore + 0.0

                    // Add to priority queue
                    openSet.add(Pair(neighbor.destinationId!!, fScores[neighbor.destinationId]!!))
                }
            }
        }

        return null // No path found
    }
}