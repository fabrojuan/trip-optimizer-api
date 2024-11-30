package com.challenges.tripoptimizerapi.dto.resource

import com.fasterxml.jackson.annotation.JsonProperty

class PathResource {
    @JsonProperty("path_id")
    var id: Long? = null
    @JsonProperty("source_id")
    var sourceId: Long? = null
    @JsonProperty("destination_id")
    var destinationId: Long? = null
    var cost: Double? = null
}