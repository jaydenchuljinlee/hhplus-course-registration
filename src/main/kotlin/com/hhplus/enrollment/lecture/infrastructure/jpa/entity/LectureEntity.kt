package com.hhplus.enrollment.lecture.infrastructure.jpa.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "lecture")
@Entity
data class LectureEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(nullable = false, name = "lecture_name")
    var lectureName: String,
    @Column(nullable = true, name = "description")
    var description: String = "",
    @Column(nullable = false, name = "tutor_id")
    var tutorId: Long,
    @Column(nullable = false, name = "capacity")
    var capacity: Int = 0,
    @Column(nullable = false, name = "open_yn")
    var openYn: Char = 'Y',
    @Column(nullable = false, name = "apply_start_dt")
    var applyStartDt: LocalDateTime,
    @Column(nullable = false, name = "apply_end_dt")
    var applyEndDt: LocalDateTime
)