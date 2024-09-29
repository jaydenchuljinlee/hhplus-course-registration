package com.hhplus.enrollment.lecture.application

import com.hhplus.enrollment.lecture.application.command.EnrollmentCommand
import com.hhplus.enrollment.lecture.application.command.EnrollmentHistoryCommand
import com.hhplus.enrollment.lecture.application.info.EnrollmentHistoryInfo
import com.hhplus.enrollment.lecture.application.info.EnrollmentInfo
import com.hhplus.enrollment.lecture.domain.EnrollmentService
import org.springframework.stereotype.Service

@Service
class EnrollmentFacadeImpl(
    private val enrollmentService: EnrollmentService
): EnrollmentFacade {
    override fun enroll(command: EnrollmentCommand): EnrollmentInfo {
        val result = enrollmentService.enroll(command.toParam())
        return EnrollmentInfo.from(result)
    }

    override fun getEnrollmentHistories(command: EnrollmentHistoryCommand): List<EnrollmentHistoryInfo> {
        val results = enrollmentService.getEnrollmentHistories(command.toParam())
        return results.map { EnrollmentHistoryInfo.from(it) }
    }
}