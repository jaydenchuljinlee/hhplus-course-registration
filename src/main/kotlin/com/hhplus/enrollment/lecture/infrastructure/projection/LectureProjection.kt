package com.hhplus.enrollment.lecture.infrastructure.projection

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureTable

data class LectureProjection(
    var lectureId: Long,
    var lectureName: String
) {
    companion object {
        fun from(lectureTable: LectureTable): LectureProjection {
            return LectureProjection(
                lectureId = lectureTable.id,
                lectureName = lectureTable.lectureName
            )
        }
    }
}