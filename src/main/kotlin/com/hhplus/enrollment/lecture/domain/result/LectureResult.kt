package com.hhplus.enrollment.lecture.domain.result

import com.hhplus.enrollment.lecture.infrastructure.projection.LectureProjection
import com.hhplus.enrollment.lecture.infrastructure.query.LectureQuery

data class LectureResult(
    var lectureId: Long,
    var lectureName: String
) {
    companion object {
        fun from(lectureProjection: LectureProjection): LectureResult = LectureResult(
            lectureId = lectureProjection.lectureId,
            lectureName = lectureProjection.lectureName
        )
    }
}