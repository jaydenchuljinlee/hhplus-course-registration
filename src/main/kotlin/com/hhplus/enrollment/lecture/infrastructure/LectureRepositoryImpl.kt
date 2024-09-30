package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.jpa.LectureJpaRepository
import com.hhplus.enrollment.lecture.infrastructure.projection.LectureProjection
import org.springframework.stereotype.Repository

@Repository
class LectureRepositoryImpl(
    private val lectureJpaRepository: LectureJpaRepository
): LectureRepository {
    override fun getLecture(lectureId: Long): LectureProjection {
        val result = lectureJpaRepository.findById(lectureId).orElseThrow { NullPointerException("강의 정보를 찾을 수 없습니다.") }
        return LectureProjection.from(result)
    }

    override fun getLectures(): List<LectureProjection> {
        val results = lectureJpaRepository.findAll()
        return results.map { LectureProjection.from(it) }
    }
}