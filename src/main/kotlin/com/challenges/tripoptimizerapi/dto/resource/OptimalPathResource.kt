package com.challenges.tripoptimizerapi.dto.resource

class OptimalPathResource: ErrorResource() {
    var path: List<Long>? = null
    var cost: Double? = null
}