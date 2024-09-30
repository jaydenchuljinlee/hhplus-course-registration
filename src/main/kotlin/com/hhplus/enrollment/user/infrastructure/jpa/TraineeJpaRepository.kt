package com.hhplus.enrollment.user.infrastructure.jpa

import com.hhplus.enrollment.user.infrastructure.jpa.entity.TraineeTable
import org.springframework.data.jpa.repository.JpaRepository

interface TraineeJpaRepository: JpaRepository<TraineeTable, Long> {
}