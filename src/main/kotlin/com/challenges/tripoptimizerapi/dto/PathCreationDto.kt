package com.challenges.tripoptimizerapi.dto

import com.fasterxml.jackson.annotation.JsonProperty

class PathCreationDto {
    @JsonProperty("source_id")
    var sourceId: Long? = null
    @JsonProperty("destination_id")
    var destinationId: Long? = null
    var cost: Double? = null
}