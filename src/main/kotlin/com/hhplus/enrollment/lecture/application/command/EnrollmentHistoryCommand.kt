package com.hhplus.enrollment.lecture.application.command

import com.hhplus.enrollment.lecture.domain.param.EnrollmentHistoryParam

data class EnrollmentHistoryCommand(
    var userId: Long,
) {
    fun toParam() = EnrollmentHistoryParam(userId = userId)
}