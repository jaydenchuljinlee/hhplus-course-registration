package com.hhplus.enrollment.lecutre.domain.stub

import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrolledLectureHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureHistoryEntity
import java.time.LocalDateTime

class StubLectureHistoryRepository: LectureHistoryRepository {
    private val historyies = mutableListOf<LectureHistoryEntity>()

    init {
        // Initialize with some sample data for testing
        historyies.add(LectureHistoryEntity(2L, 2L, 1L, 'Y', 'N'))
        historyies.add(LectureHistoryEntity(1L, 1L, 1L, 'Y', 'Y', createdAt = LocalDateTime.of(2024, 9, 30, 1,1,1)))

        historyies.add(LectureHistoryEntity(3L, 2L, 3L, 'Y', 'N'))
        historyies.add(LectureHistoryEntity(4L, 3L, 2L, 'Y', 'N'))
    }

    override fun insert(command: LectureHistoryCommandDto): LectureHistoryDto {
        historyies.add(command.toEntity())
        return LectureHistoryDto.from(command.toEntity())
    }

    override fun getEnrollmentHistories(query: LectureHistoryQueryDto): List<LectureHistoryDto> {
        val results = historyies
            .filter { query.traineeId == it.traineeId }
            .map { LectureHistoryDto.from(it) }
        return results
    }

    override fun getEnrolledHistory(query: EnrolledLectureHistoryQueryDto): LectureHistoryDto? {
        val results = historyies
            .filter { it.traineeId == query.traineeId && it.lectureId == query.traineeId }
            .sortedBy { it.createdAt }
            .map { LectureHistoryDto.from(it) }.firstOrNull()

        return results
    }

}