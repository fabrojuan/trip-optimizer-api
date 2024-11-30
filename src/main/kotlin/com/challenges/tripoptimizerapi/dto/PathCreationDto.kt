package com.challenges.tripoptimizerapi.dto

import com.fasterxml.jackson.annotation.JsonProperty

class PathCreationDto {
    @JsonProperty("source_id")
    val sourceId: Long? = null
    @JsonProperty("destination_id")
    val destinationId: Long? = null
    var cost: Double? = null
}