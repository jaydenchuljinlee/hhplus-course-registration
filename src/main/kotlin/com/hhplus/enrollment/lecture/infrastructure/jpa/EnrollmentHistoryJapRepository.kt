package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EnrollmentHistoryJapRepository: JpaRepository<EnrollmentHistoryEntity, Long> {
    fun findAllByTraineeId(traineeId: Long): List<EnrollmentHistoryEntity>

    fun findTopByTraineeIdAndLectureIdOrderByCreatedAtDesc(traineeId: Long, lectureId: Long): Optional<EnrollmentHistoryEntity>
}