package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity

data class LectureDto(
    var lectureId: Long,
    var lectureName: String
) {
    companion object {
        fun from(lectureEntity: LectureEntity): LectureDto {
            return LectureDto(
                lectureId = lectureEntity.id,
                lectureName = lectureEntity.lectureName
            )
        }
    }
}