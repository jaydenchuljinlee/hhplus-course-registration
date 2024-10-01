package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentDto

data class EnrollmentData(
    var lectureId: Long,
    var studentId: Long
) {
    companion object {
        fun from(enrollmentDto: EnrollmentDto) = EnrollmentData(
            lectureId = enrollmentDto.lectureId,
            studentId = enrollmentDto.traineeId
        )
    }
}