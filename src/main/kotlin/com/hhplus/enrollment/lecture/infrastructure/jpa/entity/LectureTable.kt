package com.hhplus.enrollment.lecture.infrastructure.jpa.entity

import jakarta.persistence.*

@Table(name = "lecture")
@Entity
data class LectureTable(
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
    var openYn: Char = 'Y'
)