package com.hhplus.enrollment.lecture.infrastructure.jpa

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureTable
import org.springframework.data.jpa.repository.JpaRepository

interface LectureJpaRepository: JpaRepository<LectureTable, Long> {}