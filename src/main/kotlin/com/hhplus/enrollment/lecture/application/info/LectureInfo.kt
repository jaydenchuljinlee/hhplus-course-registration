package com.hhplus.enrollment.lecture.application.info

import com.hhplus.enrollment.lecture.domain.result.LectureResult

data class LectureInfo(
    var lectureId: Long,
    var lectureName: String
) {
    companion object {
        fun from(lectureResult: LectureResult) = LectureInfo(
            lectureId = lectureResult.lectureId,
            lectureName = lectureResult.lectureName
        )
    }
}