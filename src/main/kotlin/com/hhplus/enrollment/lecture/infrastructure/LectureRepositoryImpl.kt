package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.jpa.LectureJpaRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto
import org.springframework.stereotype.Component

@Component
class LectureRepositoryImpl(
    private val lectureJpaRepository: LectureJpaRepository
): LectureRepository {
    override fun getLecture(query: LectureQueryDto): LectureDto {
        val result = lectureJpaRepository.findById(query.lectureId).orElseThrow { NullPointerException("강의 정보를 찾을 수 없습니다.") }
        return LectureDto.from(result)
    }

    override fun getLectures(): List<LectureDto> {
        val results = lectureJpaRepository.findAll()
        return results.map { LectureDto.from(it) }
    }
}