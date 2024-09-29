package com.hhplus.enrollment.lecture.application.info

import com.hhplus.enrollment.lecture.domain.result.EnrollmentHistoryResult

data class EnrollmentHistoryInfo(
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
        fun from(enrollmentHistory: EnrollmentHistoryResult): EnrollmentHistoryInfo {
            return EnrollmentHistoryInfo(
                enrollmentHistoryId = enrollmentHistory.enrollmentHistoryId,
                enrollmentId = enrollmentHistory.enrollmentId,
                lectureId = enrollmentHistory.lectureId,
                lectureName = enrollmentHistory.lectureName,
                studentId = enrollmentHistory.studentId,
                studentNo = enrollmentHistory.studentNo,
                acceptYn = enrollmentHistory.acceptYn,
                cancelYn = enrollmentHistory.cancelYn
            )
        }
    }
}