package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.jpa.EnrollmentHistoryJapRepository
import com.hhplus.enrollment.lecture.infrastructure.projection.EnrollmentHistoryProjection
import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentHistoryQuery
import org.springframework.stereotype.Repository

@Repository
class EnrollmentHistoryRepositoryImpl(
    private val jpaRepository: EnrollmentHistoryJapRepository
): EnrollmentHistoryRepository {
    override fun getEnrollmentHistories(query: EnrollmentHistoryQuery): List<EnrollmentHistoryProjection> {
        val results = jpaRepository.findAllByTraineeId(query.userId)
        return results.map { EnrollmentHistoryProjection.from(it) }
    }
}