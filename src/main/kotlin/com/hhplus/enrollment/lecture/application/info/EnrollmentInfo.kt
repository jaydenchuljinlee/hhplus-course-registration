package com.hhplus.enrollment.lecture.application.info

import com.hhplus.enrollment.lecture.domain.data.EnrollmentData

data class EnrollmentInfo(
    var enrollmentId: Long,
    var lectureId: Long,
    var traineeId: Long,
    var studentNo:String
) {
    companion object {
        fun from(enrollmentData: EnrollmentData): EnrollmentInfo = EnrollmentInfo(
            enrollmentId = enrollmentData.lectureId,
            lectureId = enrollmentData.lectureId,
            traineeId = enrollmentData.studentId,
            studentNo = "" // TODO: studentNo 로직 구현
        )
    }
}