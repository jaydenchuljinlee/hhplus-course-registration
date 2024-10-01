package com.hhplus.enrollment.lecture.infrastructure.dto

data class LectureHistoryQueryDto(
    var traineeId: Long
) {
    init {
        require(traineeId >= 0) { "Trainee ID는 0 이상이어야 합니다."}
    }
}