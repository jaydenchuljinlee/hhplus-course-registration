package com.hhplus.enrollment.lecture.infrastructure.projection

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentTable
import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentHistoryInsertionQuery

data class EnrollmentProjection(
    var enrollmentId: Long,
    var lectureId: Long,
    var traineeId: Long
) {
    companion object {
        fun from(table: EnrollmentTable): EnrollmentProjection {
            return EnrollmentProjection(
                enrollmentId = table.id,
                lectureId = table.lectureId,
                traineeId = table.traineeId
            )
        }
    }

    fun toHistory(): EnrollmentHistoryInsertionQuery {
        return EnrollmentHistoryInsertionQuery(
            enrollmentId = enrollmentId,
            lectureId = lectureId,
            traineeId = traineeId,
            acceptYn = true,
            cancelYn = false
        )
    }
}