package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.param.EnrollmentHistoryParam
import com.hhplus.enrollment.lecture.domain.param.EnrollmentParam
import com.hhplus.enrollment.lecture.domain.result.EnrollmentHistoryResult
import com.hhplus.enrollment.lecture.domain.result.EnrollmentResult
import com.hhplus.enrollment.lecture.infrastructure.EnrollmentHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.EnrollmentRepository
import org.springframework.stereotype.Service

@Service
class EnrollmentServiceImpl(
    private val enrollmentRepository: EnrollmentRepository,
    private val enrollmentHistoryRepository: EnrollmentHistoryRepository
): EnrollmentService {
    override fun enroll(param: EnrollmentParam): EnrollmentResult {
        val result = enrollmentRepository.enroll(param.toQuery())
        return EnrollmentResult.from(result)
    }

    override fun getEnrollmentHistories(param: EnrollmentHistoryParam): List<EnrollmentHistoryResult> {
        val result = enrollmentHistoryRepository.getEnrollmentHistories(param.toQuery())
        return result.map { EnrollmentHistoryResult.from(it) }
    }
}