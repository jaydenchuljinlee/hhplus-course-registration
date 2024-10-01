package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentEntity

data class EnrollmentCommandDto(
    var lectureId: Long,
    var traineeId: Long
) {
    init {
        require(lectureId >= 0) { "Lecture ID는 0 이상이어야 합니다."}
        require(traineeId >= 0) { "Student ID는 0 이상이어야 합니다."}
    }

    fun toEntity(): EnrollmentEntity {
        return EnrollmentEntity(
            lectureId = lectureId,
            traineeId = traineeId,
            acceptYn = 'Y'
        )
    }
}