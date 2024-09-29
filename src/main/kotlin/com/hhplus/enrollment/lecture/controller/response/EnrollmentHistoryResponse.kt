package com.hhplus.enrollment.lecture.controller.response

import com.hhplus.enrollment.lecture.application.info.EnrollmentHistoryInfo

data class EnrollmentHistoryResponse(
    var lectureId: Long,
    var lectureName: String,
    var studentId: Long,
    var studentNo: String,
    var acceptYn: Boolean,
    var cancelYn: Boolean,
) {
    companion object {
        fun from(enrollmentHistoryInfo: EnrollmentHistoryInfo) = EnrollmentHistoryResponse(
            enrollmentHistoryInfo.lectureId,
            enrollmentHistoryInfo.lectureName,
            enrollmentHistoryInfo.studentId,
            enrollmentHistoryInfo.studentNo,
            enrollmentHistoryInfo.acceptYn,
            enrollmentHistoryInfo.cancelYn
        )
    }
}