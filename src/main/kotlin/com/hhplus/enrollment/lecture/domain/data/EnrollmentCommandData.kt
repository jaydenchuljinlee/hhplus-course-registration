package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentCommandDto


data class EnrollmentCommandData(
    var lectureId: Long,
    var traineeId: Long
) {
    init {
        require(lectureId >= 0) { "Lecture ID는 0 이상이어야 합니다."}
        require(traineeId >= 0) { "Trainee ID는 0 이상이어야 합니다."}
    }

    fun toDto(): EnrollmentCommandDto = EnrollmentCommandDto(lectureId, traineeId)
}