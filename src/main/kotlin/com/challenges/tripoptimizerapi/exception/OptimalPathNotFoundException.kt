package com.challenges.tripoptimizerapi.exception

class OptimalPathNotFoundException(originId: Long, destinationId: Long)
    : Exception("No route found between source $originId and destination $destinationId") {
}