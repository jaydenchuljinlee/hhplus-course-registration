package com.hhplus.enrollment.lecture.domain.param

import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentHistoryQuery

data class EnrollmentHistoryParam(
    var userId: Long
) {
    init {
        require(userId >= 0) { "User ID는 0 이상이어야 합니다."}
    }

    fun toQuery(): EnrollmentHistoryQuery = EnrollmentHistoryQuery(userId)
}