package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.exception.LectureNotFoundException
import com.hhplus.enrollment.lecture.infrastructure.jpa.LectureJpaRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component

@Component
class LectureRepositoryImpl(
    private val lectureJpaRepository: LectureJpaRepository
): LectureRepository {
    override suspend fun getLecture(query: LectureQueryDto): LectureEntity {
        val result = withContext(Dispatchers.IO) {
            lectureJpaRepository.findById(query.lectureId).orElseThrow { LectureNotFoundException() }
        }
        return result
    }

    override suspend fun getAvailableLectures(): List<LectureEntity> {
        val results = withContext(Dispatchers.IO) {
            lectureJpaRepository.findByCapacityGreaterThan()
        }
        return results
    }

    override suspend fun enroll(command: LectureEntity): LectureEntity {
        withContext(Dispatchers.IO) {
            lectureJpaRepository.save(command)
        }
        return command
    }
}