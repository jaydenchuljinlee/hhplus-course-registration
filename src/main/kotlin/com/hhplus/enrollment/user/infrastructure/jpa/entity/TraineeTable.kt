package com.hhplus.enrollment.user.infrastructure.jpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "trainee")
data class TraineeTable(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(nullable = false, name= "student_number")
    var studentNumber: String,
    @Column(nullable = false, name= "name")
    var name: String,
    @Column(nullable = false, name= "phone_number")
    var phoneNumber: String,
    @Column(nullable = false, name= "email")
    var email: String
)