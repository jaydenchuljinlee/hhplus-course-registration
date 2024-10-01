package com.hhplus.enrollment.lecture.application

import com.hhplus.enrollment.lecture.application.info.EnrollmentCommandInfo
import com.hhplus.enrollment.lecture.application.info.EnrollmentHistoryCommandInfo
import com.hhplus.enrollment.lecture.application.info.EnrollmentHistoryInfo
import com.hhplus.enrollment.lecture.application.info.EnrollmentInfo

interface EnrollmentFacade {
    fun enroll(command: EnrollmentCommandInfo): EnrollmentInfo
    fun getEnrollmentHistories(command: EnrollmentHistoryCommandInfo): List<EnrollmentHistoryInfo>
}