package com.hhplus.enrollment.lecture.domain.result

import com.hhplus.enrollment.lecture.infrastructure.projection.EnrollmentHistoryProjection

data class EnrollmentHistoryResult(
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
        fun from(enrollmentHistoryProjection: EnrollmentHistoryProjection) = EnrollmentHistoryResult(
            enrollmentHistoryId = enrollmentHistoryProjection.enrollmentHistoryId,
            enrollmentId = enrollmentHistoryProjection.enrollmentId,
            lectureId = enrollmentHistoryProjection.lectureId,
            lectureName = enrollmentHistoryProjection.lectureName,
            studentId = enrollmentHistoryProjection.traineeId,
            studentNo = enrollmentHistoryProjection.traineeNo,
            acceptYn = enrollmentHistoryProjection.acceptYn,
            cancelYn = enrollmentHistoryProjection.cancelYn
        )
    }
}