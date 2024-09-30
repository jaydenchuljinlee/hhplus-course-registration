package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.jpa.EnrollmentJpaRepository
import com.hhplus.enrollment.lecture.infrastructure.projection.EnrollmentProjection
import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentQuery
import org.springframework.stereotype.Component

@Component
class EnrollmentRepositoryImpl(
    private val jpaRepository: EnrollmentJpaRepository
): EnrollmentRepository {
    override fun enroll(query: EnrollmentQuery): EnrollmentProjection {
        val result = jpaRepository.save(query.toTable())
        return EnrollmentProjection.from(result)
    }
}