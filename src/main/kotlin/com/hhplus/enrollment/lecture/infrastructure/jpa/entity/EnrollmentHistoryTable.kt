package com.hhplus.enrollment.lecture.infrastructure.jpa.entity

import jakarta.persistence.*

@Table(name = "enrollment_history")
@Entity
data class EnrollmentHistoryTable(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "enrollment_id", nullable = false)
    var enrollmentId: Long,
    @Column(name = "trainee_id", nullable = false)
    var traineeId: Long,
    @Column(name = "lecture_id", nullable = false)
    var lectureId: Long,
    @Column(name = "accept_yn", nullable = false)
    var acceptYn: Char = 'Y',
    @Column(name = "cancel_yn", nullable = false)
    var cancelYn: Char = 'N',
)