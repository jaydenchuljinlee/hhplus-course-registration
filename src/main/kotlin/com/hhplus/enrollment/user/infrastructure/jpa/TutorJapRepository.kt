package com.hhplus.enrollment.user.infrastructure.jpa

import com.hhplus.enrollment.user.infrastructure.jpa.entity.TutorTable
import org.springframework.data.jpa.repository.JpaRepository

interface TutorJapRepository: JpaRepository<TutorTable, Long> {
}