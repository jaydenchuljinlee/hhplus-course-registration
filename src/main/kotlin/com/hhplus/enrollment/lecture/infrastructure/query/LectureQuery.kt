package com.hhplus.enrollment.lecture.infrastructure.query

data class LectureQuery(
    var lectureId: Long
) {
    companion object {
        fun of(lectureId: Long): LectureQuery {
            return LectureQuery(lectureId)
        }
    }
}