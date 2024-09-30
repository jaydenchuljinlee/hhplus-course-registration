package com.hhplus.enrollment.user.infrastructure.projection

import com.hhplus.enrollment.user.infrastructure.jpa.entity.TutorTable

data class TutorProjection(
    var id: Long,
    var tutorNumber: String,
    var name: String,
    var phoneNumber: String,
    var email: String
) {
    companion object {
        fun from(tutorTable: TutorTable): TutorProjection {
            return TutorProjection(
                id = tutorTable.id,
                tutorNumber = tutorTable.tutorNumber,
                name = tutorTable.name,
                phoneNumber = tutorTable.phoneNumber,
                email = tutorTable.email
            )
        }
    }
}