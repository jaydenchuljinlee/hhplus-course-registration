package com.hhplus.enrollment.lecture.infrastructure.jpa.entity

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Table(name = "enrollment")
@Entity
data class EnrollmentTable(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @NotNull
    var traineeId: Long,
    @NotNull
    var lectureId: Long,
    var acceptYn: Char = 'Y',

) {
}