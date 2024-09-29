package com.hhplus.enrollment.lecture.application.command

import com.hhplus.enrollment.lecture.domain.param.EnrollmentParam

data class EnrollmentCommand(
    var lectureId: Long,
    var studentId: Long
) {
    fun toParam(): EnrollmentParam = EnrollmentParam(lectureId, studentId)
}