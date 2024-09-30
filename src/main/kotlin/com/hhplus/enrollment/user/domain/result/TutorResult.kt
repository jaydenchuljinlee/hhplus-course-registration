package com.hhplus.enrollment.user.domain.result

import com.hhplus.enrollment.user.infrastructure.projection.TutorProjection

data class TutorResult(
    var id: Long,
    var tutorNumber: String,
    var name: String,
    var phoneNumber: String,
    var email: String
) {
    companion object {
        fun from(projection: TutorProjection): TutorResult {
            return TutorResult(
                id = projection.id,
                tutorNumber = projection.tutorNumber,
                name = projection.name,
                phoneNumber = projection.phoneNumber,
                email = projection.email,
            )
        }
    }
}