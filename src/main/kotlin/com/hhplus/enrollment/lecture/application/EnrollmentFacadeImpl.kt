package com.hhplus.enrollment.lecture.application

import com.hhplus.enrollment.lecture.application.info.EnrollmentCommandInfo
import com.hhplus.enrollment.lecture.application.info.EnrollmentHistoryCommandInfo
import com.hhplus.enrollment.lecture.application.info.EnrollmentHistoryInfo
import com.hhplus.enrollment.lecture.application.info.EnrollmentInfo
import com.hhplus.enrollment.lecture.domain.EnrollmentService
import org.springframework.stereotype.Service

@Service
class EnrollmentFacadeImpl(
    private val enrollmentService: EnrollmentService
): EnrollmentFacade {
    override fun enroll(command: EnrollmentCommandInfo): EnrollmentInfo {
        val result = enrollmentService.enroll(command.toData())
        return EnrollmentInfo.from(result)
    }

    override fun getEnrollmentHistories(command: EnrollmentHistoryCommandInfo): List<EnrollmentHistoryInfo> {
        val results = enrollmentService.getEnrollmentHistories(command.toData())
        return results.map { EnrollmentHistoryInfo.from(it) }
    }
}