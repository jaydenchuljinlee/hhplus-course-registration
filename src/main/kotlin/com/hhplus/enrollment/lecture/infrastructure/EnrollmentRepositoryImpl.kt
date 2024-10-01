package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.jpa.EnrollmentJpaRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentCommandDto
import org.springframework.stereotype.Component

@Component
class EnrollmentRepositoryImpl(
    private val jpaRepository: EnrollmentJpaRepository
): EnrollmentRepository {
    override fun enroll(command: EnrollmentCommandDto): EnrollmentDto {
        val result = jpaRepository.save(command.toEntity())
        return EnrollmentDto.from(result)
    }
}