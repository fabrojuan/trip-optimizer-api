package com.challenges.tripoptimizerapi.repository

import com.challenges.tripoptimizerapi.model.Path

interface IPathRepository {
    fun save(path: Path): Path
}