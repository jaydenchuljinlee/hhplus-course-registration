package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto
import java.time.LocalDateTime

data class LectureData(
    var lectureId: Long,
    var lectureName: String,
    var capacity: Int,
    var applyStartDt: LocalDateTime,
    var applyEndDt: LocalDateTime
) {
    companion object {
        fun from(lectureDto: LectureDto): LectureData = LectureData(
            lectureId = lectureDto.lectureId,
            lectureName = lectureDto.lectureName,
            capacity = lectureDto.capacity,
            applyStartDt = lectureDto.applyStartDt,
            applyEndDt = lectureDto.applyEndDt
        )
    }
}