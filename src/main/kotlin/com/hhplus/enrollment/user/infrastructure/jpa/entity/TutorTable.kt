package com.hhplus.enrollment.user.infrastructure.jpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "tutor")
data class TutorTable(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(nullable = false, name= "tutor_number")
    var tutorNumber: String,
    @Column(nullable = false, name= "name")
    var name: String,
    @Column(nullable = false, name= "phone_number")
    var phoneNumber: String,
    @Column(nullable = false, name= "email")
    var email: String
)