package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.infrastructure.dto.TraineeDto
import com.hhplus.enrollment.user.infrastructure.dto.TraineeQueryDto

interface TraineeRepository {
    suspend fun getTrainees(query: TraineeQueryDto): TraineeDto
}