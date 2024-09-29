package com.hhplus.enrollment.lecture.infrastructure.projection

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentTable

data class EnrollmentProjection(
    var lectureId: Long,
    var studentId: Long
) {
    companion object {
        fun from(table: EnrollmentTable): EnrollmentProjection {
            return EnrollmentProjection(
                lectureId = table.lectureId,
                studentId = table.traineeId
            )

        }
    }
}