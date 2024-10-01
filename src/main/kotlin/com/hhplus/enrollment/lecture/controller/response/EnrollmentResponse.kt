package com.hhplus.enrollment.lecture.controller.response

import com.hhplus.enrollment.lecture.application.info.EnrollmentInfo

data class EnrollmentResponse(
    var enrollmentId: Long,
    var lectureId: Long,
    var traineeId: Long,
    var studentNo:String
) {
    companion object {
        fun from(enrollmentInfo: EnrollmentInfo): EnrollmentResponse {
            return EnrollmentResponse(
                enrollmentInfo.enrollmentId,
                enrollmentInfo.lectureId,
                enrollmentInfo.traineeId,
                enrollmentInfo.studentNo
            )
        }
    }
}