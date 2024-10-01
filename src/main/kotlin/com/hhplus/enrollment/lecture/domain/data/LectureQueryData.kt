package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.query.LectureQuery

data class LectureQueryData(
    var lectureId: Long
) {
    companion object {
        fun of(lectureId: Long): LectureQueryData {
            return LectureQueryData(lectureId)
        }
    }

    fun toDto(): LectureQuery {
        return LectureQuery(lectureId)
    }
}