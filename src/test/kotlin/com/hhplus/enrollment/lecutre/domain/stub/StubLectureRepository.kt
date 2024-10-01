package com.hhplus.enrollment.lecutre.domain.stub

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureCommandDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity


class StubLectureRepository {
    private val table = mutableMapOf<Long, LectureEntity>()
//
//    init {
//
//
//    }
//
//    override fun enroll(command: LectureCommandDto): EnrollmentDto {
//        table[1] = command.toEntity()
//        return EnrollmentDto.from(command.toEntity())
//    }
//
//    override fun countEnrollmentByLectureId(lectureId: Long): Long {
//        val result = table.values.filter { it.lectureId == lectureId }
//        return result.count().toLong()
//    }
}