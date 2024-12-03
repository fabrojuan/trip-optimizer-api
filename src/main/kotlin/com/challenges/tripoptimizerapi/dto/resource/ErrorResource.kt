package com.challenges.tripoptimizerapi.dto.resource

import com.fasterxml.jackson.annotation.JsonProperty

open class ErrorResource {
    @JsonProperty("error_message")
    var errorMessage: String? = null
}