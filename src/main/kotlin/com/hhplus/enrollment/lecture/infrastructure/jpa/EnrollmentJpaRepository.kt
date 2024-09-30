package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnrollmentJpaRepository: JpaRepository<EnrollmentTable, Long> {
}