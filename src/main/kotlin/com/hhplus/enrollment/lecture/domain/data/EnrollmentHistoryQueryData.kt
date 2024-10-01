package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryQueryDto

data class EnrollmentHistoryQueryData(
    var userId: Long
) {
    init {
        require(userId >= 0) { "User ID는 0 이상이어야 합니다."}
    }

    fun toDto(): EnrollmentHistoryQueryDto = EnrollmentHistoryQueryDto(userId)
}