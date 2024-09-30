package com.hhplus.enrollment.lecture.infrastructure.projection

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentTable

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
}