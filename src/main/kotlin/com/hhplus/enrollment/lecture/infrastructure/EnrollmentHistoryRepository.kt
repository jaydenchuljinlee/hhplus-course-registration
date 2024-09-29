package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.projection.EnrollmentHistoryProjection
import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentHistoryQuery

interface EnrollmentHistoryRepository {
    fun getEnrollmentHistories(query: EnrollmentHistoryQuery): List<EnrollmentHistoryProjection>
}