package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryDto

data class EnrollmentHistoryData(
    var enrollmentHistoryId: Long,
    var enrollmentId: Long,
    var lectureId: Long,
    var lectureName: String,
    var studentId: Long,
    var studentNo: String,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    companion object {
        fun from(enrollmentHistoryDto: EnrollmentHistoryDto) = EnrollmentHistoryData(
            enrollmentHistoryId = enrollmentHistoryDto.enrollmentHistoryId,
            enrollmentId = enrollmentHistoryDto.enrollmentId,
            lectureId = enrollmentHistoryDto.lectureId,
            lectureName = enrollmentHistoryDto.lectureName,
            studentId = enrollmentHistoryDto.traineeId,
            studentNo = enrollmentHistoryDto.traineeNo,
            acceptYn = enrollmentHistoryDto.acceptYn,
            cancelYn = enrollmentHistoryDto.cancelYn
        )
    }
}