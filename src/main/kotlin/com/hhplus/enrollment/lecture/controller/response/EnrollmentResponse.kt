package com.hhplus.enrollment.lecture.controller.response

import com.hhplus.enrollment.lecture.application.info.EnrollmentInfo

data class EnrollmentResponse(
    var lectureId: Long,
    var lectureName: String,
    var studentId: Long,
    var studentNo: String,
    var acceptYn: Boolean
) {
    companion object {
        fun from(enrollmentInfo: EnrollmentInfo): EnrollmentResponse {
            return EnrollmentResponse(
                enrollmentInfo.lectureId,
                "",
                enrollmentInfo.studentId,
                "",
                true
            )
        }
    }
}