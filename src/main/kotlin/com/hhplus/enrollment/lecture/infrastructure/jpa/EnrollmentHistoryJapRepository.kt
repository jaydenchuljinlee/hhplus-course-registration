package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentHistoryTable
import org.springframework.data.jpa.repository.JpaRepository

interface EnrollmentHistoryJapRepository: JpaRepository<EnrollmentHistoryTable, Long> {
    fun findAllByTraineeId(traineeId: Long): List<EnrollmentHistoryTable>
}