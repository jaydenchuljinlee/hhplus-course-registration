package com.hhplus.enrollment.lecture.domain.result

import com.hhplus.enrollment.lecture.infrastructure.projection.EnrollmentProjection

data class EnrollmentResult(
    var lectureId: Long,
    var studentId: Long
) {
    companion object {
        fun from(enrollmentProjection: EnrollmentProjection) = EnrollmentResult(
            lectureId = enrollmentProjection.lectureId,
            studentId = enrollmentProjection.studentId
        )
    }
}