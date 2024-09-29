package com.hhplus.enrollment.lecture.controller.response

import com.hhplus.enrollment.lecture.application.info.LectureInfo

data class LectureResponse(
    var lectureId: Long,
    var lectureName: String
) {
    companion object {
        fun from(lectureInfo: LectureInfo): LectureResponse {
            return LectureResponse(lectureInfo.lectureId, lectureInfo.lectureName)
        }
    }
}