package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.param.EnrollmentHistoryParam
import com.hhplus.enrollment.lecture.domain.param.EnrollmentParam
import com.hhplus.enrollment.lecture.domain.result.EnrollmentResult
import com.hhplus.enrollment.lecture.domain.result.EnrollmentHistoryResult

interface EnrollmentService {
    fun enroll(param: EnrollmentParam): EnrollmentResult
    fun getEnrollmentHistories(param: EnrollmentHistoryParam): List<EnrollmentHistoryResult>
}