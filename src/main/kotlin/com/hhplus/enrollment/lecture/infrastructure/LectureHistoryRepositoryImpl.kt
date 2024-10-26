package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrolledLectureHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.LectureHistoryJapRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryQueryDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component

@Component
class LectureHistoryRepositoryImpl(
    private val jpaRepository: LectureHistoryJapRepository
): LectureHistoryRepository {
    override suspend fun insert(command: LectureHistoryCommandDto): LectureHistoryDto {
        val results = withContext(Dispatchers.IO) {
            jpaRepository.save(command.toEntity())
        }
        return LectureHistoryDto.from(results)
    }

    override suspend fun getEnrollmentHistories(query: LectureHistoryQueryDto): List<LectureHistoryDto> {
        val results = withContext(Dispatchers.IO) {
            jpaRepository.findAllByTraineeId(query.traineeId)
        }
        return results.map { LectureHistoryDto.from(it) }
    }

    override suspend fun getEnrolledHistory(query: EnrolledLectureHistoryQueryDto): LectureHistoryDto? {
        val result = withContext(Dispatchers.IO) {
            jpaRepository.findTopByTraineeIdAndLectureIdOrderByCreatedAtDesc(query.traineeId, query.lectureId)
        }
        return if (result.isPresent) {
            LectureHistoryDto.from(result.get())
        } else null
    }
}