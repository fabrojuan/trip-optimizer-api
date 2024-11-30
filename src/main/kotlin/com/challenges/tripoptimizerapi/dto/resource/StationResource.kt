package com.challenges.tripoptimizerapi.dto.resource

import com.fasterxml.jackson.annotation.JsonProperty

class StationResource {
    @JsonProperty("station_id")
    var id: Long? = null
    var name: String? = null
}