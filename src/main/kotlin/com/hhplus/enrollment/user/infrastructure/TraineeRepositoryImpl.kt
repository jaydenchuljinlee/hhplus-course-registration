package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.infrastructure.jpa.TraineeJpaRepository
import com.hhplus.enrollment.user.infrastructure.projection.TraineeProjection
import com.hhplus.enrollment.user.infrastructure.query.TraineeQuery
import org.springframework.stereotype.Component

@Component
class TraineeRepositoryImpl(
    private val traineeJpaRepository: TraineeJpaRepository
): TraineeRepository {
    override fun getTrainees(query: TraineeQuery): TraineeProjection {
        val result = traineeJpaRepository.findById(query.traineeId).orElseThrow { NullPointerException("수강자 정보를 찾을 수 없습니다.") }
        return TraineeProjection.from(result)
    }
}