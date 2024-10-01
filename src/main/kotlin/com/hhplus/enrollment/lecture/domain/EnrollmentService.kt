package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.data.EnrollmentHistoryQueryData
import com.hhplus.enrollment.lecture.domain.data.EnrollmentCommandData
import com.hhplus.enrollment.lecture.domain.data.EnrollmentData
import com.hhplus.enrollment.lecture.domain.data.EnrollmentHistoryData

interface EnrollmentService {
    fun enroll(query: EnrollmentCommandData): EnrollmentData
    fun getEnrollmentHistories(query: EnrollmentHistoryQueryData): List<EnrollmentHistoryData>
}