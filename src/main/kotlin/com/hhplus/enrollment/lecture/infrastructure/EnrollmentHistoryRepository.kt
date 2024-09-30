package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.projection.EnrollmentHistoryProjection
import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentHistoryInsertionQuery
import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentHistoryQuery

interface EnrollmentHistoryRepository {
    fun insert(query: EnrollmentHistoryInsertionQuery): EnrollmentHistoryProjection
    fun getEnrollmentHistories(query: EnrollmentHistoryQuery): List<EnrollmentHistoryProjection>
}