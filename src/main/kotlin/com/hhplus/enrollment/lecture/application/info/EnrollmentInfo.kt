package com.hhplus.enrollment.lecture.application.info

import com.hhplus.enrollment.lecture.domain.result.EnrollmentResult

data class EnrollmentInfo(
    var enrollmentId: Long,
    var lectureId: Long,
    var studentId: Long,
    var studentNo:String
) {
    companion object {
        fun from(enrollmentResult: EnrollmentResult): EnrollmentInfo = EnrollmentInfo(
            enrollmentId = enrollmentResult.lectureId,
            lectureId = enrollmentResult.lectureId,
            studentId = enrollmentResult.studentId,
            studentNo = "" // TODO: studentNo 로직 구현
        )
    }
}