package com.hhplus.enrollment.lecture.domain.param

data class LectureParam(
    var lectureId: Long
) {
    companion object {
        fun of(lectureId: Long): LectureParam {
            return LectureParam(lectureId)
        }
    }
}