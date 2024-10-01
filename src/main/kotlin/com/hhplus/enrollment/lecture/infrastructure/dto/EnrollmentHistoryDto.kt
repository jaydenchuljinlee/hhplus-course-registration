package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentHistoryEntity

data class EnrollmentHistoryDto(
    var enrollmentHistoryId: Long,
    var enrollmentId: Long,
    var lectureId: Long,
    var lectureName: String,
    var traineeId: Long,
    var traineeNo: String,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    companion object {
        fun from(enrollmentHistoryEntity: EnrollmentHistoryEntity): EnrollmentHistoryDto {
            return EnrollmentHistoryDto(
                enrollmentHistoryId = enrollmentHistoryEntity.id,
                enrollmentId = enrollmentHistoryEntity.enrollmentId,
                lectureId = enrollmentHistoryEntity.lectureId,
                lectureName = "",
                traineeId = enrollmentHistoryEntity.traineeId,
                traineeNo = "",
                acceptYn = enrollmentHistoryEntity.acceptYn == 'Y',
                cancelYn = enrollmentHistoryEntity.cancelYn == 'Y'
            )
        }
    }
}