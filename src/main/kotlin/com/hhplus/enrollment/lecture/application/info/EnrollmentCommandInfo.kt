package com.hhplus.enrollment.lecture.application.info

import com.hhplus.enrollment.lecture.domain.data.EnrollmentCommandData

data class EnrollmentCommandInfo(
    var lectureId: Long,
    var traineeId: Long,
) {
    companion object {
        fun of(lectureId: Long, traineeId: Long): EnrollmentCommandInfo {
            return EnrollmentCommandInfo(lectureId, traineeId)
        }
    }

    fun toData(): EnrollmentCommandData {
        return EnrollmentCommandData(lectureId, traineeId)
    }
}