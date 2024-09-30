package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.infrastructure.projection.TraineeProjection
import com.hhplus.enrollment.user.infrastructure.query.TraineeQuery

interface TraineeRepository {
    fun getTrainees(query: TraineeQuery): TraineeProjection
}