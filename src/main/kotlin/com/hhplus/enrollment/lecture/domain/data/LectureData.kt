package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto

data class LectureData(
    var lectureId: Long,
    var lectureName: String
) {
    companion object {
        fun from(lectureDto: LectureDto): LectureData = LectureData(
            lectureId = lectureDto.lectureId,
            lectureName = lectureDto.lectureName
        )
    }
}