package com.hhplus.enrollment.lecutre.domain.stub

import com.hhplus.enrollment.lecture.infrastructure.EnrollmentHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.AppliedEnrollmentHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentHistoryEntity
import java.time.LocalDateTime

class StubEnrollmentHistoryRepository: EnrollmentHistoryRepository {
    private val historyies = mutableListOf<EnrollmentHistoryEntity>()

    init {
        // Initialize with some sample data for testing
        historyies.add(EnrollmentHistoryEntity(2L, 2L, 1L, 1L,'Y', 'N'))
        historyies.add(EnrollmentHistoryEntity(1L, 1L, 1L, 1L,'Y', 'Y', createdAt = LocalDateTime.of(2024, 9, 30, 1,1,1)))

        historyies.add(EnrollmentHistoryEntity(3L, 2L, 3L, 1L,'Y', 'N'))
        historyies.add(EnrollmentHistoryEntity(4L, 3L, 2L, 1L,'Y', 'N'))
    }

    override fun insert(command: EnrollmentHistoryCommandDto): EnrollmentHistoryDto {
        historyies.add(command.toEntity())
        return EnrollmentHistoryDto.from(command.toEntity())
    }

    override fun getEnrollmentHistories(query: EnrollmentHistoryQueryDto): List<EnrollmentHistoryDto> {
        val results = historyies
            .filter { query.traineeId == it.traineeId }
            .map { EnrollmentHistoryDto.from(it) }
        return results
    }

    override fun getAppliedHistory(query: AppliedEnrollmentHistoryQueryDto): EnrollmentHistoryDto? {
        val results = historyies
            .filter { it.traineeId == query.traineeId && it.lectureId == query.traineeId }
            .sortedBy { it.createdAt }
            .map { EnrollmentHistoryDto.from(it) }.firstOrNull()

        return results
    }
}