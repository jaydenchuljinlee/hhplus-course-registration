package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import java.time.LocalDateTime

data class LectureDto(
    var lectureId: Long,
    var lectureName: String,
    var capacity: Int,
    var applyStartDt: LocalDateTime,
    var applyEndDt: LocalDateTime
) {
    companion object {
        fun from(lectureEntity: LectureEntity): LectureDto {
            return LectureDto(
                lectureId = lectureEntity.id,
                lectureName = lectureEntity.lectureName,
                capacity = lectureEntity.capacity,
                applyStartDt = lectureEntity.applyStartDt,
                applyEndDt = lectureEntity.applyEndDt
            )
        }
    }
}