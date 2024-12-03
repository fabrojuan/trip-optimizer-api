package com.challenges.tripoptimizerapi.exception.handler

import com.challenges.tripoptimizerapi.dto.resource.ErrorResource
import com.challenges.tripoptimizerapi.exception.OptimalPathNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception

@ControllerAdvice
class BaseExceptionHandler {

    @ExceptionHandler(OptimalPathNotFoundException::class)
    fun handlePathNotFoundException(ex: OptimalPathNotFoundException): ResponseEntity<ErrorResource> {
        return ResponseEntity(ErrorResource().apply { errorMessage = ex.message }, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    fun handlePathNotFoundException(ex: Exception): ResponseEntity<ErrorResource> {
        return ResponseEntity(ErrorResource().apply { errorMessage = "An error occurred, please contact the team in charge of the application" }, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}