package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.projection.EnrollmentProjection

data class EnrollmentData(
    var lectureId: Long,
    var studentId: Long
) {
    companion object {
        fun from(enrollmentProjection: EnrollmentProjection) = EnrollmentData(
            lectureId = enrollmentProjection.lectureId,
            studentId = enrollmentProjection.traineeId
        )
    }
}