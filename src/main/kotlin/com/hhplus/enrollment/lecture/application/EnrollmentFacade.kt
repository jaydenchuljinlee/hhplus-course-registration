package com.hhplus.enrollment.lecture.application

import com.hhplus.enrollment.lecture.application.command.EnrollmentCommand
import com.hhplus.enrollment.lecture.application.command.EnrollmentHistoryCommand
import com.hhplus.enrollment.lecture.application.info.EnrollmentHistoryInfo
import com.hhplus.enrollment.lecture.application.info.EnrollmentInfo
import com.hhplus.enrollment.lecture.domain.result.EnrollmentResult
import com.hhplus.enrollment.lecture.domain.result.EnrollmentHistoryResult

interface EnrollmentFacade {
    fun enroll(command: EnrollmentCommand): EnrollmentInfo
    fun getEnrollmentHistories(command: EnrollmentHistoryCommand): List<EnrollmentHistoryInfo>
}