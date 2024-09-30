package com.hhplus.enrollment.lecture.domain.param

import com.hhplus.enrollment.lecture.infrastructure.query.EnrollmentQuery


data class EnrollmentParam(
    var lectureId: Long,
    var traineeId: Long
) {
    init {
        require(lectureId >= 0) { "Lecture ID는 0 이상이어야 합니다."}
        require(traineeId >= 0) { "Trainee ID는 0 이상이어야 합니다."}
    }

    fun toQuery(): EnrollmentQuery = EnrollmentQuery(lectureId, traineeId)
}