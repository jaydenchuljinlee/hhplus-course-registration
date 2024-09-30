package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.infrastructure.projection.TutorProjection
import com.hhplus.enrollment.user.infrastructure.query.TutorQuery

interface TutorRepository {
    fun getTutor(query: TutorQuery): TutorProjection
}