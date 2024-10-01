package com.hhplus.enrollment.lecture.infrastructure.dto

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import java.time.LocalDateTime

data class LectureDto(
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
        fun from(entity: LectureEntity): LectureDto {
            return LectureDto(
                id = entity.id,
                tutorId = entity.tutorId,
                capacity = entity.capacity,
                date = entity.date,
                openYn = entity.openYn,
                createdDt = entity.createdDt,
                updatedDt = entity.updatedDt,
                useYn = entity.useYn,
            )
        }
    }

    fun toEntity(): LectureEntity {
        return LectureEntity(
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