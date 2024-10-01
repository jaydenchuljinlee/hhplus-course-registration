package com.hhplus.enrollment.lecture.domain.data

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto
import java.time.LocalDateTime

data class LectureData(
    var id: Long,
    var tutorId: Long,
    var capacity: Int,
    var date: LocalDateTime,
    var openYn: Char,

    var createdDt: LocalDateTime,
    var updatedDt: LocalDateTime,
    var useYn: Char,
) {
    companion object {
        fun from(dto: LectureDto): LectureData = LectureData(
            id = dto.id,
            tutorId = dto.tutorId,
            capacity = dto.capacity,
            date = dto.date,
            openYn = dto.openYn,
            createdDt = dto.createdDt,
            updatedDt = dto.updatedDt,
            useYn = dto.useYn,
        )
    }

    fun decrease() {
        require(capacity.minus(1) >= 0) { throw RuntimeException("강의 인원이 초과되었습니다.") }
    }

    // Deprecated. 날짜 별로 특강이 존재하기 때문에 lecture_id만으로 충분히 유효성 검사가 가능하고, 날짜에 대한 유효성 검사가 필요가 없다.
    fun validateDate(now: LocalDateTime) {
        require(now.isAfter(date) && now.isBefore(date)) {
            throw RuntimeException("강의 수강 기간이 아닙니다.")
        }
    }

    fun toDto(): LectureDto {
        return LectureDto(
            id = id,
            tutorId = tutorId,
            capacity = capacity,
            date = date,
            openYn = openYn,
            createdDt = createdDt,
            updatedDt = updatedDt,
            useYn = useYn,
        )
    }
}