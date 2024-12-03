package com.challenges.tripoptimizerapi.controller

import com.challenges.tripoptimizerapi.dto.StationCreationDto
import jdk.jfr.ContentType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StationControllerTest {

    @Autowired
    private lateinit var webClient: WebTestClient

    @Test
    fun test() {
        webClient.put().uri("/api/stations/1")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(StationCreationDto().apply {
                    name = "station 1"
                })
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                //.jsonPath("$.name").value(value -> """station 1")
    }
}