package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.data.EnrollmentHistoryQueryData
import com.hhplus.enrollment.lecture.domain.data.EnrollmentCommandData
import com.hhplus.enrollment.lecture.domain.data.EnrollmentHistoryData
import com.hhplus.enrollment.lecture.domain.data.EnrollmentData
import com.hhplus.enrollment.lecture.domain.validator.EnrollmentValidator
import com.hhplus.enrollment.lecture.infrastructure.EnrollmentHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.EnrollmentRepository
import org.springframework.stereotype.Service

@Service
class EnrollmentServiceImpl(
    private val enrollmentRepository: EnrollmentRepository,
    private val enrollmentHistoryRepository: EnrollmentHistoryRepository,
    private val validator: EnrollmentValidator
): EnrollmentService {
    override fun enroll(query: EnrollmentCommandData): EnrollmentData {
        // 만약 여기서 유효성 검사를 한다면?? Tutor와 Lecutor 조회에 대한 유효성 검사를 어덯게? 사실 이미 내부에서 검사히긴 했음
        validator.validate(query)
        val result = enrollmentRepository.enroll(query.toDto())

        enrollmentHistoryRepository.insert(result.toHistory())
        return EnrollmentData.from(result)
    }

    override fun getEnrollmentHistories(query: EnrollmentHistoryQueryData): List<EnrollmentHistoryData> {
        val result = enrollmentHistoryRepository.getEnrollmentHistories(query.toDto())
        return result.map { EnrollmentHistoryData.from(it) }
    }
}