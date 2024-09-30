package com.hhplus.enrollment.lecture.infrastructure.query

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentTable

data class EnrollmentQuery(
    var lectureId: Long,
    var traineeId: Long
) {
    init {
        require(lectureId >= 0) { "Lecture ID는 0 이상이어야 합니다."}
        require(traineeId >= 0) { "Student ID는 0 이상이어야 합니다."}
    }

    fun toTable(): EnrollmentTable {
        return EnrollmentTable(
            lectureId = lectureId,
            traineeId = traineeId,
            acceptYn = 'Y'
        )
    }
}