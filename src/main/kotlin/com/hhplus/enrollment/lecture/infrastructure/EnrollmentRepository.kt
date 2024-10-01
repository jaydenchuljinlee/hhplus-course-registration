package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentCommandDto

interface EnrollmentRepository {
    fun enroll(command: EnrollmentCommandDto): EnrollmentDto
    fun countEnrollmentByLectureId(lectureId: Long): Long
}