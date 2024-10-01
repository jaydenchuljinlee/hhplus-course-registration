package com.hhplus.enrollment.lecture.infrastructure.dto

data class AppliedEnrollmentHistoryQueryDto(
    var traineeId: Long,
    var lectureId: Long
) {
    companion object {
        fun of(traineeId: Long, lectureId: Long): AppliedEnrollmentHistoryQueryDto {
            return AppliedEnrollmentHistoryQueryDto(traineeId, lectureId)
        }
    }
}