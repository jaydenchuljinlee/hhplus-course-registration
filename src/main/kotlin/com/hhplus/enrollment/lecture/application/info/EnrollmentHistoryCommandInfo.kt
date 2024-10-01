package com.hhplus.enrollment.lecture.application.info

import com.hhplus.enrollment.lecture.domain.data.EnrollmentHistoryQueryData

data class EnrollmentHistoryCommandInfo(
    var userId: Long,
) {
    fun toData() = EnrollmentHistoryQueryData(userId = userId)
}