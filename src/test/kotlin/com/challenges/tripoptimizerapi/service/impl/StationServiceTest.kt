package com.challenges.tripoptimizerapi.service.impl

import com.challenges.tripoptimizerapi.fixture.StationFixtureTestObject
import com.challenges.tripoptimizerapi.model.Station
import com.challenges.tripoptimizerapi.repository.impl.StationRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class StationServiceTest {

    @Mock
    private lateinit var  stationRepository: StationRepository

    @InjectMocks
    private lateinit var  underTest: StationService

    private val mapper = ObjectMapper()
    private val testFixture = StationFixtureTestObject()

    @Test
    fun `test save station`() {
        // Given
        val stationId = testFixture.STATION_ID
        val stationCreationDto = testFixture.getStationCreationDto()
        val station = testFixture.getStation()
        val expectedResult = testFixture.getStationResource()

        // When
        Mockito.`when`(stationRepository.save(any<Station>())).thenReturn(station)

        // Then
        val actualResult = underTest.saveStation(stationId, stationCreationDto)
        assertEquals(mapper.writeValueAsString(expectedResult), mapper.writeValueAsString(actualResult))
    }
}
