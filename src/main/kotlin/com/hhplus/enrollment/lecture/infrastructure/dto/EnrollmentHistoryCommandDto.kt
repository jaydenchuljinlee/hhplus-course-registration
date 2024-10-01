package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentHistoryEntity

data class EnrollmentHistoryCommandDto(
    var enrollmentId: Long,
    var lectureId: Long,
    var traineeId: Long,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    fun toEntity(): EnrollmentHistoryEntity {
        return EnrollmentHistoryEntity(
            enrollmentId = enrollmentId,
            lectureId = lectureId,
            traineeId = traineeId,
            acceptYn = if (acceptYn) 'Y' else 'N',
            cancelYn = if (cancelYn) 'Y' else 'N'
        )
    }
}