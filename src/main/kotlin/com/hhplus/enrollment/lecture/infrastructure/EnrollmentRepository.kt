package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.projection.EnrollmentProjection
import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentQuery

interface EnrollmentRepository {
    fun enroll(query: EnrollmentQuery): EnrollmentProjection
}