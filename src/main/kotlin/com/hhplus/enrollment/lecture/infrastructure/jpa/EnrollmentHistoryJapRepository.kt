package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnrollmentHistoryJapRepository: JpaRepository<EnrollmentHistoryEntity, Long> {
    fun findAllByTraineeId(traineeId: Long): List<EnrollmentHistoryEntity>
}