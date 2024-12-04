package com.challenges.tripoptimizerapi.controller

import com.challenges.tripoptimizerapi.dto.PathCreationDto
import com.challenges.tripoptimizerapi.dto.StationCreationDto
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TripOptimizerE2ETest {

    @Autowired
    private lateinit var webClient: WebTestClient

    @Order(1)
    @ParameterizedTest
    @CsvSource(
            "1, Station A",
            "2, Station B",
            "3, Station C",
            "4, Station D",
            "5, Station E",
            "6, Station F"
    )
    fun `test create station`(stationId: Long, stationName: String) {
        webClient.put().uri("/api/stations/$stationId")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(StationCreationDto().apply {
                    name = stationName
                })
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.station_id").isEqualTo(stationId)
                .jsonPath("$.name").isEqualTo(stationName)
    }

    @Order(2)
    @ParameterizedTest
    @CsvSource(
            "1001, 1, 2, 10",
            "1002, 2, 1, 3, 20",
            "1003, 1, 4, 5",
            "1004, 1, 5, 40",
            "1005, 5, 6, 40",
            "1006, 2, 6, 190"
    )
    fun `test create path`(pathId: Long, sourceId: Long, destinationId: Long, cost: Double) {
        webClient.put().uri("/api/paths/$pathId")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(PathCreationDto().apply {
                    this.sourceId = sourceId
                    this.destinationId = destinationId
                    this.cost = cost
                })
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.path_id").isEqualTo(pathId)
                .jsonPath("$.source_id").isEqualTo(sourceId)
                .jsonPath("$.destination_id").isEqualTo(destinationId)
                .jsonPath("$.cost").isEqualTo(cost)
    }

    @Order(3)
    @Test
    fun `test get optimal path - Ok`() {
        webClient.get().uri("/api/paths/1/6")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.cost").isEqualTo(80)
                .jsonPath("$.path[0]").isEqualTo(1)
                .jsonPath("$.path[1]").isEqualTo(5)
                .jsonPath("$.path[2]").isEqualTo(6)
    }

    @Order(4)
    @Test
    fun `test get optimal path - path not found`() {
        webClient.get().uri("/api/paths/1/7")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.error_message").isEqualTo("No route found between source 1 and destination 7")
    }

}