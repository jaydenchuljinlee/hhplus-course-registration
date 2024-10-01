package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentEntity

data class EnrollmentDto(
    var enrollmentId: Long,
    var lectureId: Long,
    var traineeId: Long
) {
    companion object {
        fun from(table: EnrollmentEntity): EnrollmentDto {
            return EnrollmentDto(
                enrollmentId = table.id,
                lectureId = table.lectureId,
                traineeId = table.traineeId
            )
        }
    }

    fun toHistory(): EnrollmentHistoryCommandDto {
        return EnrollmentHistoryCommandDto(
            enrollmentId = enrollmentId,
            lectureId = lectureId,
            traineeId = traineeId,
            acceptYn = true,
            cancelYn = false
        )
    }
}