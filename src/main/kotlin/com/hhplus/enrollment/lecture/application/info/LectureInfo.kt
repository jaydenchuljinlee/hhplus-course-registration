package com.hhplus.enrollment.lecture.application.info

import com.hhplus.enrollment.lecture.domain.data.LectureData

data class LectureInfo(
    var lectureId: Long,
    var lectureName: String
) {
    companion object {
        fun from(lectureData: LectureData) = LectureInfo(
            lectureId = lectureData.lectureId,
            lectureName = lectureData.lectureName
        )
    }
}