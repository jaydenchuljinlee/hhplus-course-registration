package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.jpa.EnrollmentHistoryJapRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryQueryDto
import org.springframework.stereotype.Component

@Component
class EnrollmentHistoryRepositoryImpl(
    private val jpaRepository: EnrollmentHistoryJapRepository
): EnrollmentHistoryRepository {
    override fun insert(command: EnrollmentHistoryCommandDto): EnrollmentHistoryDto {
        val results = jpaRepository.save(command.toEntity())
        return EnrollmentHistoryDto.from(results)
    }

    override fun getEnrollmentHistories(query: EnrollmentHistoryQueryDto): List<EnrollmentHistoryDto> {
        val results = jpaRepository.findAllByTraineeId(query.userId)
        return results.map { EnrollmentHistoryDto.from(it) }
    }
}