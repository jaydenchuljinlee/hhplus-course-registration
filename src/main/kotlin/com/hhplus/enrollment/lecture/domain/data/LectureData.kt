package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.projection.LectureProjection

data class LectureData(
    var lectureId: Long,
    var lectureName: String
) {
    companion object {
        fun from(lectureProjection: LectureProjection): LectureData = LectureData(
            lectureId = lectureProjection.lectureId,
            lectureName = lectureProjection.lectureName
        )
    }
}