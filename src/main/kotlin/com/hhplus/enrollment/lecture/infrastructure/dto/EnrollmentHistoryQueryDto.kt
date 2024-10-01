package com.hhplus.enrollment.lecture.infrastructure.dto

data class EnrollmentHistoryQueryDto(
    var userId: Long
) {
    init {
        require(userId >= 0) { "User ID는 0 이상이어야 합니다."}
    }
}