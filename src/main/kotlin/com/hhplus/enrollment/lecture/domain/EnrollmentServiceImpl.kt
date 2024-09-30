package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.param.EnrollmentHistoryParam
import com.hhplus.enrollment.lecture.domain.param.EnrollmentParam
import com.hhplus.enrollment.lecture.domain.result.EnrollmentHistoryResult
import com.hhplus.enrollment.lecture.domain.result.EnrollmentResult
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
    override fun enroll(param: EnrollmentParam): EnrollmentResult {
        // 만약 여기서 유효성 검사를 한다면?? Tutor와 Lecutor 조회에 대한 유효성 검사를 어덯게? 사실 이미 내부에서 검사히긴 했음
        validator.validate(param)
        val result = enrollmentRepository.enroll(param.toQuery())
        return EnrollmentResult.from(result)
    }

    override fun getEnrollmentHistories(param: EnrollmentHistoryParam): List<EnrollmentHistoryResult> {
        val result = enrollmentHistoryRepository.getEnrollmentHistories(param.toQuery())
        return result.map { EnrollmentHistoryResult.from(it) }
    }
}