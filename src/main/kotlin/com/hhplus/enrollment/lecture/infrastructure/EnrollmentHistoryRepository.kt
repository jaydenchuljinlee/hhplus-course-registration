package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentHistoryQueryDto

interface EnrollmentHistoryRepository {
    fun insert(command: EnrollmentHistoryCommandDto): EnrollmentHistoryDto
    fun getEnrollmentHistories(query: EnrollmentHistoryQueryDto): List<EnrollmentHistoryDto>
}